package com.xianshuiyu.webshop.demos.web.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xianshuiyu.webshop.demos.web.mapper.OrderFormMapper;
import com.xianshuiyu.webshop.demos.web.pojo.OrderForm;
import com.xianshuiyu.webshop.demos.web.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderFormServiceImpl implements OrderFormService
{
    @Autowired
    OrderFormMapper orderFormMapper;
    public void save(OrderForm orderForm)
    {
        orderFormMapper.save(orderForm);
    }

    public void delete(Integer id)
    {
        orderFormMapper.deleteById(id);
    }

    public OrderForm findOrderFormById(Integer id)
    {
        OrderForm orderForm = orderFormMapper.findOrderFormById(id);
        return orderForm;
    }

    public List<OrderForm> findAllOrderForms(Integer pageNum, Integer pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderForm> orderForms = orderFormMapper.findAllOrderForms();
        return orderForms;
    }

    public void update(OrderForm orderForm)
    {
        orderFormMapper.update(orderForm);
    }

    public OrderForm queryOrderForm(Integer orderFormId)
    {
        return null;
    }

    public List<OrderForm> findOrderFormByUserId(Integer userId, Integer pageNum, Integer pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderForm> orderForms = orderFormMapper.findOrderFormByUserId(userId);
        return orderForms;
    }

    @Override
    public void conOrder(Integer id)
    {
        orderFormMapper.conOrder(id);
    }
}
