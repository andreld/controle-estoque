package com.andre.estoque.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.estoque.domain.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findByDescricao(String descricao);
	Produto findByCodigoBarras(String codigoBarras);
	List<Produto> findByDescricaoContainingIgnoreCase(String descricao);
}
