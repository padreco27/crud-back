package com.crud.back.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo titulo é requerido")
	@Length(min = 3, max = 50, message = "O campo titulo  tem que ter entre 3 a 50 caracteres")
	private String titulo;
	
	@NotEmpty(message = "Campo nome do autor é requerido")
	@Length(min = 3, max = 50, message = "O campo nome do autor  tem que ter entre 3 a 50 caracteres")
	private String nome_autor;
	
	@NotEmpty(message = "Campo texto é requerido")
	@Length(min = 10, max = 200000, message = "O campo texto tem que ter entre 3 a 200000 caracteres")
	private String texto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private categoria categoria;

	public livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public livro(Integer id, String titulo, String nome_autor, String texto, com.crud.back.domain.categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		livro other = (livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
