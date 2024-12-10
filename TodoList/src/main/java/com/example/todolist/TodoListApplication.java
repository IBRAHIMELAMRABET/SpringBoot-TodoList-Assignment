package com.example.todolist;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(TaskRepository taskRepository){
        return args -> {
            Task task1 = new Task();
            task1.setTitle("Buy milk");
            task1.setDescription("");

            Task task2 = new Task();
            task2.setTitle("Buy bread");
            task2.setDescription("");

            taskRepository.save(task1);
            taskRepository.save(task2);
        };
    }
}
