package org.sacc.interact.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Lesson {
    private int id;

    @NotNull(message = "课程名称不能为空")
    private String name;

    @NotNull(message = "组别id不能为空")
    private int groupId;
    private String desc;//desc是mysql关键字
    private String location;
    private int type;
    private String liveUrl;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//入参格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//出参格式化
    private LocalDateTime time;

    @NotNull(message = "创建时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

    @NotNull(message = "更新时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getDesc() {
        return desc;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public int getType() {
        return type;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
