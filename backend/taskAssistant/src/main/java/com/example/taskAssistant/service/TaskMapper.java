package com.example.taskAssistant.service;

import com.example.taskAssistant.dto.TaskDto;
import com.example.taskAssistant.models.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public static TaskDto toDto(Task task) {
        return new TaskDto(task.getTaskId(), task.getTaskDescription(), task.getTaskTitle());
    }

    public static Task toTask(TaskDto taskDto) {
        return new Task(taskDto.getDescription(), taskDto.getTitle());
    }
}
