package br.com.vsn.tsk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsn.tsk.domain.Owner;
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
	
}
