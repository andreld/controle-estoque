package com.andre.estoque.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.estoque.api.dto.FilialDto;
import com.andre.estoque.api.input.FilialInput;
import com.andre.estoque.domain.model.Filial;
import com.andre.estoque.domain.service.CadastroFilialService;

@RequestMapping("/filial")
@RestController //@Controller + @RequestBody
public class FilialController {
	
	@Autowired
	CadastroFilialService cadastroFilialService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/{filialId}")
	ResponseEntity<FilialDto> buscar(@PathVariable int filialId) {
		//retornar-se um ResponseEntity sempre que recebemos um pathvariable
		//para devolvermos códigos HTTP de acordo com a resposta que devolveremos
		Optional<Filial> filial = cadastroFilialService.buscar(filialId);
		
		if(!filial.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(toDto(filial.get()));
		
	}
	
	@GetMapping
	public List<FilialDto> listar() {
		return toDtoList(cadastroFilialService.listar());
		
	}
	
	@PostMapping
	public FilialDto criar(@Valid @RequestBody FilialInput filialInput){
		return toDto(cadastroFilialService.salvar(toEntity(filialInput)));
	}
	
	@PutMapping("/{filialId}")
	public ResponseEntity<FilialDto> alterar(@Valid @RequestBody FilialInput filialInput, 
			@PathVariable int filialId) {
		if(!cadastroFilialService.existeFilialComId(filialId)) {
			return ResponseEntity.notFound().build();
		}
		
		Filial filial = toEntity(filialInput);
		filial.setId(filialId);
		
		filial = cadastroFilialService.salvar(filial);
		
		return ResponseEntity.ok((toDto(filial)));
	}
	
	@DeleteMapping("/{filialId}")
	public ResponseEntity<Void> excluir(@PathVariable int filialId) {
		if(!cadastroFilialService.existeFilialComId(filialId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroFilialService.excluir(filialId);
		
		return ResponseEntity.noContent().build();
	}
	
	private Filial toEntity(@Valid FilialInput filialInput) {
		return modelMapper.map(filialInput, Filial.class);
	}


	private FilialDto toDto(Filial filial) {
		return modelMapper.map(filial, FilialDto.class);
		
	}

	private List<FilialDto> toDtoList(List<Filial> listar) {
		return listar.stream().map(filial -> toDto(filial)).collect(Collectors.toList());
		
	}
}
