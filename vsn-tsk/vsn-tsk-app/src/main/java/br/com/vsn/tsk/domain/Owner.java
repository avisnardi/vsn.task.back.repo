package br.com.vsn.tsk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Owner {
	private Integer id;
	private String name;
	private List<Task> tasks = new ArrayList<>();
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, tasks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(tasks, other.tasks);
	}

	
}
