package org.sacc.interact.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TeachingEvaluation {
    private Integer id;

    private Integer lessonId;

    private String remark;

    private Date createdAt;

    private Date updatedAt;

    public TeachingEvaluation(Integer lessonId, String remark) {
        this.lessonId = lessonId;
        this.remark = remark;
    }
}
