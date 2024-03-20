package ro.app.taskmanagement.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.app.taskmanagement.models.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
