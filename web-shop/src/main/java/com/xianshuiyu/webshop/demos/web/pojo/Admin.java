package com.xianshuiyu.webshop.demos.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin
{
    private Integer adminId;
    private String username;
    private String password;
}
