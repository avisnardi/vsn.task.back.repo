package br.com.vsn.tsk.service.copy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsn.tsk.domain.Owner;
import br.com.vsn.tsk.domain.Task;
import br.com.vsn.tsk.repositories.OwnerRepository;
import br.com.vsn.tsk.repositories.TaskRepository;

@Service
public class DBService {

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	public void instanciaBaseDeDados() {
		Owner o1 = new Owner(null, "Alexandre Visnardi");
		Owner o2 = new Owner(null, "Kelly Cristina dos Santos Visnardi");
		
		Task t1 = new Task(null, "Task 01", o1);

		Task t2 = new Task(null, "Task 02", o1);

		Task t3 = new Task(null, "Task 03", o2);

		o1.getTasks().addAll(Arrays.asList(t1));
		
		this.ownerRepository.saveAll(Arrays.asList(o1, o2));
		this.taskRepository.saveAll(Arrays.asList(t1, t2, t3));
	}
}
