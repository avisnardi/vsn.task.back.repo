package br.com.vsn.tsk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vsn.tsk.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	
}
