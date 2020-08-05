package org.sacc.interact.entity;

import lombok.Data;

import java.util.Date;
@Data
public class HomeworkSubmission {
    private Integer id;

    private Integer homeworkId;

    private Integer userId;

    private byte[] content;

    private String remark;

    private Integer isShow;

    private Date createdAt;

    private Date updateAt;
}
