package com.xianshuiyu.webshop.demos.web.service;

import com.xianshuiyu.webshop.demos.web.pojo.OrderForm;

import java.util.List;

public interface OrderFormService
{
    public void save(OrderForm orderForm);
    public void delete(Integer id);
    public OrderForm findOrderFormById(Integer id);
    public List<OrderForm> findAllOrderForms(Integer pageNum, Integer pageSize);
    public void update(OrderForm orderForm);
    public OrderForm queryOrderForm(Integer orderFormId);
    public List<OrderForm> findOrderFormByUserId(Integer userId, Integer pageNum, Integer pageSize);

    void conOrder(Integer id);
}
