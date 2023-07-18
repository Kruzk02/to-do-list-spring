package com.ToDoList;

import java.util.List;

public interface ToDoService {
    Iterable<ToDo> getAllToDo();
    ToDo getToDoById(long id);
    ToDo createToDo(ToDo toDo);
    ToDo updateToDo(ToDo toDo);
    void deleteToDoById(long id);
}
