package com.andre.estoque.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andre.estoque.api.dto.ProdutoDto;
import com.andre.estoque.api.input.ProdutoInput;
import com.andre.estoque.domain.model.Produto;
import com.andre.estoque.domain.service.CadastroProdutoService;

@RequestMapping("/produto")
@RestController
public class ProdutoController {
	
	@Autowired
	CadastroProdutoService cadastroProdutoService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping
	public ProdutoDto criar(@Valid @RequestBody ProdutoInput produtoInput) {
		Produto produto = cadastroProdutoService.salvar(toEntity(produtoInput));
		
		return toDto(produto);
	}

//	@GetMapping
//	public List<ProdutoDto> listar() {
//		return toDtoList(cadastroProdutoService.listar());
//	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<ProdutoDto> buscar(@PathVariable int produtoId) {
		Optional<Produto> produto = cadastroProdutoService.buscar(produtoId);
		if(!produto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(toDto(produto.get()));
	}
	
	@GetMapping
	public List<ProdutoDto> buscar(@RequestParam(defaultValue = "") String descricao){
		return toDtoList(cadastroProdutoService.buscarPorDescricao(descricao));
	}
	
	@PutMapping("/{produtoId}")
	public ResponseEntity<ProdutoDto> alterar(@Valid @RequestBody ProdutoInput produtoInput, int produtoId) {
		if(cadastroProdutoService.existeProdutoComId(produtoId)) {
			return ResponseEntity.notFound().build();
		}
		
		Produto produto = toEntity(produtoInput);
		produto.setId(produtoId);
		
		ProdutoDto produtoDto = toDto(cadastroProdutoService.salvar(produto));
		
		return ResponseEntity.ok(produtoDto);
	}

	private Produto toEntity(@Valid ProdutoInput produtoInput) {
		return modelMapper.map(produtoInput, Produto.class);
	}

	private ProdutoDto toDto(Produto produto) {
		return modelMapper.map(produto, ProdutoDto.class);
	}
	
	private List<ProdutoDto> toDtoList(List<Produto> listaProdutos) {
		return listaProdutos.stream().map(produto -> toDto(produto)).collect(Collectors.toList());
	}
	
}
