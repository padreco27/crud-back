package com.crud.back.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.crud.back.domain.categoria;

public class CategoriasDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "Campo nome é requerido")
	@Length(min = 3, max = 100, message = "O campo nome tem que ter entre 3 a 100 caracteres")
	private String nome;

	@NotEmpty(message = "Campo descrição é requerido")
	@Length(min = 3, max = 200, message = "o campo descrição tem que ter entre 3 a 200 caracteres")
	private String descricao;

	public CategoriasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriasDTO(categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
