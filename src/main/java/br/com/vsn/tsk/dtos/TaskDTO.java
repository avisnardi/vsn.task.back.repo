package br.com.vsn.tsk.dtos;

import br.com.vsn.tsk.domain.Task;

public class TaskDTO {

	private Integer id;
	private String name;
	
	public TaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskDTO(Task obj) {
		super();
		this.setId(obj.getId());
		this.setName(obj.getName());
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
	
	
}
