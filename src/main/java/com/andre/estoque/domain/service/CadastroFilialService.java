package com.andre.estoque.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.estoque.domain.exception.NegocioException;
import com.andre.estoque.domain.model.Filial;
import com.andre.estoque.domain.repository.FilialRepository;

@Service
public class CadastroFilialService {

	@Autowired
	FilialRepository filialRepository;
	
	public Filial salvar(Filial filial) {
		Filial filialNomeExistente = filialRepository.findByNome(filial.getNome());
		
		if(filialNomeExistente != null) {
			throw new NegocioException("Já existe uma filial com este nome");
		}
		
		return filialRepository.save(filial);
		
	}
	
	public Optional<Filial> buscar(Long id) {
		
		return filialRepository.findById(id);
		
	}
	
	public boolean existeFilialComId(Long id) {
		return filialRepository.existsById(id);
	}
	
	public List<Filial> listar() {
		
		return filialRepository.findAll();
	}
	
	public void excluir(Long id) {
		filialRepository.deleteById(id);
	}
}
