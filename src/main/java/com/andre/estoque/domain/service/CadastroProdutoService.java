package com.andre.estoque.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.estoque.domain.exception.NegocioException;
import com.andre.estoque.domain.model.Produto;
import com.andre.estoque.domain.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) {
		Produto produtoCodigoBarrasExistente = produtoRepository.findByCodigoBarras(produto.getCodigoBarras());
		if(produtoCodigoBarrasExistente != null) {
			throw new NegocioException("Já existe um produto com este código de barras cadastrado.");
		}
		
		return produtoRepository.save(produto);
	}
	
	public Optional<Produto> buscar(int id) {
		return produtoRepository.findById(id);
	}
	

	public List<Produto> buscarPorDescricao(String descricao) {
		return produtoRepository.findByDescricaoContainingIgnoreCase(descricao);	
	}
	
	public boolean existeProdutoComId(int produtoId) {
		return produtoRepository.existsById(produtoId);
	}
	
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	public void excluir(int produtoId) {
		produtoRepository.deleteById(produtoId);
	}

}
