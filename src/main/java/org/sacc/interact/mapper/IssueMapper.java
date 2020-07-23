package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.*;
import org.sacc.interact.pojo.Issue;
import org.sacc.interact.pojo.IssueReply;

import java.util.List;

@Mapper
public interface IssueMapper {

    @Select("SELECT * FROM issue WHERE group_id=#{groupId} ORDER BY updated_at DESC")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="user_id", property="userId"),
            @Result(column="content", property="content"),
            @Result(column="group_id", property="groupId"),
            @Result(column="created_at", property="createTime"),
            @Result(column="updated_at", property="updateTime"),
    })
    List<Issue> getIssueList(int groupId);

    @Select("SELECT * FROM issue_reply WHERE issue_id=#{issueId} ORDER BY updated_at DESC")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="user_id", property="userId"),
            @Result(column="content", property="content"),
            @Result(column="issue_id", property="issueId"),
            @Result(column="created_at", property="createTime"),
            @Result(column="updated_at", property="updateTime"),
    })
    List<IssueReply> getIssueReplyList(int issueId);

    @Insert("INSERT INTO issue (user_id,content,created_at,updated_at,group_id) VALUES (#{userId},#{content},#{createTime},#{updateTime},#{groupId})")
    void addIssue(Issue issue);

    @Insert("INSERT INTO issue_reply (user_id,content,created_at,updated_at,issue_id) VALUES (#{userId},#{content},#{createTime},#{updateTime},#{issueId})")
    void addIssueReply(IssueReply issueReply);

    @Update("UPDATE issue SET content=#{content},updated_at=#{updateTime} WHERE id=#{id}")
    void updateIssue(Issue issue);

    @Update("UPDATE issue_reply SET content=#{content},updated_at=#{updateTime} WHERE id=#{id}")
    void updateIssueReply(IssueReply issueReply);

    @Delete("DELETE FROM issue WHERE id=#{id}")
    void deleteIssue(int id);

    @Delete("DELETE FROM issue_reply WHERE id=#{id}")
    void deleteIssueReply(int id);

    @Delete("DELETE FROM issue_reply WHERE issue_id=#{issueId}")
    void deleteIssueReplyByIssueId(int issueId);
}
