package com.andre.estoque.api.dto;

import java.math.BigDecimal;
import java.util.List;

import com.andre.estoque.domain.model.ItensPedido;
import com.andre.estoque.domain.model.TipoPedidoEstoque;

public class PedidoEstoqueDto {
	private Long id;
	private FilialDto filial;
	private TipoPedidoEstoque tipo;
	private String observacao;
	BigDecimal valorTotal;
	List<ItensPedido> listaItensPedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FilialDto getFilial() {
		return filial;
	}

	public void setFilial(FilialDto filial) {
		this.filial = filial;
	}

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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItensPedido> getListaItensPedido() {
		return listaItensPedido;
	}

	public void setListaItensPedido(List<ItensPedido> listaItensPedido) {
		this.listaItensPedido = listaItensPedido;
	}

}
