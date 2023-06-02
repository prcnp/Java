package com.xianshuiyu.webshop.demos.web.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xianshuiyu.webshop.demos.web.mapper.CommodityMapper;
import com.xianshuiyu.webshop.demos.web.pojo.Commodity;
import com.xianshuiyu.webshop.demos.web.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService
{
    @Autowired
    CommodityMapper commodityMapper;
    public void save(Commodity commodity)
    {
        commodityMapper.save(commodity);
    }

    public void delete(Integer id)
    {
        commodityMapper.DeleteByCommodity(id);
    }

    public Commodity findCommodityById(int id)
    {
        Commodity commodity =  commodityMapper.findCommoditiyById(id);
        return commodity;
    }

    public List<Commodity> findAllCommodities(Integer pageNum,Integer pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> allCommodities = commodityMapper.findAllCommodities();
        return allCommodities;
    }

    public void update(Commodity commodity)
    {
        commodityMapper.updateCommodityInfo(commodity);
    }

    public List<Commodity> findCommoditiesByName(String Name)
    {
        List<Commodity> commodities = commodityMapper.findCommoditiesByName(Name);
        return commodities;
    }

    @Override
    public List<Commodity> findCommodityByClass(Integer id)
    {
        List<Commodity> commodities = commodityMapper.findCommodityByClass(id);
        return commodities;
    }


}
