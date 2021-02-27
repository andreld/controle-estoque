package com.andre.estoque.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.estoque.domain.model.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long>{
	public Filial findByNome(String nome);
}
