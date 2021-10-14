package com.crud.back.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.back.domain.categoria;
import com.crud.back.domain.livro;
import com.crud.back.repositories.categoriaRepository;
import com.crud.back.repositories.livroRepository;

@Service
public class DBService {
	@Autowired
	private categoriaRepository categoriaRepository;
	@Autowired
	private livroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		categoria cat1 = new categoria(null, "Informática", "Livros de TI");
		categoria cat2 = new categoria(null, "Ficcção Científica", "Ficcção científica");
		categoria cat3 = new categoria(null, "Biografias", "Livros de Biografias");
				
		livro l1 = new livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		livro l2 = new livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		livro l3 = new livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
		livro l4 = new livro(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
		livro l5 = new livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);
				
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
				
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		
	}
}
