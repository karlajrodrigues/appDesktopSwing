package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import view.LivroForm;

public class TelaLivros extends JFrame {
    private JTable tabelaLivros;
    private DefaultTableModel modeloTabela;

    public TelaLivros() {
        super("Lista de Livros");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar modelo da tabela
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Capa");
        modeloTabela.addColumn("Título");
        modeloTabela.addColumn("Autor");
        modeloTabela.addColumn("Categoria");
        modeloTabela.addColumn("Ano Publicação");
        modeloTabela.addColumn("Editora");
        modeloTabela.addColumn("Preço");

        // Criar tabela com modelo
        tabelaLivros = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaLivros);
        add(scrollPane, BorderLayout.CENTER);

        // Botões
        JPanel painelBotoes = new JPanel();
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnIncluir = new JButton("Incluir");
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnIncluir);
        add(painelBotoes, BorderLayout.SOUTH);

        // Adicionar ação para o botão "Editar"
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaLivros.getSelectedRow();
                if (linhaSelecionada != -1) {
                    int idLivro = (int) tabelaLivros.getValueAt(linhaSelecionada, 0);
                    // Chame o método de edição passando o ID do livro
                    editarLivro(idLivro);
                    // Atualizar a tabela após a edição
                    carregarDados();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um livro para editar.");
                }
            }
        });

        // Adicionar ação para o botão "Excluir"
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaLivros.getSelectedRow();
                if (linhaSelecionada != -1) {
                    int idLivro = (int) tabelaLivros.getValueAt(linhaSelecionada, 0);
                    // Chame o método de exclusão passando o ID do livro
                    excluirLivro(idLivro);
                    // Atualizar a tabela após a exclusão
                    carregarDados();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um livro para excluir.");
                }
            }
        });
        
     // Adicionar ação para o botão "Incluir"
		/*
		 * btnIncluir.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { LivroForm form = new
		 * LivroForm(); form.main(null); carregarDados(); } });
		 */
        btnIncluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Criar uma nova instância do formulário LivroForm
                LivroForm form = new LivroForm();
                
                // Definir operação de fechar janela
                form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                // Exibir o formulário LivroForm
                form.setVisible(true);
                form.showForm();
                // Carregar os dados após fechar o formulário de inclusão (opcional)
                form.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        carregarDados();
                    }
                });
            }
        });


        // Carregar dados da tabela
        carregarDados();

        setVisible(true);
    }

    private void carregarDados() {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Conectar ao banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/appmvc", "root", "root");

            // Limpar a tabela antes de carregar os novos dados
            modeloTabela.setRowCount(0);

            // Preparar e executar consulta SQL
            String sql = "SELECT cod_livro, capa, titulo, autor, categoria, ano_publicacao, editora, preco FROM livro";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // Preencher tabela com resultados da consulta
            while (rs.next()) {
                Object[] linha = {
	                rs.getInt("cod_livro"),
	                rs.getString("capa"),
	                rs.getString("titulo"),
	                rs.getString("autor"),
	                rs.getString("categoria"),
	                rs.getInt("ano_publicacao"),
	                rs.getString("editora"),
	                rs.getDouble("preco")
                };
                modeloTabela.addRow(linha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar recursos
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void editarLivro(int idLivro) {
        // Aqui você pode abrir uma nova tela ou diálogo para editar os dados do livro,
        // ou você pode implementar a edição diretamente nesta classe.
        // Por exemplo, você pode executar uma atualização no banco de dados usando o ID do livro.
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/appmvc", "root", "root")) {
            String sql = "UPDATE livro SET titulo = ?, autor = ?, categoria = ?, ano_publicacao = ?, editora = ?, preco = ? WHERE cod_livro = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            // Suponha que você tenha uma forma de obter os novos valores do livro a serem atualizados
            pstmt.setString(1, "Novo Título");
            pstmt.setString(2, "Novo Autor");
            pstmt.setString(3, "Nova Categoria");
            pstmt.setInt(4, 2022);
            pstmt.setString(5, "Nova Editora");
            pstmt.setDouble(6, 25.99);
            pstmt.setInt(7, idLivro);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void excluirLivro(int idLivro) {
        // Exclui o livro do banco de dados com base no ID fornecido
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/appmvc", "root", "root")) {
            String sql = "DELETE FROM livro WHERE cod_livro = ?";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, idLivro);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	/*
	 * public static void main(String[] args) {
	 * SwingUtilities.invokeLater(TelaLivros::new); }
	 */
    public void showForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 410);
        setVisible(true);
        setLocationRelativeTo(null);
        SwingUtilities.invokeLater(TelaLivros::new);
    }

}
