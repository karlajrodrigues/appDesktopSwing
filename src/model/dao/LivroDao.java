package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.Livro;

public class LivroDao extends GenericDao<Livro>{
	
	 public void salvar(Livro l) {
	        String insert = "INSERT INTO " +
	                "livro (capa, quantidade_pagina, titulo, autor, categoria, ano_publicacao, "
	                + "editora, preco) " +
	                "VALUES (?,?,?,?,?,?,?,?)";
	        save(insert, l.getCapa(), l.getQuantidadePaginas(), l.getTitulo(), l.getAutor(), 
	        		l.getCategoria(),
	        		l.getAnoPublicacao(), l.getEditora(), l.getPreco()
	        );
	  }
	 
	 public void atualizarLivro(Livro livro) {
	        try (Connection connection = getConnection()) {
	            String updateQuery = "UPDATE livro SET capa = ?, quantidade_pagina = ?,"
	            		+ " titulo = ?, autor = ?, categoria = ?, ano_publicacao = ?,"
	            		+ " editora = ?, preco = ? WHERE cod_livro = ?";
	            PreparedStatement statement = connection.prepareStatement(updateQuery);
	            statement.setString(1, livro.getCapa());
	            statement.setInt(2, livro.getQuantidadePaginas());
	            statement.setString(3, livro.getTitulo());
	            statement.setString(4, livro.getAutor());
	            statement.setString(5, livro.getCategoria());
	            statement.setInt(6, livro.getAnoPublicacao());
	            statement.setString(7, livro.getEditora());
	            statement.setDouble(8, livro.getPreco());
	            statement.setDouble(9, livro.getCodLivro());
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Livro atualizado com sucesso!");
	            } else {
	                System.out.println("Falha ao atualizar o livro.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
