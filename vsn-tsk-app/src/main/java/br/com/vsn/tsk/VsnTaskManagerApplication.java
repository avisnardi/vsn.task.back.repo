package br.com.vsn.tsk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.vsn.tsk.domain.Owner;
import br.com.vsn.tsk.domain.Task;
import br.com.vsn.tsk.repositories.OwnerRepository;
import br.com.vsn.tsk.repositories.TaskRepository;

@SpringBootApplication
public class VsnTaskManagerApplication implements CommandLineRunner {

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(VsnTaskManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Owner o1 = new Owner(null, "Alexandre Visnardi");
		
		Task t1 = new Task(null, "Task 01", o1);
		
		o1.getTasks().addAll(Arrays.asList(t1));
		
		this.ownerRepository.saveAll(Arrays.asList(o1));
		this.taskRepository.saveAll(Arrays.asList(t1));
		
		
	}

}
