package org.sacc.interact.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sacc.interact.entity.User;
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

}
