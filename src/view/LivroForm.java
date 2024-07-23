package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.IController;
import controller.LivroController;
import model.entity.Livro;

public class LivroForm extends JFrame{
	// Atributos da tela de cadastro de livro
	private JLabel labelCapa, labelQuantidadePagina, labelTitulo,
	labelAutor, labelCategoria, labelAnoPublicacao, labelEditora, 
	labelPreco;
	
	private JTextField textFieldCapa, textFieldQuantidadePagina, textFieldTitulo,
	textFieldAutor, textFieldCategoria, textFieldAnoPublicacao, textFieldEditora, 
	textFieldPreco, codLivro;
	
	private	 JTable tabelaLivros ;

	private JButton btnCadastrar, btnPesquisar, btnExcluir, btnSelecionar, btnAlterar;

    private IController controller;    

    public JTextField getCodLivro() {
		return codLivro;
	}
    
	public JTextField getTextFieldCapa() {
		return textFieldCapa;
	}

	public JTextField getTextFieldQuantidadePagina() {
		return textFieldQuantidadePagina;
	}

	public JTextField getTextFieldTitulo() {
		return textFieldTitulo;
	}

	public JTextField getTextFieldAutor() {
		return textFieldAutor;
	}

	public JTextField getTextFieldCategoria() {
		return textFieldCategoria;
	}

	public JTextField getTextFieldAnoPublicacao() {
		return textFieldAnoPublicacao;
	}

	public JTextField getTextFieldEdidota() {
		return textFieldEditora;
	}

	public JTextField getTextFieldPreco() {
		return textFieldPreco;
	}


