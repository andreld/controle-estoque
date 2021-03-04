package com.andre.estoque.api.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.estoque.api.dto.EstoqueDto;
import com.andre.estoque.api.input.EstoqueInput;
import com.andre.estoque.domain.model.Estoque;
import com.andre.estoque.domain.service.GestaoEstoqueService;

@RequestMapping("/filial")
@RestController
public class EstoqueController {

	@Autowired
	GestaoEstoqueService gestaoEstoqueService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("{filialId}/produto/{produtoId}")
	public EstoqueDto criar(@Valid @RequestBody EstoqueInput estoqueInput, @PathVariable int filialId, @PathVariable int produtoId) {
		return toDto(gestaoEstoqueService.criar(filialId, produtoId, estoqueInput.getQuantidade()));
	}

	private EstoqueDto toDto(Estoque estoque) {
		return modelMapper.map(estoque, EstoqueDto.class);
	}
	
}
