package com.andre.estoque.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.estoque.domain.exception.NegocioException;
import com.andre.estoque.domain.model.Estoque;
import com.andre.estoque.domain.model.Filial;
import com.andre.estoque.domain.model.Produto;
import com.andre.estoque.domain.repository.EstoqueRepository;
import com.andre.estoque.domain.repository.FilialRepository;
import com.andre.estoque.domain.repository.ProdutoRepository;

@Service
public class GestaoEstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private FilialRepository filialRepository;

	public Estoque criar(int filialId, int produtoId, int quantidadeInicial) {
		// TODO verificar se filial já possui estoque de um determinado produto
		Filial filial = filialRepository.findById(filialId)
				.orElseThrow(() -> new NegocioException("Esta filial não existe."));
		
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new NegocioException("Este produto não existe."));
		
		Estoque estoque = new Estoque(filial, produto, quantidadeInicial);

		if (estoqueRepository.existsByFilialAndProduto(filial, produto)) {
			throw new NegocioException("A filial já possui estoque deste produto");
		}
		
		return estoqueRepository.save(estoque);
	}

	public List<Estoque> buscarPorFilial(int filialId) {
		Filial filial = new Filial();
		filial.setId(filialId);
		return estoqueRepository.findByFilial(filial);
	}
	
}
