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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crud.back.domain.livro;
import com.crud.back.dtos.LivroDTO;
import com.crud.back.service.livroService;

import javassist.tools.rmi.ObjectNotFoundException;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private livroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<livro> findById(@PathVariable Integer id) throws ObjectNotFoundException {
		livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findALL(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat)
			throws ObjectNotFoundException {
		List<livro> list = service.findALL(id_cat);
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<livro> uptade( @PathVariable Integer id, @Valid @RequestBody livro obj)
			throws ObjectNotFoundException {
		livro newObj = service.uptade(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<livro> create( @RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@Valid	@RequestBody livro obj) throws ObjectNotFoundException {
		livro newObj = service.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}