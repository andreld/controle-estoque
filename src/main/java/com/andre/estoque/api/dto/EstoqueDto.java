package com.andre.estoque.api.dto;

public class EstoqueDto {
	private int id;
	private FilialDto filial;
	private ProdutoDto produto;
	private int quantidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FilialDto getFilial() {
		return filial;
	}
	public void setFilial(FilialDto filial) {
		this.filial = filial;
	}
	public ProdutoDto getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
