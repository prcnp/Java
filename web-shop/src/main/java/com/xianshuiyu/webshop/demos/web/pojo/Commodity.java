package com.xianshuiyu.webshop.demos.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commodity
{
    private Integer commodityId;
    private Integer commodityAmount;		//商品总数量

    private String commodityDepict;			//商品描述

    private Integer commodityLeaveNum;		//商品剩余数量

    private String commodityName;			//商品名称

    private Double commodityPrice;			//商品价格

    private String image;

    private String manufacturer;			//生产厂家
    private Double webPrice;				//商城价格

    private Integer categoryId;             //商品种类

}
