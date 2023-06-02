package com.xianshuiyu.webshop.demos.web.controller;

import com.xianshuiyu.webshop.demos.web.Utils.JwtUtils;
import com.xianshuiyu.webshop.demos.web.mapper.UserMapper;
import com.xianshuiyu.webshop.demos.web.pojo.Admin;
import com.xianshuiyu.webshop.demos.web.pojo.Result;
import com.xianshuiyu.webshop.demos.web.pojo.User;
import com.xianshuiyu.webshop.demos.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public Result listUser(@RequestParam Integer pageNum,@RequestParam Integer pageSize)
    {
        log.info("查询所有用户信息");
        List<User> users = userService.findAllUsers(pageNum,pageSize);
        return Result.success(users);
    }

    @GetMapping("/findUserByName")
    public Result findUserByName(@RequestParam String name)
    {
        log.info("根据姓名查询用户信息:{}",name);
        List<User> users = userService.findUserByName(name);
        return Result.success(users);
    }

    @GetMapping("/findUserByUsername")
    public Result findUserByUsername(@RequestParam String username)
    {
        log.info("根据用户名模糊查询用户信息：{}",username);
        List<User> users = userService.findUserByUsername(username);
        return Result.success(users);
    }

    @GetMapping("/findUserById")
    public Result findUserById(@RequestParam Integer id)
    {
        log.info("根据id查询用户信息 id：{}",id);
        User user = userService.findUserById(id);
        return Result.success(user);
    }

    @DeleteMapping("/deleteUserById")
    public Result deleteUserById(@RequestParam Integer id)
    {
        log.info("根据id删除用户信息：{}",id);
        User user = userService.findUserById(id);
        if(user==null)
        {
            return Result.error("用户不存在");
        }
        userService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result updateUser(@RequestBody User user)
    {
        log.info("更新用户信息：{}",user);
        User test = userService.findUserById(user.getUserId());
        if(test==null)
        {
            return Result.error("用户不存在");
        }
        userService.update(user);
        return Result.success();
    }

    @PostMapping("/login")
    public Result userLogin(@RequestBody User user)
    {
        log.info("用户登录");
        User res = userService.getUserByUsernameAndPassword(user);
        if(res!=null)//如果能查到数据，则登录成功，生成JWT令牌
        {
            Map<String,Object> claims = new HashMap<>();
            claims.put("userId",res.getUserId());
            claims.put("username",res.getUsername());
            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

    @PostMapping("/register")
    public Result userRegister(@RequestBody User user)
    {
        log.info("用户注册");
        List<User> temp = userService.findUserByUsername(user.getUsername());
        if(temp.size()!=0)
        {
            return Result.error("用户名已被注册");
        }
        userService.save(user);
        return Result.success();
    }
}
