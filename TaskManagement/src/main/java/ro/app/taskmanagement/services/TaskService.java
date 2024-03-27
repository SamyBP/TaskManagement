package ro.app.taskmanagement.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.app.taskmanagement.dataAccess.ITaskRepository;
import ro.app.taskmanagement.dataAccess.IUserRepository;
import ro.app.taskmanagement.dtos.TaskDto;
import ro.app.taskmanagement.exceptions.NoRowsAffectedException;
import ro.app.taskmanagement.exceptions.ResourceNotFoundException;
import ro.app.taskmanagement.mappers.Mapper;
import ro.app.taskmanagement.models.Task;
import ro.app.taskmanagement.models.User;
import ro.app.taskmanagement.models.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final ITaskRepository taskRepository;
    private final IUserRepository userRepository;
    private final Mapper<Task> mapper;

    @Autowired
    public TaskService(ITaskRepository taskRepository, Mapper<Task> mapper, IUserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public Task createNewTask(Long id, TaskDto dto) throws EntityNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Task newTask = mapper.createMap(dto, Task.class);
        newTask.setUser(user);
        newTask.setCreatedDate(LocalDateTime.now());
        newTask.setStatus(TaskStatus.TODO);

        return taskRepository.save(newTask);
    }

    @Transactional
    public void updateTaskStatus(Long id, TaskStatus status) {
        if (taskRepository.updateTaskStatus(id, status) == 0)
            throw new NoRowsAffectedException("Could not update task " + id);
    }

    public List<Task> findAllTaskForUser(Long userId) {
        return taskRepository.findAllByUser_Id(userId);
    }

    @Transactional
    public void removeTask(Long taskId) {
        taskRepository.deleteTaskById(taskId);
    }
}
