package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Livro;

public abstract class GenericDao<T> {
    private Connection connection;

    protected GenericDao() {
        this.connection = new Conexao().getConnection();
    }

    protected Connection getConnection() {
        return connection;
    }

    public void save(String insertSql, Object... parametros) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(insertSql);
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public List<T> list(String selectSql, DadosMapper<T> mapper, Object... parametros) {
        List<T> lista = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(selectSql);
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                T objeto = mapper.map(rs);
                lista.add(objeto);
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return lista;
    }

    public List<Livro> list(){
    	List<Livro> listaLivro = new ArrayList<Livro>();
    	try {
    		String sql = "Select * from Livro";
    		PreparedStatement pstnt = connection.prepareStatement(sql);
    		ResultSet rs = pstnt.executeQuery();
    		while(rs.next()) {
    			Livro livro = new Livro();
    			livro.setCodLivro(rs.getInt("cod_livro"));
    			livro.setCapa(rs.getString("capa"));
    			livro.setQuantidadePaginas(rs.getInt("quantidade_pagina"));
    			livro.setTitulo(rs.getString("titulo"));
    			livro.setAutor(rs.getString("autor"));
    			livro.setCategoria(rs.getString("categoria"));
    			livro.setAnoPublicacao(rs.getInt("ano_publicacao"));
    			livro.setEditora(rs.getString("editora"));
    			livro.setPreco(rs.getDouble("preco"));
    			listaLivro.add(livro);
    		}
    		pstnt.close();
    		return listaLivro;    		
    	}catch (Exception e) {
    		e.printStackTrace();
    	}finally {
    		close();
    	}
    	return null;
    }
    public List<Livro>listAll(){
    	List<Livro> listaLivros = new ArrayList();
		try {
            String sql = "SELECT * FROM livro";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setCodLivro(rs.getInt("cod_livro"));
                livro.setCapa(rs.getString("capa"));
                livro.setQuantidadePaginas(rs.getInt("quantidade_pagina"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setAnoPublicacao(rs.getInt("ano_publicacao"));
                livro.setEditora(rs.getString("editora"));
                livro.setPreco(rs.getDouble("preco"));
                listaLivros.add(livro);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar todos os livros: " + e.getMessage());
        }
        return listaLivros;
    }
    public void update(String updateSql, Object... parametros) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(updateSql);
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void excluirLivro(int codigo) {
        String deleteSql = "DELETE FROM Livro WHERE cod_livro = ?";
        
        try {
            PreparedStatement pstmt = connection.prepareStatement(deleteSql);
            pstmt.setInt(1, codigo); // Set the value of the parameter
            pstmt.executeUpdate(); // Execute the delete operation
            
            System.out.println("Livro excluído com sucesso!");
            
            pstmt.close(); // Close the PreparedStatement
        } catch (SQLException e) {
            System.out.println("Erro ao excluir o livro: " + e.getMessage());
        }
    }
    
    // Interface para mapeamento de dados do ResultSet para objetos do tipo T
    public interface DadosMapper<T> {
        T map(ResultSet resultSet) throws SQLException;
    }
    
    protected void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}