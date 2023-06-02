package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 部门管理Controller
 */
@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
    @GetMapping
    public Result list()
    {
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门数据
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id)
    {
        log.info("根据id删除部门L:{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept)
    {
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }


    /**
     * 根据id查询部门
     */
    @GetMapping("/{id}")
    public Result serach(@PathVariable Integer id)
    {
        log.info("根据id查询部门：{}",id);
        Dept dept = deptService.search(id);
        return Result.success(dept);
    }

    /**
     * 修改部门信息
     * @return
     */
    @PutMapping
    public Result modify(@RequestBody Dept dept)
    {
        log.info("修改部门信息");

        dept.setUpdateTime(LocalDateTime.now());
        deptService.modifyById(dept);

        return Result.success();
    }
}
