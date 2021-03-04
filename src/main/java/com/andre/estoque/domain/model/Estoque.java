package com.andre.estoque.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.andre.estoque.domain.exception.NegocioException;;

@Entity
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="filial_id")
	private Filial filial;
	
	@ManyToOne
	private Produto produto;

	private int quantidade;
	
	public Estoque() {
		
	}

	public Estoque(Filial filial, Produto produto) {
		super();
		this.filial = filial;
		this.produto = produto;
		this.quantidade = 0;
	}
	
	public Estoque(Filial filial, Produto produto, int quantidade) {
		super();
		this.filial = filial;
		this.produto = produto;
		if(quantidade >= 0) {
			this.quantidade = quantidade;
		}else{
			throw new NegocioException("Quantidade não pode ser menor que zero");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if(quantidade >= 0) {
			this.quantidade = quantidade;
		}else{
			throw new NegocioException("Quantidade não pode ser menor que zero");
		}
	}
	
	public int adicionar(int quantidadeAdicionada) {
		this.quantidade += quantidadeAdicionada;
		return this.quantidade;
	}
	
	public int subtrair(int quantidadeRemovida) {
		if(quantidadeRemovida > this.quantidade) {
			throw new NegocioException("A quantidade solicitada é maior que o total atual no estoque.");
		}
		this.quantidade -= quantidadeRemovida;
		return this.quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
