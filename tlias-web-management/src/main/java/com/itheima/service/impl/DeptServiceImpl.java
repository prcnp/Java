package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> list()
    {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id)
    {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept)
    {
        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public Dept search(Integer id)
    {

        return deptMapper.search(id);
    }

    @Override
    public void modifyById(Dept dept)
    {
        deptMapper.modifyById(dept);
    }


}
