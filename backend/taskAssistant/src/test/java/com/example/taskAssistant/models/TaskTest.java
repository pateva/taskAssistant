package com.example.taskAssistant.models;

import com.example.taskAssistant.dto.TaskDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void getTaskId() {
        Long id = 7L;
        Task task = new Task();
        task.setTaskId(id);

        Assertions.assertEquals(id, task.getTaskId());
    }

    @Test
    void setTaskId() {
        Long id = 7L;
        Task task = new Task();
        task.setTaskId(id);

        Assertions.assertEquals(id, task.getTaskId());
    }

    @Test
    void getTaskDescription() {
        String description = "Sample description";
        Task task = new Task();
        task.setTaskDescription(description);

        Assertions.assertEquals(description, task.getTaskDescription());
    }

    @Test
    void setTaskDescription() {
        String description = "Sample description";
        Task task = new Task();
        task.setTaskDescription(description);

        Assertions.assertEquals(description, task.getTaskDescription());
    }

    @Test
    void getTaskTitle() {
        String title = "Sample title";
        Task task = new Task();
        task.setTaskTitle(title);

        Assertions.assertEquals(title, task.getTaskTitle());
    }

    @Test
    void setTaskTitle() {
        String title = "Sample title";
        Task task = new Task();
        task.setTaskTitle(title);

        Assertions.assertEquals(title, task.getTaskTitle());
    }

    @Test
    void getCreatedAt() {
        LocalDateTime dateTime = LocalDateTime.now();
        Task task = new Task();
        task.setCreatedAt(dateTime);

        Assertions.assertEquals(dateTime, task.getCreatedAt());
    }

    @Test
    void setCreatedAt() {
        LocalDateTime dateTime = LocalDateTime.now();
        Task task = new Task();
        task.setCreatedAt(dateTime);

        Assertions.assertEquals(dateTime, task.getCreatedAt());
    }

    @Test
    void getUpdatedAt() {
        LocalDateTime dateTime = LocalDateTime.now();
        Task task = new Task();
        task.setUpdatedAt(dateTime);

        Assertions.assertEquals(dateTime, task.getUpdatedAt());
    }

    @Test
    void setUpdatedAt() {
        LocalDateTime dateTime = LocalDateTime.now();
        Task task = new Task();
        task.setUpdatedAt(dateTime);

        Assertions.assertEquals(dateTime, task.getUpdatedAt());
    }

    @Test
    void isActive() {
        boolean isActive = true;
        Task task = new Task();
        task.setIsActive(isActive);

        Assertions.assertEquals(isActive, task.isActive());
    }

    @Test
    void setIsActive() {
        boolean isActive = true;
        Task task = new Task();
        task.setIsActive(isActive);

        Assertions.assertEquals(isActive, task.isActive());
    }
}
