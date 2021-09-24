package br.com.vsn.tsk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.vsn.tsk.domain.Owner;
import br.com.vsn.tsk.dtos.OwnerDTO;
import br.com.vsn.tsk.repositories.OwnerRepository;
import br.com.vsn.tsk.service.exceptions.ObjectNotFoundException;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository repository;
	
	public Owner findById(Integer id) {
		Optional<Owner> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: id:" + id + " tipo:" + Owner.class.getName()));
		
	}
	
	public List<Owner> findAll() {
		return repository.findAll();
		
	}

	public Owner create(Owner obj) {
		return repository.save(obj);
	}

	public Owner update(Integer id, OwnerDTO ownerDTO) {
		Owner obj = findById(id);
		obj.setName(ownerDTO.getName());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new br.com.vsn.tsk.service.exceptions.DataIntegrityViolationException("Owner " + id +  " não pode ser excluído! Possui tasks associadas.");
		}
		
	}
}
