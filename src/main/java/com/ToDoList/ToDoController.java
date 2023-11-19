package com.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoServiceImp toDoService;

    @GetMapping("/")
    public String getTodos(Model model) {
         Iterable<ToDo> toDoIterable = toDoService.getAllToDo();
         model.addAttribute("todos", toDoIterable);
         return "todos";
    }

    @PostMapping("/")
    public String addTodo(@RequestParam("title") String title, @RequestParam("description") String description,@RequestParam("status") String status) {
        ToDo todo = new ToDo();
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setStatus(status);
        toDoService.createToDo(todo);
        return "redirect:/todos/";
    }

    @PostMapping("/update")
    public String updateTodoStatus(@RequestParam("id") Long id) {
        ToDo todo = toDoService.getToDoById(id);
        if (todo != null) {
            toDoService.updateToDo(todo);
        }
        return "redirect:/todos";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        toDoService.deleteToDoById(id);
        return "redirect:/todos/";
    }
}
