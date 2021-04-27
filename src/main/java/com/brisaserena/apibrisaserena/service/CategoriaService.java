package com.brisaserena.apibrisaserena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.brisaserena.apibrisaserena.domain.Categoria;
import com.brisaserena.apibrisaserena.dto.CategoriaDTO;
import com.brisaserena.apibrisaserena.repository.CategoriaRepository;
import com.brisaserena.apibrisaserena.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {

		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrato! id = " + id + ", tipo:" + Categoria.class.getName()));

	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {

		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		return repository.save(obj);

	}

	public void delite(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.brisaserena.apibrisaserena.service.exceptions.DataIntegrityViolationException(
					"essa categoria nao pode ser deletado : possui produtos associados");
		}
	}

}
