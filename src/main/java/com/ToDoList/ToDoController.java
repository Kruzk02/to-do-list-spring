package com.ToDoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoServiceImp toDoService;

    @GetMapping
    public String getTodos(Model model) {
        Iterable<ToDo> toDoIterable = toDoService.getAllToDo();
        model.addAttribute("todos", toDoIterable);
        return "todos";
    }

    @PostMapping
    public String addTodo(@RequestParam("title") String title, @RequestParam("description") String description) {
        ToDo todo = new ToDo();
        todo.setTitle(title);
        todo.setDescription(description);
        toDoService.createToDo(todo);
        return "redirect:/todos";
    }

    @PostMapping("/update")
    public String updateTodoStatus(@RequestParam("id") Long id) {
        ToDo todo = toDoService.getToDoById(id);
        if (todo != null) {
            boolean completed = !todo.isCompleted();
            todo.setCompleted(completed);
            toDoService.createToDo(todo);
        }
        return "redirect:/todos";
    }

    @PostMapping("/delete")
    public String deleteTodo(@RequestParam("id") Long id) {
        toDoService.deleteToDoById(id);
        return "redirect:/todos";
    }
}
