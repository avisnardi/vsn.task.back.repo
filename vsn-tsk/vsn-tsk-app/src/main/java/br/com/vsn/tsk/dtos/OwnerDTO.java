package br.com.vsn.tsk.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.vsn.tsk.domain.Owner;

public class OwnerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Campo 'Nome' deve ser preenchido.")
	@Length (min=3, max=100, message="Campo 'Nome' deve ter entre 3 e 100 caracteres.")
	private String name;
	
	@NotEmpty(message="Campo 'E-mail' deve ser preenchido.")
	@Length (min=3, max=200, message="Campo 'E-mail' deve ter entre 3 e 200 caracteres.")
	private String email;
	
	public OwnerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OwnerDTO(Owner obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
