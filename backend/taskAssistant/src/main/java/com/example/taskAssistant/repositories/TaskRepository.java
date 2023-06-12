package com.example.taskAssistant.repositories;

import com.example.taskAssistant.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {

    boolean existsByTaskId(Long taskId);

    @Query("SELECT t FROM Task t WHERE t.isActive = true")
    List<Task> findActiveTasks();
}
