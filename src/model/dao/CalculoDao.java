package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.Calculo;
import model.entity.Livro;

public class CalculoDao extends GenericDao<Calculo> {

    public void salvar(Calculo c) {
        String insert = "INSERT INTO " +
                "CALCULOS (TIPO, VALOR_PRINCIPAL, TAXA, MESES, MONTANTE, TOTAL_DE_JUROS) " +
                "VALUES (?,?,?,?,?,?)";
        save(insert, c.getTipo().getDescricao(), c.getValorPrincipal(), c.getTaxa(),
                c.getMeses(), c.getMontante(), c.getTotalJuros()
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
