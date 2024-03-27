package ro.app.taskmanagement.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.app.taskmanagement.models.Task;
import ro.app.taskmanagement.models.enums.TaskStatus;

import java.util.List;


public interface ITaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUser_Id(Long id);

    void deleteTaskById(Long id);

    @Modifying
    @Query("UPDATE Task t SET t.status = :status WHERE t.id = :taskId")
    int updateTaskStatus(@Param("taskId") Long taskId, @Param("status") TaskStatus status);
}
