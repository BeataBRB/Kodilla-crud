package com.crud.task.repository;

import com.crud.task.domain.Task;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long>{
    @Override
    List<Task> findAll();

}
