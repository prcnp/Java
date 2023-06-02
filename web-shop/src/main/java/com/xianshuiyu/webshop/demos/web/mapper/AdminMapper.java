package com.xianshuiyu.webshop.demos.web.mapper;

import com.xianshuiyu.webshop.demos.web.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper
{

    @Select("select * from admins")
    List<Admin> findAllAdmins();

    @Delete("delete from admins where adminId = #{id}")
    void deleteById(Integer id);

    @Select("select * from admins where adminId = #{id}")
    Admin findAdminById(Integer id);


    void updateAdmin(Admin admin);

    @Insert("insert into admins(password, username) values(#{password},#{username})")
    void addAdmin(Admin admin);

    @Select("select * from admins where username = #{username} and password = #{password}")
    Admin findAdminByUsernameAndPassword(Admin admin);
}
