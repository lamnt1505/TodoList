package com.example.todolist.restController;

import com.example.todolist.entity.Todos;
import com.example.todolist.service.todo.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoRestController {

    private final TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/rest/todo")
    public ResponseEntity<?> getListTodo(){
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/todos")
    public List<Todos> getAll(){
        return todoService.findAll();
    }

    @PostMapping("/rest/todo/add")
    public Todos addTodo(@RequestBody Todos todo){
        todoService.save(todo);
        return todo;
    }

    @PutMapping("/rest/todo/update/{id}")
    public Todos put(@PathVariable("id") Long id,@RequestBody Todos todo){
        todoService.save(todo);
        return todo;
    }

    @DeleteMapping("/rest/todo/delete/{id}")
    public void delete(@PathVariable Long id,Model model,RedirectAttributes redirectAttributes){
        todoService.deleteById(id);
    }
}
