package br.com.vsn.tsk.domain;

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
public class Task implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Campo 'Nome' deve ser preenchido.")
	@Length (min=3, max=100, message="Campo 'Nome' deve ter entre 3 e 100 caracteres.")
	private String name;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(Integer id, String name, Owner owner) {
		super();
		this.id = id;
		this.name = name;
		this.owner = owner;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
}
