package br.com.jdbc.modelo;

public class Produto {
	private Integer id;
	private String nome;
	private String descricao;
	
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		//%d,%s,%s serão substituidos por id, nome e descrição;
		return String.format("O produto é: %d, %s, %s", this.id, this.nome, this.descricao);
	}

}
