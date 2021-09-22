package br.com.vsn.tsk.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
