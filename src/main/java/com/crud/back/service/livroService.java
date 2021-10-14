package com.crud.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.back.domain.categoria;
import com.crud.back.domain.livro;
import com.crud.back.repositories.livroRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class livroService {

	@Autowired
	private livroRepository repository;

	@Autowired
	private categoriaService categoriaService;

	public livro findById(Integer id) throws ObjectNotFoundException {
		Optional<livro> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado id" + id + ",tipo" + livro.class.getName()));
	}

	public List<livro> findALL(Integer id_cat) throws ObjectNotFoundException {
		categoriaService.findById(id_cat);
		return repository.findALLBycategoria(id_cat);
	}

	public livro uptade(Integer id, livro obj) throws ObjectNotFoundException {
		livro newObj = findById(id);
		uptadeData(newObj, obj);
		return repository.save(newObj);
	}

	private void uptadeData(livro newObj, livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
	}

	public livro create(Integer id_cat, livro obj) throws ObjectNotFoundException {
		obj.setId(null);
		categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		livro obj = findById(id);
		repository.delete(obj);
		
	}

}
