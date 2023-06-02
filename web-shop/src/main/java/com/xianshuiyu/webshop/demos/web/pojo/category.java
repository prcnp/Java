package com.xianshuiyu.webshop.demos.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class category
{
    private Integer categoryId;		//商品种类编号
    private String categoryName;		//商品种类名称
}
