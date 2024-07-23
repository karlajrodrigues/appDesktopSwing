package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.CalculoController;
import controller.IController;

public class CalculoForm extends JFrame {
    private JLabel lbValorPrincipal, lbTaxa, lbTipo, lbMeses, lbMontante, lbTotJuros;
    private JTextField txtValorPrincipal, txtTaxa, txtMeses, txtMontante, txtTotJuros;
    private JRadioButton rdBtnSimples, rBtnComposto;
    private JButton btnCalcular;

    private IController controller;    

    public JTextField getTxtValorPrincipal() {
        return txtValorPrincipal;
    }

    public JTextField getTxtTaxa() {
        return txtTaxa;
    }

    public JTextField getTxtMeses() {
        return txtMeses;
    }

    public JTextField getTxtMontante() {
        return txtMontante;
    }

    public JTextField getTxtTotJuros() {
        return txtTotJuros;
    }

    public JRadioButton getRdBtnSimples() {
        return rdBtnSimples;
    }

    public CalculoForm() {
        super("Cálculo de Juros");
        Container form = getContentPane();
        setLayout(null);

        lbValorPrincipal = new JLabel("Capital");
        lbTaxa = new JLabel("Taxa % a.m");
        lbTipo = new JLabel("Tipo de Juros");
        lbMeses = new JLabel("N° de Meses");

        //Coluna(horizontal), linha(vertical), comprimento do campo, altura do campo
        lbValorPrincipal.setBounds(10, 10, 240, 15);
        lbTaxa.setBounds(10, 50, 240, 15);
        lbMeses.setBounds(10, 90, 240, 15);
        lbTipo.setBounds(10, 130, 240, 15);

        form.add(lbValorPrincipal);
        form.add(lbTaxa);
        form.add(lbTipo);
        form.add(lbMeses);

        txtValorPrincipal = new JTextField();
        txtTaxa = new JTextField();
        txtMeses = new JTextField();

        txtValorPrincipal.setBounds(10, 25, 265, 20);
        txtTaxa.setBounds(10, 65, 265, 20);
        txtMeses.setBounds(10, 105, 265, 20);

        form.add(txtValorPrincipal);
        form.add(txtTaxa);
        form.add(txtMeses);

        rdBtnSimples = new JRadioButton("Simples");
        rBtnComposto = new JRadioButton("Compostos");

        ButtonGroup group = new ButtonGroup();
        group.add(rdBtnSimples);
        group.add(rBtnComposto);

        rdBtnSimples.setBounds(10, 145, 80, 20);
        rBtnComposto.setBounds(130, 145, 100, 20);

        rdBtnSimples.setSelected(true);

        form.add(rdBtnSimples);
        form.add(rBtnComposto);

        btnCalcular = new JButton("Calcular");

        btnCalcular.setBounds(280, 145, 100, 20);

        form.add(btnCalcular);

        lbTotJuros = new JLabel("Total de Juros");
        lbMontante = new JLabel("Montante");

        lbTotJuros.setBounds(10, 185, 240, 20);
        lbMontante.setBounds(10, 225, 240, 20);

        form.add(lbTotJuros);
        form.add(lbMontante);

        txtTotJuros = new JTextField();
        txtMontante = new JTextField();

        txtTotJuros.setEditable(false);
        txtMontante.setEditable(false);

        txtTotJuros.setBounds(10, 205, 240, 20);
        txtMontante.setBounds(10, 245, 240, 20);

        form.add(txtTotJuros);
        form.add(txtMontante);

        setSize(400, 310);
        setVisible(true);
        setLocationRelativeTo(null);
        
        btnCalcular.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickCalculo();
                    }
                }
        );

    }

    private void onClickCalculo() {

        controller = new CalculoController();

        controller.executa(this);
    }

    public static void main(String[] args) {
        CalculoForm form = new CalculoForm();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

