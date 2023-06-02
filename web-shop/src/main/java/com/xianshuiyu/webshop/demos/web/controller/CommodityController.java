package com.xianshuiyu.webshop.demos.web.controller;

import com.xianshuiyu.webshop.demos.web.pojo.Commodity;
import com.xianshuiyu.webshop.demos.web.pojo.Result;
import com.xianshuiyu.webshop.demos.web.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;

@RestController
@Slf4j
@RequestMapping("/commodities")
public class CommodityController
{
    @Autowired
    CommodityService commodityService;

    @GetMapping("/getAllCommodities")
    public Result listCommodity(@RequestParam Integer pageNum,@RequestParam Integer pageSize)
    {
        log.info("列出所有商品信息");
        List<Commodity> allCommodities = commodityService.findAllCommodities(pageNum,pageSize);
        return Result.success(allCommodities);
    }
    @DeleteMapping("/deleteCommodityById")
    public Result deleteCommodity(@RequestParam Integer id)
    {
        log.info("根据传入的商品ID删除商品信息: {}",id);
        if(id==null||commodityService.findCommodityById(id) == null)
        {
            return Result.error("商品不存在");
        }
        commodityService.delete(id);
        return Result.success();
    }

    @GetMapping("/findCommodityById")
    public Result findCommodityById(@RequestParam Integer id)
    {
        log.info("根据id查询商品信息： {}",id);
        Commodity commodity = commodityService.findCommodityById(id);
        return Result.success(commodity);
    }
    @GetMapping("/findCommodityByName")
    public Result findCommodityByName(@RequestParam String name)
    {
        log.info("根据商品名称查询商品信息： {}",name);
        List<Commodity> commodities = commodityService.findCommoditiesByName(name);
        return Result.success(commodities);
    }

    @GetMapping("/findCommodityByClassId")
    public Result findCommodityByClass(@RequestParam Integer id)
    {
        log.info("根据商品种类id查询商品信息：{}",id);
        List<Commodity> commodities = commodityService.findCommodityByClass(id);
        return Result.success(commodities);
    }

    @PutMapping("/update")
    public Result updateCommodity(@RequestBody Commodity commodity)
    {
        log.info("修改商品信息：{}",commodity);
        if(commodity.getCommodityId() == null
        || commodityService.findCommodityById(commodity.getCommodityId()) == null)
        {
            return Result.error("商品不存在");
        }
        commodityService.update(commodity);
        return Result.success();
    }

    @PostMapping("/addCommodity")
    public Result addCommodities(@RequestBody Commodity commodity)
    {
        log.info("添加商品信息:{}",commodity);
        commodityService.save(commodity);
        return Result.success();
    }
}
