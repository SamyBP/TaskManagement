package ro.app.taskmanagement.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.app.taskmanagement.dtos.TaskDto;
import ro.app.taskmanagement.models.Task;
import ro.app.taskmanagement.models.enums.TaskStatus;
import ro.app.taskmanagement.services.TaskService;

import java.util.List;

@CrossOrigin(origins = "${allowed.origins}")
@RestController
@RequestMapping("api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add-task/{id}")
    public ResponseEntity<Task> addTaskForUser(@PathVariable(value = "id") Long id,
                                               @Valid @RequestBody TaskDto dto) {

        Task task = taskService.createNewTask(id, dto);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PatchMapping("/update-task-status/{id}")
    public ResponseEntity<HttpStatus> updateTaskStatus(@PathVariable(value = "id") Long taskId,
                                                       @RequestParam TaskStatus status) {
        taskService.updateTaskStatus(taskId, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all-for-user/{id}")
    public ResponseEntity<List<Task>> getAllForUser(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(taskService.findAllTaskForUser(userId), HttpStatus.OK);
    }

    @DeleteMapping("remove-task/{id}")
    public ResponseEntity<HttpStatus> removeTask(@PathVariable("id") Long taskId) {
        taskService.removeTask(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
