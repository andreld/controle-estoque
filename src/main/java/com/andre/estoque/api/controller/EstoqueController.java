package com.andre.estoque.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.estoque.api.dto.EstoqueDto;
import com.andre.estoque.api.input.EstoqueInput;
import com.andre.estoque.domain.model.Estoque;
import com.andre.estoque.domain.service.CadastroFilialService;
import com.andre.estoque.domain.service.GestaoEstoqueService;

@RequestMapping("/filiais")
@RestController
public class EstoqueController {

	@Autowired
	GestaoEstoqueService gestaoEstoqueService;
	
	@Autowired
	CadastroFilialService cadastroFilialService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("/{filialId}/produtos/{produtoId}")
	public EstoqueDto criar(@Valid @RequestBody EstoqueInput estoqueInput, @PathVariable int filialId, @PathVariable int produtoId) {
		return toDto(gestaoEstoqueService.criar(filialId, produtoId, estoqueInput.getQuantidade()));
	}
	
	//Todos os produtos com estoque cadastrado em uma filial
	@GetMapping("/{filialId}/produtos/estoques")
	public ResponseEntity<List<EstoqueDto>> listar(@PathVariable int filialId){
		if(!cadastroFilialService.existeFilialComId(filialId)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(toDtoList(gestaoEstoqueService.buscarPorFilial(filialId)));
	}
	
	private List<EstoqueDto> toDtoList(List<Estoque> listaEstoque) {
		return listaEstoque.stream().map(filial -> toDto(filial)).collect(Collectors.toList());
	}

	private EstoqueDto toDto(Estoque estoque) {
		return modelMapper.map(estoque, EstoqueDto.class);
	}
	
}
