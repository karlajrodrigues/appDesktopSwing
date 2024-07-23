package model.entity;

public class Livro {
	private Integer codLivro;
	private String capa;
	private Integer quantidadePaginas;
	private String titulo;
	private String autor;
	private String categoria;
	private Integer anoPublicacao;
	private String editora;
	private Double preco;
	
	public Livro() {
		
	}
	
	public Livro(Integer codLivro, String titulo, String capa, String autor, String categoria,
            Integer anoPublicacao, String editora, Integer quantidadePaginas, Double preco) {
	   this.codLivro = codLivro;
	   this.titulo = titulo;
	   this.capa = capa;
	   this.autor = autor;
	   this.categoria = categoria;
	   this.anoPublicacao = anoPublicacao;
	   this.editora = editora;
	   this.quantidadePaginas = quantidadePaginas;
	   this.preco = preco;
	}
	public Integer getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(Integer codLivro) {
		this.codLivro = codLivro;
	}
	public String getCapa() {
		return capa;
	}
	public void setCapa(String capa) {
		this.capa = capa;
	}
	public Integer getQuantidadePaginas() {
		return quantidadePaginas;
	}
	public void setQuantidadePaginas(Integer quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
