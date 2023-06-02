package com.itheima.mapper;

import com.itheima.pojo.Dept;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.*;
import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

    /**
     * 查询全部部门信息
     * @return
     */
    @Select("select  * from dept ")
    List<Dept> list();

    /**
     * 根据id删除部门
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);


    /**
     * 新增部门信息
     * @param dept
     */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
    @Select("select * from dept where id = #{id}")
    Dept search(Integer id);

    /**
     * 根据id编辑部门信息
     * @param dept
     */
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void modifyById(Dept dept);
}
