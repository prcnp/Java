package com.xianshuiyu.webshop.demos.web.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xianshuiyu.webshop.demos.web.mapper.UserMapper;
import com.xianshuiyu.webshop.demos.web.pojo.User;
import com.xianshuiyu.webshop.demos.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserMapper userMapper;

    public void save(User user)
    {
        userMapper.save(user);
    }

    public void delete(Integer id)
    {
        userMapper.delete(id);
    }

    public User findUserById(int id)
    {
        User user = userMapper.findUserById(id);
        return user;
    }

    public List<User> findAllUsers(Integer pageNum, Integer pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.findAllUsers();
        return users;
    }

    public void update(User user)
    {
        userMapper.update(user);
    }


    public User getUserByUsernameAndPassword(User user)
    {
        User res = userMapper.getUserByLoginNameAndPassword(user);
        return res;
    }

    public User getUserByLoginNameAndPassword(String username, String password)
    {
        return null;
    }

    public List<User> findUserByName(String name)
    {
        List<User> users = userMapper.findUserByName(name);
        return users;
    }

    public User queryUser(String username)
    {
        return null;
    }

    public User findUserByinfo(String username, String name, String sex, String phone, String post, String address, String email)
    {
        return null;
    }

    @Override
    public List<User> findUserByUsername(String username)
    {
        List<User> users = userMapper.findUserByUsername(username);
        return users;
    }
}
