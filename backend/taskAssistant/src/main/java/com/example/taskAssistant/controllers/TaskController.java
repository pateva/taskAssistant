package com.example.taskAssistant.controllers;

import com.example.taskAssistant.exceptions.ResourceNotFoundException;
import com.example.taskAssistant.exceptions.UnableToMakeChangesException;
import com.example.taskAssistant.models.Task;
import com.example.taskAssistant.repositories.TaskRepository;
import com.example.taskAssistant.dto.TaskDto;
import com.example.taskAssistant.service.FileExporter;
import com.example.taskAssistant.service.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(
            @RequestParam(required = false, defaultValue = "false") boolean isToFile) {
        List<Task> tasks = taskRepository.findActiveTasks();
        List<TaskDto> taskDtos = new ArrayList<>();

        for (Task task : tasks) {
            taskDtos.add(TaskMapper.toDto(task));
        }

        if (isToFile) {
            return FileExporter.exportTasksToFile(taskDtos);

        } else {
            return new ResponseEntity<>(taskDtos, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id) {
        if (!taskRepository.existsByTaskId(id)) {

            throw new ResourceNotFoundException("Task does not exist!");
        }

        return new ResponseEntity<>(TaskMapper.toDto(taskRepository.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto) {
        Task newTask = TaskMapper.toTask(taskDto);
        taskRepository.saveAndFlush(newTask);

        return new ResponseEntity<>(TaskMapper.toDto(newTask), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestParam(required = false, defaultValue = "false") boolean isInactive,
                                              @RequestBody TaskDto taskDto) {
        Task existingTask;

        if (taskRepository.existsByTaskId(id)) {
            existingTask = taskRepository.getReferenceById(id);
        } else {
            throw new ResourceNotFoundException("Task does not exist!");
        }

        if (isInactive) {
            existingTask.setIsActive(false);
            existingTask = taskRepository.saveAndFlush(existingTask);
        } else if (existingTask.isActive()) {
            existingTask.setTaskTitle(taskDto.getTitle());
            existingTask.setTaskDescription(taskDto.getDescription());
            existingTask = taskRepository.saveAndFlush(existingTask);
        } else {

            throw new UnableToMakeChangesException("This task has already been completed! It is not possible to make changes!");
        }

        return new ResponseEntity<>(TaskMapper.toDto(existingTask), HttpStatus.OK);
    }
}
