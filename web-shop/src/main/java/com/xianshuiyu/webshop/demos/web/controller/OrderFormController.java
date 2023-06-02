package com.xianshuiyu.webshop.demos.web.controller;

import com.xianshuiyu.webshop.demos.web.pojo.Commodity;
import com.xianshuiyu.webshop.demos.web.pojo.OrderForm;
import com.xianshuiyu.webshop.demos.web.pojo.Result;
import com.xianshuiyu.webshop.demos.web.pojo.User;
import com.xianshuiyu.webshop.demos.web.service.CommodityService;
import com.xianshuiyu.webshop.demos.web.service.OrderFormService;
import com.xianshuiyu.webshop.demos.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/orderForm")
public class OrderFormController
{
    @Autowired
    OrderFormService orderFormService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/listOrderForms")
    public Result listOrderForm(@RequestParam Integer pageNum,@RequestParam Integer pageSize)
    {
        log.info("查询所有订单信息");
        List<OrderForm> orderForms = orderFormService.findAllOrderForms(pageNum,pageSize);
        return Result.success(orderForms);
    }

    @GetMapping("/getOrderFormById")
    public Result getOrderFormById(@RequestParam Integer id)
    {
        log.info("根据id查询订单信息 id：{}",id);
        OrderForm orderForm = orderFormService.findOrderFormById(id);
        if(orderForm == null)
        {
            return Result.error("订单不存在");
        }
        return Result.success(orderForm);
    }

    @DeleteMapping("/deleteOrderFormById")
    public Result deleteOrderForm(@RequestParam Integer id)
    {
        log.info("根据id删除订单信息 id：{}",id);
        OrderForm orderForm = orderFormService.findOrderFormById(id);
        if(orderForm == null)
        {
            return Result.error("订单不存在");
        }
        orderFormService.delete(id);

        //删除订单后将商品的库存数量加1
        Commodity commodity = commodityService.findCommodityById(orderForm.getCommodityId());
        commodity.setCommodityAmount(commodity.getCommodityAmount() + 1);
        commodityService.update(commodity);
        return Result.success();
    }

    @PostMapping("/addOrderForm")
    public Result addOrderForm(@RequestBody OrderForm orderForm)
    {
        log.info("添加订单信息：{}",orderForm);
        if(commodityService.findCommodityById(orderForm.getCommodityId())==null)
        {
            return Result.error("商品id有误");
        }
        orderFormService.save(orderForm);

        //生成订单后将商品的库存数量减1
        Commodity commodity = commodityService.findCommodityById(orderForm.getCommodityId());
        commodity.setCommodityAmount(commodity.getCommodityAmount() - 1);
        commodityService.update(commodity);
        return Result.success();
    }

    @GetMapping("/getOrderFormByUserId")
    public Result getOrderFormByUserId(@RequestParam Integer userId,@RequestParam Integer pageNum,@RequestParam Integer pageSize)
    {
        log.info("根据用户ID查询订单信息：{}",userId);
        List<OrderForm> orderForms = orderFormService.findOrderFormByUserId(userId,pageNum,pageSize);
        return Result.success(orderForms);
    }


    @PutMapping("/conOrderById")
    public Result conOrderById(@RequestParam Integer id)
    {
        log.info("订单发货");
        OrderForm test = orderFormService.findOrderFormById(id);
        if(test == null)
        {
            return Result.error("商品不存在");
        }
        else if(test.getIsConsigned().equals("true"))
        {
            return Result.error("订单已发货");
        }
        orderFormService.conOrder(id);
         return Result.success();
    }

    @PutMapping("/updateOrderForm")
    public Result update(@RequestBody OrderForm orderForm)
    {
        log.info("修改订单信息：{}",orderForm);
        if(orderFormService.findOrderFormById(orderForm.getOrderFormId()) == null)
        {
            return Result.error("订单不存在");
        }
        if(commodityService.findCommodityById(orderForm.getCommodityId())==null)
        {
            return Result.error("商品id有误");
        }
        if(userService.findUserById(orderForm.getUserId()) == null)
        {
            return Result.error("用户id不存在");
        }

        //根据商品实际价格设置订单中的价格信息
        orderForm.setTotalPrice(commodityService.findCommodityById(orderForm.getCommodityId()).getCommodityPrice());


        orderFormService.update(orderForm);
        return Result.success();
    }


    @PostMapping("/pay")
    public Result pay(@RequestParam Integer id)
    {
        OrderForm orderForm = orderFormService.findOrderFormById(id);
        User user = userService.findUserById(orderForm.getUserId());

        if(Objects.equals(orderForm.getIsPayoff(),"true"))
        {
            return Result.error("订单已付款");
        }

        double moneyLeft;
        if(user.getMoney()<orderForm.getTotalPrice())
        {
            return Result.error("用户余额不足");
        }

        moneyLeft = user.getMoney() - orderForm.getTotalPrice();
        user.setMoney(moneyLeft);
        userService.update(user);

        orderForm.setIsPayoff("true");
        orderForm.setPaymentTime(String.valueOf(LocalDateTime.now()));
        orderFormService.update(orderForm);
        return Result.success();

    }
}
