package com.example.todolist.controller;

import com.example.todolist.entity.Todos;
import com.example.todolist.service.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/index")
    public String index(Model model) {
        List<Todos> todo = todoService.findAll();
        model.addAttribute("todos", todo);
        model.addAttribute("todo", new Todos());
        return "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("todo", new Todos());
        return "add";
    }

    @PostMapping("/savetodo")
    public String saveTask(@ModelAttribute("todos") Todos todos,RedirectAttributes redirect) {
        todos.setStatus(false);
        todoService.save(todos);
        redirect.addFlashAttribute("success", "Thêm mới thành công!");
        return "redirect:/index";
    }

    @GetMapping("/updateTodo/{id}")
    public String updateTodoForm(Model model, @PathVariable(name = "id") long id) {
        model.addAttribute("todo",todoService.findById(id));
        return "edit";
    }
    @PostMapping("/updateTodo")
    public String updateTodoSubmit(@ModelAttribute(value = "todos") @Valid Todos todos,
                                   @RequestParam("id") long id, RedirectAttributes redirect, BindingResult result) {
        if(result.hasErrors()){
            return "/updateTodo";
        }else {
            todos.setStatus(false);
            todoService.save(todos);
            redirect.addFlashAttribute("success", "Chỉnh sửa thông tin thành công!");
        }
        return "redirect:/index";
    }

    @GetMapping(value="/deteleTodo/{id}")
    public String deleteTodo(@PathVariable(name = "id") long id,RedirectAttributes redirect){
        Todos todos = todoService.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Invalid user Id:" + id));
        todoService.deleteById(id);
        redirect.addFlashAttribute("success", "Xóa thông tin thành công!");

        return "redirect:/index";
    }
}
