package com.xianshuiyu.webshop.demos.web.controller;

import com.xianshuiyu.webshop.demos.web.Utils.JwtUtils;
import com.xianshuiyu.webshop.demos.web.pojo.Admin;
import com.xianshuiyu.webshop.demos.web.pojo.Result;
import com.xianshuiyu.webshop.demos.web.service.AdminService;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/admins")
public class AdminController
{
    @Autowired
    AdminService adminService;

    @GetMapping("/getAllAdmins")
    public Result listAdmin()
    {
        log.info("查询所有管理员信息");
        List<Admin> allAdmins = adminService.findAllAdmins();
        return Result.success(allAdmins);
    }

    @DeleteMapping("/deleteById")
    public Result deleteAdmin(@RequestParam Integer id)
    {
        log.info("根据id删除管理员：{}",id);
        if(adminService.findAdminById(id) == null)
        {
            return Result.error("管理员不存在");
        }
        adminService.delete(id);
        return Result.success();
    }

    @GetMapping("/findAdminById")
    public Result findAdminById(@RequestParam Integer id)
    {
        log.info("根据id查询管理员信息：{}",id);
        Admin admin = adminService.findAdminById(id);
        return Result.success(admin);
    }

    @PutMapping("/updateAdmin")
    public Result updateAdmin(@RequestBody Admin admin)
    {
        log.info("更新管理员信息：{}",admin);
        if(admin.getAdminId() == null)
        {
            return Result.error("管理员id为空");
        }
        if(adminService.findAdminById(admin.getAdminId()) == null)
        {
            return Result.error("管理员不存在");
        }
        adminService.update(admin);
        return Result.success();
    }

    @PostMapping("/addAdmin")
    public Result addAdmin(@RequestBody Admin admin)
    {
        log.info("新增管理员：{}",admin);
        adminService.addAdmin(admin);
        return Result.success();
    }


    @PostMapping("/login")
    public Result adminLogin(@RequestBody Admin admin)
    {
        log.info("管理员登录");
        Admin res = adminService.getUserByLoginNameAndPassword(admin);
        if(res!=null)//如果能查到数据，则登录成功，生成JWT令牌
        {
            Map<String,Object> claims = new HashMap<>();
            claims.put("adminId",res.getAdminId());
            claims.put("username",res.getUsername());
            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
