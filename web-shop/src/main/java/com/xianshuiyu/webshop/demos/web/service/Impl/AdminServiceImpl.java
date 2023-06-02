package com.xianshuiyu.webshop.demos.web.service.Impl;

import com.xianshuiyu.webshop.demos.web.mapper.AdminMapper;
import com.xianshuiyu.webshop.demos.web.pojo.Admin;
import com.xianshuiyu.webshop.demos.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    AdminMapper adminMapper;
    public void save(Admin admin)
    {

    }

    public void delete(Integer id)
    {
        adminMapper.deleteById(id);
    }

    public Admin findAdminById(Integer id)
    {
        Admin admin = adminMapper.findAdminById(id);
        return admin;
    }

    public List<Admin> findAllAdmins()
    {
        List<Admin> allAdmins = adminMapper.findAllAdmins();
        return allAdmins;
    }

    public void update(Admin admin)
    {
        adminMapper.updateAdmin(admin);
    }

    public Admin getUserByLoginNameAndPassword(Admin admin)
    {
        Admin res = adminMapper.findAdminByUsernameAndPassword(admin);
        return res;
    }

    @Override
    public void addAdmin(Admin admin)
    {
        adminMapper.addAdmin(admin);
    }
}
