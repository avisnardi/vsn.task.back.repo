package br.com.vsn.tsk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vsn.tsk.service.TaskService;
import br.com.vsn.tsk.domain.Owner;
import br.com.vsn.tsk.domain.Task;
import br.com.vsn.tsk.dtos.OwnerDTO;
import br.com.vsn.tsk.dtos.TaskDTO;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

	@Autowired
	private TaskService service;
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Task> findById(@PathVariable Integer id) {
		Task task = service.findById(id);
		return ResponseEntity.ok().body(task);
	}
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> findAll() {
		List<Task> list = service.findAll();
		List<TaskDTO> listDTO = list.stream().map(obj -> new TaskDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Task> create(@RequestParam(value = "owner", defaultValue = "0") Integer ownerId, @RequestBody Task task) {
		Task newObj = service.create(ownerId, task);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("tasks/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping (value = "/{id}")
	public ResponseEntity<TaskDTO> update(@PathVariable Integer id, @RequestBody TaskDTO taskDTO) {
		Task obj = service.update(id, taskDTO);
		return ResponseEntity.ok().body(new TaskDTO(obj));	
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();	
	}
}
