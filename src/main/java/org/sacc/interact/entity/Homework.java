package org.sacc.interact.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Homework {
    private Integer id;

    private Integer lessonId;

    private Integer groupId;

    @NotNull
    private Integer owner;

    @NotNull
    private String name;

    private String desc;

    @NotNull
    private Integer submitType;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @NotNull
    private LocalDateTime time;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @NotNull
    private LocalDateTime deadline;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;


    public Homework(Integer id, Integer lessonId, Integer groupId, Integer owner, String name, String desc, Integer submitType, LocalDateTime time, LocalDateTime deadline, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.lessonId = lessonId;
        this.groupId = groupId;
        this.owner = owner;
        this.name = name;
        this.desc = desc;
        this.submitType = submitType;
        this.time = time;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
