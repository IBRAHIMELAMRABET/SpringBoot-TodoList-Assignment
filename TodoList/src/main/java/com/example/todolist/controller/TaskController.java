package com.example.todolist.controller;


import com.example.todolist.model.Task;
import com.example.todolist.service.TaskService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping()
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/task/done")
    public List<Task> getTasksByDone(@RequestParam boolean done) {
        return taskService.getTasksByDone(done);
    }

    @GetMapping("/task/title")
    public List<Task> getTasksByTitle(@RequestParam String title) {
        return taskService.getTasksByTitle(title);
    }

    @PutMapping("/{id}/done")
    public Task updateTaskToDone(@PathVariable Long id) {
        return taskService.updateTaskToDone(id);
    }
}
