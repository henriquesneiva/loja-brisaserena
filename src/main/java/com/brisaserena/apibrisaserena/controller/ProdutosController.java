package com.brisaserena.apibrisaserena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.brisaserena.apibrisaserena.domain.Categoria;
import com.brisaserena.apibrisaserena.domain.Produtos;
import com.brisaserena.apibrisaserena.dto.ProdutosDTO;
import com.brisaserena.apibrisaserena.repository.CategoriaRepository;
import com.brisaserena.apibrisaserena.repository.ProdutosRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

	@Autowired
	private ProdutosRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produtos create(@RequestBody ProdutosDTO dto) {
		
		Integer idCategoria = dto.getIdCategoria();
		
		Categoria categoria = categoriaRepository.findById(idCategoria)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"categoria não encontrada"));
				
		Produtos produtos = new Produtos();
		
		produtos.setNome(dto.getNome());
		produtos.setPreco(dto.getPreco());
		produtos.setQuantidade(dto.getQuantidade());
		produtos.setCategoria(categoria);
		
		return repository.save(produtos);
		
		
	}

	@GetMapping
	public List<Produtos> findAll() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public Produtos findById(@PathVariable Integer id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "produto não encontrado"));
	}

	@DeleteMapping("{id}")
	public void delet(@PathVariable Integer id) {

		repository.findById(id).map(produtos -> {
			repository.delete(produtos);
			return Void.TYPE;
		});

	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Produtos produtosUpdate) {
		
		repository.findById(id)
				.map(produtos -> {
					produtosUpdate.setId(id);
					return repository.save(produtosUpdate);
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"produto não encontrado"));
	
	}
	

}
