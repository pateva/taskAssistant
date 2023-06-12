package com.example.taskAssistant.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskDtoTest {

    @Test
    void getDescription() {
        String description = "Sample description";
        TaskDto taskDto = new TaskDto();
        taskDto.setDescription(description);

        Assertions.assertEquals(description, taskDto.getDescription());
    }

    @Test
    void setDescription() {
        String description = "Sample description";
        TaskDto taskDto = new TaskDto();
        taskDto.setDescription(description);

        Assertions.assertEquals(description, taskDto.getDescription());
    }

    @Test
    void getTitle() {
        String title = "Sample title";
        TaskDto taskDto = new TaskDto();
        taskDto.setTitle(title);

        Assertions.assertEquals(title, taskDto.getTitle());
    }

    @Test
    void setTitle() {
        String title = "Sample title";
        TaskDto taskDto = new TaskDto();
        taskDto.setTitle(title);

        Assertions.assertEquals(title, taskDto.getTitle());
    }

    @Test
    void getTaskId() {
        Long id = 7L;
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(id);

        Assertions.assertEquals(id, taskDto.getTaskId());
    }

    @Test
    void setTaskId() {
        Long id = 7L;
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(id);

        Assertions.assertEquals(id, taskDto.getTaskId());
    }
}
