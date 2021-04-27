package com.brisaserena.apibrisaserena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brisaserena.apibrisaserena.domain.Categoria;
import com.brisaserena.apibrisaserena.domain.Produtos;
import com.brisaserena.apibrisaserena.repository.ProdutosRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	

	public Produtos create(Integer id_cat, Produtos obj) {

		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}
	
	
	
	
}
