package com.andre.estoque.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItensPedido {
	
	@EmbeddedId
    private ItensPedidoId id;
	
	@ManyToOne
	@JoinColumn(name="estoque_id", insertable = false, updatable = false)
	private Estoque estoque;
	
	@ManyToOne
	@JoinColumn(name="pedidoestoque_id", insertable = false, updatable = false)
	private PedidoEstoque pedidoEstoque;
	
	private int quantidade;
	
	@Column(name = "valortotal")
	private BigDecimal valorTotal;
	
	@Enumerated(EnumType.STRING)
	private StatusItemPedido status;

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public PedidoEstoque getPedidoEstoque() {
		return pedidoEstoque;
	}

	public void setPedidoEstoque(PedidoEstoque pedidoEstoque) {
		this.pedidoEstoque = pedidoEstoque;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusItemPedido getStatus() {
		return status;
	}

	public void setStatus(StatusItemPedido status) {
		this.status = status;
	}
	
}
