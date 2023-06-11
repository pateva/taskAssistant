package com.example.taskAssistant.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(name = "\"task_description\"")
    private String taskDescription;

    @Column(name = "\"task_title\"")
    private String taskTitle;

    @CreationTimestamp
    @Column(name = "\"created_at\"")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "\"updated_at\"")
    private LocalDateTime updatedAt;

    @Column(name = "\"is_active\"")
    private boolean isActive;

    public Task() {}

    public Task(String taskDescription, String taskTitle) {
        this.taskDescription = taskDescription;
        this.taskTitle = taskTitle;
        this.isActive = true;
    }

    public Task(Long taskId, String taskDescription) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.isActive = true;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskTitle='" + taskTitle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskDescription.equals(task.taskDescription) && taskTitle.equals(task.taskTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskDescription, taskTitle);
    }
}
