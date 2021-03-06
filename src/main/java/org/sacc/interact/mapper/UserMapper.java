package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.*;
import org.sacc.interact.entity.User;
import org.sacc.interact.model.UserInfo;
import org.sacc.interact.model.UserRegisterParam;

@Mapper
public interface UserMapper {

    @Select({
            "select id,name,nick,student_id,phone_number,email,qq,password,avatar,role,group_id,created_at,updated_at",
    " from user where email = #{email,jdbcType=VARCHAR}"})
    User selectByEmail(String email);

    @Insert({"insert into user (nick,email,password,role,created_at,updated_at) values ",
    "(#{param.nick,jdbcType=VARCHAR},#{param.email,jdbcType=VARCHAR},#{param.password,jdbcType=VARCHAR},0,NOW(),NOW())"})
    int insert(@Param("param") UserRegisterParam param);


    @Update("update user set avatar = #{avatarPath} where id = #{userId}")
    boolean updateAvatar(String avatarPath,Integer userId);

    @Update("update user set password = #{password} where id=#{userId}")
    boolean changePassword(Integer userId,String password);

    @Select({"select id,name,nick,student_id,phone_number,email,qq,password,avatar,role,group_id,created_at,updated_at",
            " from user where id = #{userId}"})
    User selectById(Integer userId);

    @Update("update user set email = #{email} where id = #{userId}")
    boolean changeEmail(Integer userId,String email);

    @Update("update user set nick = #{nickname} where id = #{userId}")
    boolean changeNick(Integer userId, String nickname);

    @Update("update user set name = #{name} where id = #{userId}")
    boolean changeName(Integer userId, String name);

    @Update("update user set student_id = #{studentId} where id = #{userId}")
    boolean changeStudentId(Integer userId, String studentId);

    @Update("update user set group_id = #{groupId} where id = #{userId}")
    boolean changeGroupId(Integer userId, Integer groupId);
}
