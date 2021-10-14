package com.crud.back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.back.domain.livro;

@Repository
public interface livroRepository extends JpaRepositoryImplementation<livro, Integer>{
	
	@Query("SELECT obj FROM livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	List<livro> findALLBycategoria(@Param(value="id_cat") Integer id_cat);

} 
