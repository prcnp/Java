package com.xianshuiyu.webshop.demos.web.mapper;

import com.xianshuiyu.webshop.demos.web.pojo.OrderForm;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderFormMapper
{

    @Select("select * from orderform")
    List<OrderForm> findAllOrderForms();

    @Select("select * from orderform where orderFormID like concat('%',#{id},'%')")
    OrderForm findOrderFormById(Integer id);

    @Delete("delete from orderform where orderFormID = #{id}")
    void deleteById(Integer id);

    void save(OrderForm orderForm);

    @Select("select * from orderform where userId like concat('%',#{userId},'%')")
    List<OrderForm> findOrderFormByUserId(Integer userId);

    @Select("update orderform set isConsigned = 'true',consignmentTime = now() where orderFormID = #{id}")
    void conOrder(Integer id);


    void update(OrderForm orderForm);
}
