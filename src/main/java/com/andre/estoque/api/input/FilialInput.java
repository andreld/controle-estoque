package com.andre.estoque.api.input;

import javax.validation.constraints.NotBlank;

public class FilialInput {
	
	@NotBlank
	String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
