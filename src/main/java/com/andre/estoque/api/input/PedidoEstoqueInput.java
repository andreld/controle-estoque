package com.andre.estoque.api.input;

import javax.validation.constraints.NotNull;

import com.andre.estoque.domain.model.TipoPedidoEstoque;

public class PedidoEstoqueInput {
	@NotNull
	private TipoPedidoEstoque tipo;
	
	private String observacao;

	public TipoPedidoEstoque getTipo() {
		return tipo;
	}

	public void setTipo(TipoPedidoEstoque tipo) {
		this.tipo = tipo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
