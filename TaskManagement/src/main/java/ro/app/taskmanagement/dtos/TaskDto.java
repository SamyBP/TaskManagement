package ro.app.taskmanagement.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@RequiredArgsConstructor
public class TaskDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String content;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-dd-mm")
    private String deadline;
}
