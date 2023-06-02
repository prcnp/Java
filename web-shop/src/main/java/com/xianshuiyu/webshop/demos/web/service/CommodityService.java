package com.xianshuiyu.webshop.demos.web.service;

import com.xianshuiyu.webshop.demos.web.pojo.Commodity;

import java.util.List;

public interface CommodityService
{
    public void save(Commodity commodity);
    public void delete(Integer id);
    public Commodity findCommodityById(int id);
    public List<Commodity> findAllCommodities(Integer pageNum,Integer pageSize);
    public void update(Commodity commodity);
    public List<Commodity> findCommoditiesByName(String Name);

    List<Commodity> findCommodityByClass(Integer id);
}
