package model.service;

import java.util.List;

import model.dao.LivroDao;
import model.entity.Livro;

public class LivroService {
	private LivroDao dao;

    public LivroService() {
        this.dao = new LivroDao();
    }

    public LivroDao getDao() {
        return dao;
    }

    public Livro cadastrar(Livro livro) {

        salvar(livro);

        return livro;
    }
    
    public void salvar(Livro livro) {
        dao.salvar(livro);
    }
    
    public void excluir(Integer codigo) {
        dao.excluirLivro(codigo);
    }
    
    public List<Livro> pesquisar(Livro livro){
    	return dao.listAll();
    }

	public void alterarLivro(Livro livro) {
		dao.atualizarLivro(livro);
		
	}
}
