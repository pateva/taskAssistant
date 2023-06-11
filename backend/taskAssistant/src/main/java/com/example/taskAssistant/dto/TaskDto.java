package com.example.taskAssistant.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDto {
    private Long taskId;
    private String description;
    private String title;

    public TaskDto() {}

    public TaskDto(Long taskId, String description, String title) {
        this.taskId = taskId;
        this.description = description;
        this.title = title;
    }

    public TaskDto(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
