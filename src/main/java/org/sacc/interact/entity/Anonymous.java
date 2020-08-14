package org.sacc.interact.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Anonymous {
    private Integer id;

    private Integer userId;

    private Integer lessonId;

    private Date createdAt;
}
