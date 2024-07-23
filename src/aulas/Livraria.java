package aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Livraria extends JFrame {
    private JTextField textFieldTitulo;
    private JTextField textFieldAutor;
    private JButton buttonSalvar;
    private JButton buttonBuscar;
    private Connection connection;

    public Livraria() {
        setTitle("CRUD de Livro");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel labelTitulo = new JLabel("Título:");
        textFieldTitulo = new JTextField();
        JLabel labelAutor = new JLabel("Autor:");
        textFieldAutor = new JTextField();
        buttonSalvar = new JButton("Salvar");
        buttonBuscar = new JButton("Buscar");

        panel.add(labelTitulo);
        panel.add(textFieldTitulo);
        panel.add(labelAutor);
        panel.add(textFieldAutor);
        panel.add(buttonSalvar);
        panel.add(buttonBuscar);

        buttonSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarLivro();
            }
        });

        buttonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarLivro();
            }
        });

        add(panel);
        setVisible(true);

        conectarBancoDados();
    }

    private void conectarBancoDados() {
        try {
            // Conectando ao banco de dados MySQL
            String url = "jdbc:mysql://localhost:3306/appmvc";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void salvarLivro() {
        String titulo = textFieldTitulo.getText();
        String autor = textFieldAutor.getText();

        try {
            // Executando a inserção na tabela de livros
            String sql = "INSERT INTO livros (titulo, autor) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, titulo);
            statement.setString(2, autor);
            statement.executeUpdate();
            System.out.println("Livro salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        limparCampos();
    }

    private void buscarLivro() {
        String titulo = textFieldTitulo.getText();

        try {
            // Buscando o livro pelo título na tabela de livros
            String sql = "SELECT * FROM livros WHERE titulo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, titulo);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                textFieldAutor.setText(resultSet.getString("autor"));
                System.out.println("Livro encontrado:");
                System.out.println("Título: " + resultSet.getString("titulo"));
                System.out.println("Autor: " + resultSet.getString("autor"));
            } else {
                System.out.println("Livro não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        textFieldTitulo.setText("");
        textFieldAutor.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Livraria();
            }
        });
    }
}