package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean done = false;

}
