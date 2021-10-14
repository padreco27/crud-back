package com.crud.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.crud.back.domain.categoria;
import com.crud.back.dtos.CategoriasDTO;
import com.crud.back.repositories.categoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class categoriaService {

	@Autowired
	private categoriaRepository repository;

	public categoria findById(Integer id) throws ObjectNotFoundException {
		Optional<categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id" + id + ",tipo" + categoria.class.getName()));
	}

	public List<categoria> findALL() {
		return repository.findAll();
	}

	public categoria create(categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public categoria uptade(Integer id, CategoriasDTO objDto) throws ObjectNotFoundException {
		categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.crud.back.service.exceptions.DataIntegrityViolationException("Objeto não pode ser deletado ");
		}
	}
}
