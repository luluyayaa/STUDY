package com.lulu.mapper;

import com.lulu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from tb_user")
    List<User> selectAll();

    @Select("select * from tb_user where name = #{name} and password = #{password}")
    User select(@Param("name") String name, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     * @param name
     * @return
     */
    @Select("select * from tb_user where name = #{name}")
    User selectByName(String name);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into tb_user values(null,#{name},#{password},#{tel})")
    void add(User user);
}