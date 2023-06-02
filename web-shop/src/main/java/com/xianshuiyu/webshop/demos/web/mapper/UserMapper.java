package com.xianshuiyu.webshop.demos.web.mapper;

import com.xianshuiyu.webshop.demos.web.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper
{

    @Select("select * from users")
    List<User> findAllUsers();

    @Select("select * from users where name like concat('%',#{name},'%')")
    List<User> findUserByName(String name);

    @Select("select * from users where username like concat('%',#{username},'%')")
    List<User> findUserByUsername(String username);

    @Select("select * from users where userId = #{id}")
    User findUserById(int id);

    @Delete("delete from users where userId = #{id}")
    void delete(Integer id);

    void update(User user);

    @Select("select * from  users where username = #{username} and password = #{password}")
    User getUserByLoginNameAndPassword(User user);

    void save(User user);
}
