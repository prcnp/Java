package com.xianshuiyu.webshop.demos.web.service;

import com.xianshuiyu.webshop.demos.web.pojo.User;

import java.util.List;

public interface UserService
{
    public void save(User user);
    public void delete(Integer id);
    public User findUserById(int id);
    public List<User> findAllUsers(Integer pageNum, Integer pageSize);
    public void update(User user);
    //public void initPassword(User user);
    public User getUserByUsernameAndPassword(User user);
    public List<User> findUserByName(String name);
    public User queryUser(String username);
    public User findUserByinfo(String username, String name, String sex,
                               String phone, String post, String address, String email);

    List<User> findUserByUsername(String username);
}
