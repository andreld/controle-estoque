package com.andre.estoque.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andre.estoque.domain.model.Estoque;
import com.andre.estoque.domain.model.Filial;
import com.andre.estoque.domain.model.Produto;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{
	public boolean existsByProduto(Produto produto);
	public boolean existsByFilialAndProduto(Filial filial, Produto produto);
	public List<Estoque> findByFilial(Filial filial);
}
