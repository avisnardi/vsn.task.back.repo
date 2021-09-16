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

	
	
	public static void main(String[] args) {
		SpringApplication.run(VsnTaskManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		
	}

}
