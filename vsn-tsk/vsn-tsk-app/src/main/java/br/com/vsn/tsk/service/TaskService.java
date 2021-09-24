package br.com.vsn.tsk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsn.tsk.domain.Owner;
import br.com.vsn.tsk.domain.Task;
import br.com.vsn.tsk.dtos.TaskDTO;
import br.com.vsn.tsk.repositories.TaskRepository;
import br.com.vsn.tsk.service.exceptions.ObjectNotFoundException;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private OwnerService ownerService; 

	public Task findById(Integer id) {
		Optional<Task> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: id:" + id + " tipo:" + Task.class.getName()));
	}

	public List<Task> findAll() {
		return repository.findAll();
	}

	public Task create(Integer ownerId, Task obj) {
		obj.setId(null);
		
		Owner owner = ownerService.findById(ownerId);
		obj.setOwner(owner);
	
		return repository.save(obj);
	}

	public Task update(Integer id, TaskDTO taskDTO) {
		Task obj = findById(id);
		obj.setName(taskDTO.getName());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
	
}
