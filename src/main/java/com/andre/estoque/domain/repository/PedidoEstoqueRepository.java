package com.andre.estoque.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.estoque.domain.model.Filial;
import com.andre.estoque.domain.model.PedidoEstoque;

@Repository
public interface PedidoEstoqueRepository extends JpaRepository<PedidoEstoque, Integer>{
	List<PedidoEstoque> findByFilial(Filial filial);
}
