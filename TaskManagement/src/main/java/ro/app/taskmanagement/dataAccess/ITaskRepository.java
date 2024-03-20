package ro.app.taskmanagement.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.app.taskmanagement.models.Task;

public interface ITaskRepository extends JpaRepository<Task, Long> {
}
