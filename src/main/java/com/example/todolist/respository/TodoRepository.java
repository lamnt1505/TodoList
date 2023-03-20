package com.example.todolist.respository;

import com.example.todolist.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todos,Long>{
    @Query(value = "select todos from todos todo", nativeQuery = true)
    List<Todos> listTodos();
}
