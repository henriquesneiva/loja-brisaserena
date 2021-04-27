package com.brisaserena.apibrisaserena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brisaserena.apibrisaserena.domain.Categoria;
import com.brisaserena.apibrisaserena.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria creat(@RequestBody Categoria categoria) {
		return repository.save(categoria);
	}
	
}
