package com.andre.estoque.api.input;

import javax.validation.constraints.NotNull;

public class EstoqueInput {
	@NotNull
	private int quantidade;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
