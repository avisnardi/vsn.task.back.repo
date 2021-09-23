package br.com.vsn.tsk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vsn.tsk.domain.Owner;
import br.com.vsn.tsk.dtos.OwnerDTO;
import br.com.vsn.tsk.service.OwnerService;

@RestController
@RequestMapping(value = "/owners")
public class OwnerResource {

	@Autowired
	OwnerService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Owner> findById(@PathVariable Integer id) {
		Owner owner = service.findById(id);
		return ResponseEntity.ok().body(owner);
		
	}
	
	@GetMapping
	public ResponseEntity<List<OwnerDTO>> findAll() {
	    List<Owner> list = service.findAll();
	    List<OwnerDTO> listDTO = list.stream().map(obj -> new OwnerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@PostMapping
	public ResponseEntity<Owner> create(@RequestBody Owner obj) {
		obj.setId(null);
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping (value = "/{id}")
	public ResponseEntity<OwnerDTO> update(@PathVariable Integer id, @RequestBody OwnerDTO ownerDTO) {
		Owner newObj = service.update(id, ownerDTO);
		return ResponseEntity.ok().body(new OwnerDTO(newObj));	
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestBody OwnerDTO ownerDTO) {
		service.delete(id);
		return ResponseEntity.noContent().build();	
	}
	
}
