package com.crud.back.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crud.back.domain.categoria;
import com.crud.back.dtos.CategoriasDTO;
import com.crud.back.service.categoriaService;

import javassist.tools.rmi.ObjectNotFoundException;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private categoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<categoria> findById(@PathVariable Integer id) throws ObjectNotFoundException {
		categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping
	public ResponseEntity<List<CategoriasDTO>> findALL() {
		List<categoria> list = service.findALL();
		List<CategoriasDTO> listDTO = list.stream().map(obj -> new CategoriasDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<categoria> create(@Valid @RequestBody categoria obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriasDTO> uptade(@Valid @PathVariable Integer id, @RequestBody CategoriasDTO objDto)
			throws ObjectNotFoundException {
		categoria newObj = service.uptade(id, objDto);
		return ResponseEntity.ok().body(new CategoriasDTO(newObj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}