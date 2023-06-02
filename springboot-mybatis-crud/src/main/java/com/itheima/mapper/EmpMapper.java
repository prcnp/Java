package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {
    @Delete("delete from mybatis.emp where id = #{id}")
    int delete(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into mybatis.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    int insert(Emp emp);

    @Update(
            "update mybatis.emp set username = #{username},name = #{name},gender = #{gender},image = #{image},job = #{job},entrydate = #{entryDate}," +
                    "dept_id = #{deptId},update_time = #{updateTime} " +
            "where id = #{id}"
    )
    public void update(Emp emp);

    //@Select("select id, username, password, name, gender, image, job, entrydate, dept_id , create_time , update_time from emp where id = #{id}")
    public Emp getById(Integer id);



}