	//metodo construtor
	 public LivroForm() {
	        super("Livraria da prof. Karla");
	        Container form = getContentPane();
	        setLayout(null);
	        
			/*
			 * JLabel tituloTela= new JLabel("Manter Livro"); tituloTela.setBounds(10, 1,
			 * 240, 60);
			 */
	        JLabel titulo= new JLabel("Titulo");
	        titulo.setBounds(10, 10, 240, 15);

	        JLabel nomeDaCapa = new JLabel("Tipo de Capa");
	        nomeDaCapa.setBounds(10, 50 ,240,15);
	        
	        JLabel quantidadePaginas = new JLabel("Quantidade de Páginas");
	        quantidadePaginas.setBounds(10, 90 ,240,15);
	        
	        JLabel autor = new JLabel("Autor");
	        autor.setBounds(10, 130 ,240,15);
	        
	        JLabel categoria = new JLabel("Categoria");
	        categoria.setBounds(10, 170 ,240,15);
	        
	        JLabel anoPublicacao = new JLabel("Ano publicação");
	        anoPublicacao.setBounds(10, 210, 240, 15);
	        
	        JLabel editora = new JLabel("Editora");
	        editora.setBounds(10, 250, 240, 15);
	        
	        JLabel preco = new JLabel("Preço");
	        preco.setBounds(10, 290, 240, 15);
	        
	        
	        //form.add(tituloTela);
	        form.add(titulo);
	        form.add(nomeDaCapa);
	        form.add(quantidadePaginas);
	        form.add(autor);
	        form.add(categoria);
	        form.add(anoPublicacao);
	        form.add(editora);
	        form.add(preco);
	        
	        codLivro = new JTextField();
	        textFieldTitulo = new JTextField();
	        textFieldAutor = new JTextField();
	        textFieldCapa = new JTextField();
	        textFieldQuantidadePagina = new JTextField();
	        textFieldAutor = new JTextField();
	        textFieldCategoria = new JTextField();
	        textFieldAnoPublicacao = new JTextField();
	        textFieldEditora = new JTextField();
	        textFieldPreco = new JTextField();
	        
	        textFieldTitulo.setBounds(10, 25, 265, 20);
	        textFieldAutor.setBounds(10, 25, 265, 20);
	        textFieldCapa.setBounds(10, 65, 265, 20);
	        textFieldQuantidadePagina.setBounds(10, 105, 265, 20);
	        textFieldAutor.setBounds(10, 145, 265, 20);
	        textFieldCategoria.setBounds(10,185,265,20);
	        textFieldAnoPublicacao.setBounds(10,225,265,20);
	        textFieldEditora.setBounds(10,265,265,20);
	        textFieldPreco.setBounds(10,305,265,20);
	        
	        
	        form.add(textFieldTitulo);
	        form.add(textFieldAutor);
	        form.add(textFieldCapa);
	        form.add(textFieldQuantidadePagina);
	        form.add(textFieldAutor);
	        form.add(textFieldCategoria);
	        form.add(textFieldAnoPublicacao);
	        form.add(textFieldEditora);
	        form.add(textFieldPreco);
	        
	        
	        
	        btnCadastrar= new JButton("Cadastrar");
	        btnCadastrar.setBounds(280, 145, 100, 20);
	        form.add(btnCadastrar);
	        
	        btnPesquisar= new JButton("Pesquisar");
	        btnPesquisar.setBounds(280, 185, 100, 20);
	        form.add(btnPesquisar);
	        
	        btnSelecionar = new JButton("Selecionar Registro");
	        btnSelecionar.setBounds(280, 225, 100, 20);
	        form.add(btnSelecionar);
	        
	        btnAlterar = new JButton("Alterar");
	        btnAlterar.setBounds(280, 265, 100, 20);
	        form.add(btnAlterar);
	        
	        btnExcluir= new JButton("Excluir");
	        btnExcluir.setBounds(280, 305, 100, 20);
	        form.add(btnExcluir);
	        
	        setSize(500, 410);
	        setVisible(true);
	        setLocationRelativeTo(null);
	        
	        btnCadastrar.addActionListener(
	                new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        onClickCadastrar();
	                    }
	                }
	        );
	        
	        btnPesquisar.addActionListener(
	                new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        onClickPesquisar();
//	                        TelaLivros tela = new TelaLivros();
//	                        tela.showForm();
	                    }
	                }
	        );
	        
	        btnSelecionar.addActionListener(
	                new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        onClickSelecionar();
	                    }
	                }
	        );
	        
	        btnAlterar.addActionListener(
	        		new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							onClickAlterar();
						}
	        		}
	        );
	        
	        btnExcluir.addActionListener(
	                new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        onClickExcluir();
	                    }
	                }
	        );
	 }
	 public LivroForm(String teste) {
		 
	 }
	 
	 private void onClickAlterar() {
		 controller = new LivroController();
		 controller.alterar(this);
	 }
	 
	 private void onClickCadastrar() {
		 controller = new LivroController();
	     controller.executa(this);
	 }

	 private void onClickPesquisar() {
		 controller = new LivroController();
		 List<Livro> livros = controller.pesquisar(this);
		 DefaultTableModel modeloTabela = new DefaultTableModel();
		 modeloTabela.addColumn("Código Livro ");
		 modeloTabela.addColumn("Capa");
		 modeloTabela.addColumn("Título");
		 modeloTabela.addColumn("Autor");
		 modeloTabela.addColumn("Categoria");
		 modeloTabela.addColumn("Ano Publicação");
		 modeloTabela.addColumn("Editora");
		 modeloTabela.addColumn("Preço");
		 modeloTabela.addColumn("Quant. Páginas");

	    for (Livro livro : livros) {
	        Object[] row = new Object[9];
	        row[0] = livro.getCodLivro();
	        row[1] = livro.getCapa();
	        row[2] = livro.getTitulo();
	        row[3] = livro.getAutor();
	        row[4] = livro.getCategoria();
	        row[5] = livro.getAnoPublicacao();
	        row[6] = livro.getEditora();
	        row[7] = livro.getPreco();
	        row[8] = livro.getQuantidadePaginas();
	        modeloTabela.addRow(row);
	    }
	    if(tabelaLivros != null ) {
	    	tabelaLivros.setModel(modeloTabela);
	    }else {
	    	tabelaLivros = new JTable(modeloTabela);
	    }
	    JScrollPane scrollPane = new JScrollPane(tabelaLivros);
	    scrollPane.setBounds(10, 340, 465, 150); // Adjust the bounds as needed
	    getContentPane().add(scrollPane);
	 }
	 
	 private void onClickSelecionar() {
		 controller = new LivroController();
		 
		 int linhaSelecionada = tabelaLivros.getSelectedRow();
         if (linhaSelecionada != -1) {
             
        	 codLivro.setText(String.valueOf( tabelaLivros.getValueAt(linhaSelecionada, 0)));
             
             String capa = (String) tabelaLivros.getValueAt(linhaSelecionada, 1);
             textFieldCapa.setText(capa);
             
             String titulo = (String) tabelaLivros.getValueAt(linhaSelecionada, 2);
             textFieldTitulo.setText(titulo);
             
             String autor = (String) tabelaLivros.getValueAt(linhaSelecionada, 3);
             textFieldAutor.setText(autor);
             
             String categoria = (String) tabelaLivros.getValueAt(linhaSelecionada, 4);
             textFieldCategoria.setText(categoria);
             
             String anoPublicacao = String.valueOf(tabelaLivros.getValueAt(linhaSelecionada, 5));
             textFieldAnoPublicacao.setText(anoPublicacao);
             
             String editora = (String) tabelaLivros.getValueAt(linhaSelecionada, 6);
             textFieldEditora.setText(editora);
             
             String preco = String.valueOf(tabelaLivros.getValueAt(linhaSelecionada, 7));
             textFieldPreco.setText(preco);
             
             String quantidadePaginas = String.valueOf(tabelaLivros.getValueAt(linhaSelecionada, 8));
             textFieldQuantidadePagina.setText(quantidadePaginas);
             
             
         } else {
             JOptionPane.showMessageDialog(null, "Selecione um livro para alterar.");
         }
	 }
	 
	 private void onClickExcluir() {
		 controller = new LivroController();
		 int linhaSelecionada = tabelaLivros.getSelectedRow();
         if (linhaSelecionada != -1) {
             int idLivro = (int) tabelaLivros.getValueAt(linhaSelecionada, 0);
             // Chame o método de exclusão passando o ID do livro
             controller.excluir(idLivro);
             // Atualizar a tabela após a exclusão
             onClickPesquisar();
         } else {
             JOptionPane.showMessageDialog(null, "Selecione um livro para excluir.");
         }
	 }

	 
	// Método para exibir o formulário
	    public void showForm() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(500, 410);
	        setVisible(true);
	        setLocationRelativeTo(null);
	    }
	   
	    
	    public static void main(String[] args) { LivroForm form = new LivroForm();
		 form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 }

}
