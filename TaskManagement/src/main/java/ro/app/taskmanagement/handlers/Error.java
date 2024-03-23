package ro.app.taskmanagement.handlers;

import java.time.LocalDateTime;

public record Error(
        String path,
        String message,
        int statusCode,
        LocalDateTime time
) {
}
