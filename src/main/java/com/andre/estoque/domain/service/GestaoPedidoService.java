package com.andre.estoque.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.estoque.domain.exception.NegocioException;
import com.andre.estoque.domain.model.Filial;
import com.andre.estoque.domain.model.PedidoEstoque;
import com.andre.estoque.domain.repository.FilialRepository;
import com.andre.estoque.domain.repository.ItensPedidoRepository;
import com.andre.estoque.domain.repository.PedidoEstoqueRepository;

@Service
public class GestaoPedidoService {
	
	@Autowired
	FilialRepository filialRepository;
	
	@Autowired
	PedidoEstoqueRepository pedidoEstoqueRepository;
	
	@Autowired
	ItensPedidoRepository itensPedidoRepository;
		
	public PedidoEstoque criarPedidoEstoque(int filialId, PedidoEstoque pedidoEstoque) {
		Filial filial = filialRepository.findById(filialId).
				orElseThrow(() -> new NegocioException("Esta filial não existe."));
		pedidoEstoque.setFilial(filial);
		return pedidoEstoqueRepository.save(pedidoEstoque);
	}
	
	public List<PedidoEstoque> listarPedidoEstoquePorFilial(int filialId){
		Filial filial = new Filial();
		filial.setId(filialId);
		return pedidoEstoqueRepository.findByFilial(filial);
	}
	
	public PedidoEstoque buscarPedidoEstoque(int idPedidoEstoque) {
		Optional<PedidoEstoque> pedidoEstoque = pedidoEstoqueRepository.findById(idPedidoEstoque);
		if(!pedidoEstoque.isPresent()) {
			throw new NegocioException("Não existe um pedido de estoque com este identificador");
		}
		return pedidoEstoque.get();
	}
	
	public boolean existePedidoEstoqueComId(int idPedidoEstoque) {
		return pedidoEstoqueRepository.existsById(idPedidoEstoque);
	}
}
