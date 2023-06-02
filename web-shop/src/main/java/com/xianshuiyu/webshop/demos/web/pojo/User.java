package com.xianshuiyu.webshop.demos.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    private Integer userId;			//用户编号
    private String username;		//用户名
    private String password;		//密码
    private String name;			//姓名
    private String sex;				//性别
    private String address;			//住址
    private String phone;			//联系电话
    private String post;			//邮寄地址
    private String email;			//Email地址

    private Double money;			//用户账户金额
}
