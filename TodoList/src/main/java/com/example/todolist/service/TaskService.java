package com.example.todolist.service;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByDone(boolean done) {
        return taskRepository.findByDone(done);
    }

    public List<Task> getTasksByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    public Task updateTaskToDone(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setDone(true);
            return taskRepository.save(task);
        }
        return null;
    }

}
