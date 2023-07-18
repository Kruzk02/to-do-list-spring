package com.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoServiceImp implements ToDoService{

    private final ToDoRepository toDoRepository;
    @Autowired
    public ToDoServiceImp(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public Iterable<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(long id) {
        return toDoRepository.findById(id).orElse(null);
    }

    @Override
    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public ToDo updateToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public void deleteToDoById(long id) {
        toDoRepository.deleteById(id);
    }
}
