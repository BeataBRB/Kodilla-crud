package com.crud.task.service;

import com.crud.task.domain.Task;
import com.crud.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

}
