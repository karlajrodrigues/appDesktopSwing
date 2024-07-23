package controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import model.entity.Livro;
import model.service.LivroService;
import view.LivroForm;

public class LivroController implements IController {
	private Livro livro;
    private LivroForm frame;

    public void executa(Object view) {
        frame = (LivroForm) view;
        livro = new Livro();
        livro.setPreco(
                Double.parseDouble(frame.getTextFieldPreco().getText())
        );
        
        livro.setCapa(frame.getTextFieldCapa().getText());
        livro.setAutor(frame.getTextFieldAutor().getText());
        livro.setAnoPublicacao(Integer.parseInt(frame.getTextFieldAnoPublicacao().getText()));
        livro.setCategoria(frame.getTextFieldCategoria().getText());
        livro.setEditora(frame.getTextFieldEdidota().getText());
        livro.setQuantidadePaginas(Integer.parseInt(frame.getTextFieldQuantidadePagina().getText()));
        livro.setTitulo(frame.getTextFieldTitulo().getText());
        cadastrar(livro);

    }
    
    public List<Livro> pesquisar(Object view) {
    	System.out.println("Pesquisar Livro");
    	LivroService service = new LivroService();
    	
    	List<Livro> listLivro;
    	listLivro = service.pesquisar(livro);
		
    	return listLivro;
    }
    
    public void alterar (Object view) {
    	LivroService service = new LivroService();
    	int codLivro = Integer.parseInt(frame.getCodLivro().getText());	
        String titulo = frame.getTextFieldTitulo().getText();
        String capa = frame.getTextFieldCapa().getText();
        String autor = frame.getTextFieldAutor().getText();
        String categoria = frame.getTextFieldCategoria().getText();
        int anoPublicacao = Integer.parseInt(frame.getTextFieldAnoPublicacao().getText());
        String editora = frame.getTextFieldEdidota().getText();
        int quantidadePaginas = Integer.parseInt(frame.getTextFieldQuantidadePagina().getText());
        double preco = Double.parseDouble(frame.getTextFieldPreco().getText());

        Livro livro = new Livro(codLivro, titulo, capa, autor, categoria, anoPublicacao, editora, quantidadePaginas, preco);
        service.alterarLivro(livro);
    }
    
    public void excluir(Integer idLivro) {
		
		LivroService service = new LivroService();
		  
		service.excluir(idLivro);
		 
		
    }

    private Livro cadastrar(Livro livro) {
    	LivroService service = new LivroService();

        return service.cadastrar(livro);
    }

    private String doubleFormat(Double aDouble) {
        NumberFormat nf =
                NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        nf.setMaximumFractionDigits(2);
        return nf.format(aDouble);
    }


}
