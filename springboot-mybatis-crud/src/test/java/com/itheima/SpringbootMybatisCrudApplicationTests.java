package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    EmpMapper empMapper;

    @Test
    public void test()
    {
        int a = empMapper.delete(17);
        System.out.println(a);
    }

    @Test
    public void testInsert()
    {
        Emp emp = new Emp();
        emp.setUsername("Tom3");
        emp.setName("汤姆3");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntryDate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        //执行新增员工操作

        empMapper.insert(emp);
        System.out.println("-------------------------");
        System.out.println("\n\n" + emp.getId() + "\n\n");
        System.out.println("-------------------------");
    }
    @Test
    public void testUpdate()
    {
        Emp emp = new Emp();
        emp.setUsername("Tom3");
        emp.setName("汤姆3");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntryDate(LocalDate.of(2000,1,1));

        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //Update
        empMapper.update(emp);
    }


    @Test
    public void testGetById()
    {
        Emp byId = empMapper.getById(10);
        System.out.println(byId);

    }



}
