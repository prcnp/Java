package com.xianshuiyu.webshop.demos.web.service;

import com.xianshuiyu.webshop.demos.web.pojo.Admin;

import java.util.List;

public interface AdminService
{
    public void save(Admin admin);
    public void delete(Integer id);
    public Admin findAdminById(Integer admin);
    public List<Admin> findAllAdmins();
    public void update(Admin admin);
    //public void initPassword(User user);
    public Admin getUserByLoginNameAndPassword(Admin admin);

    void addAdmin(Admin admin);
}
