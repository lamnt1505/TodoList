package com.example.todolist.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "todos")
@Getter
@Setter
public class Todos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column(name = "title",columnDefinition = "nvarchar(255)")
    private String title;

    @Column(name = "description",columnDefinition = "nvarchar(255)")
    private String description;

    @DateTimeFormat (pattern = "yyyy-MM-dd")
    @Column(name = "startdate")
    private LocalDate startdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "duedate")
    private LocalDate duedate;

    private boolean status;

    @Column(name = "funcstions",columnDefinition = "nvarchar(255)")
    private String functions;

}
