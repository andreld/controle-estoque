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

import com.andre.estoque.api.dto.PedidoEstoqueDto;
import com.andre.estoque.api.input.PedidoEstoqueInput;
import com.andre.estoque.domain.model.PedidoEstoque;
import com.andre.estoque.domain.service.CadastroFilialService;
import com.andre.estoque.domain.service.GestaoPedidoService;

@RequestMapping("filiais/{filialId}/pedidos-estoque")
@RestController
public class PedidoEstoqueController {
	
	@Autowired
	GestaoPedidoService gestaoPedidoService;
	
	@Autowired
	CadastroFilialService filialService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<PedidoEstoqueDto> criar(@PathVariable int filialId, @Valid @RequestBody PedidoEstoqueInput pedidoEstoqueInput) {
		PedidoEstoque pedidoEstoque = gestaoPedidoService.criarPedidoEstoque(filialId, toEntity(pedidoEstoqueInput));
		
		return ResponseEntity.ok(toDto(pedidoEstoque));
	}
	
	@GetMapping
	public List<PedidoEstoqueDto> listar(@PathVariable int filialId){
		return toDtoList(gestaoPedidoService.listarPedidoEstoquePorFilial(filialId));
	}

	private List<PedidoEstoqueDto> toDtoList(List<PedidoEstoque> listaPedidoEstoque) {
		return listaPedidoEstoque.stream().map(pedidoEstoque -> toDto(pedidoEstoque)).collect(Collectors.toList());
	}

	private PedidoEstoqueDto toDto(PedidoEstoque pedidoEstoque) {
		return modelMapper.map(pedidoEstoque, PedidoEstoqueDto.class);
	}

	private PedidoEstoque toEntity(@Valid PedidoEstoqueInput pedidoEstoqueInput) {
		return modelMapper.map(pedidoEstoqueInput, PedidoEstoque.class);
	}
}
