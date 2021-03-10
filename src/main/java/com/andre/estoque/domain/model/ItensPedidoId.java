package com.andre.estoque.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItensPedidoId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "estoque_id")
	private int estoqueId;
	@Column(name = "pedidoestoque_id")
	private int pedidoEstoqueId;
}
