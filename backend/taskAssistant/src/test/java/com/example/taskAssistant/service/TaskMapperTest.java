package com.example.taskAssistant.service;

import com.example.taskAssistant.dto.TaskDto;
import com.example.taskAssistant.models.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapperTest {

    @Test
    void toDto() {
        Task task = new Task(1L, "Task Description", "Task Title");
        TaskDto taskDto = TaskMapper.toDto(task);

        assertEquals(task.getTaskId(), taskDto.getTaskId());
        assertEquals(task.getTaskDescription(), taskDto.getDescription());
        assertEquals(task.getTaskTitle(), taskDto.getTitle());
    }

    @Test
    void toTask() {
        TaskDto taskDto = new TaskDto(1L, "Task Description", "Task Title");
        Task task = TaskMapper.toTask(taskDto);

        assertEquals(taskDto.getDescription(), task.getTaskDescription());
        assertEquals(taskDto.getTitle(), task.getTaskTitle());
    }
}
