package controller;

import java.util.List;

import model.entity.Livro;

public interface IController {
    public void executa(Object view);
    public List<Livro> pesquisar(Object view);
    public void alterar(Object view);
    public void excluir(Integer codigo);
}
