package org.sacc.interact.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

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

    @NotNull
    private Date time;

    @NotNull
    private Date deadline;

    private Date createdAt;

    private Date updatedAt;


    public Homework(Integer id, Integer lessonId, Integer groupId, Integer owner, String name, String desc, Integer submitType, Date time, Date deadline, Date createdAt, Date updatedAt) {
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
