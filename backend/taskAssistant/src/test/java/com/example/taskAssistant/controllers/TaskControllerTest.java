package com.example.taskAssistant.controllers;

import com.example.taskAssistant.dto.TaskDto;
import com.example.taskAssistant.repositories.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(TaskController.class)
@ExtendWith(SpringExtension.class)
class TaskControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private TaskRepository taskRepository;

    @MockBean
    private TaskController taskController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void listTasks_tasksAreListed_returns200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void listTasks_tasksAreExported_returns200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks?isToFile=true")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getTask_taskExists_returns200() throws Exception {
        Mockito.when(taskRepository.existsById(6L)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks/6")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addTask_taskAdded_returns200() throws Exception {
        TaskDto taskDto = new TaskDto("Description", "Title");

        mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(taskDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateTask_taskIsDeactivated_returns200() throws Exception {
        TaskDto taskDto = new TaskDto("New Description", "Title");
        Long originalId = 1L;
        Mockito.when(taskRepository.existsByTaskId(originalId)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/tasks/{originalId}", originalId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("isInactive", "true")
                        .content(objectMapper.writeValueAsString(taskDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateTask_taskIsUpdated_returns200() throws Exception {
        TaskDto taskDto = new TaskDto("New Description", "Title");
        Long originalId = 1L;
        Mockito.when(taskRepository.existsByTaskId(originalId)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/tasks/{originalId}", originalId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(taskDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
