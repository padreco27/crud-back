package com.crud.back.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.crud.back.domain.categoria;

@Repository
public interface categoriaRepository extends JpaRepositoryImplementation<categoria, Integer>{

} 
