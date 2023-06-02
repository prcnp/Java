package com.xianshuiyu.webshop.demos.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm
{
    private Integer orderFormId;	//订单编号

    private Integer UserId;

    private String isPayoff;//买家是否付款
    private String submitTime;//提交订单时间

    private String paymentTime;
    private String consignmentTime;	//发货时间
    private Double totalPrice;		//总金额
    private String remark;			//买家备注

    private String isConsigned;	//是否发货
    private Long orderFormNum;	//订单流水号
    private Integer CommodityId;
}
