package com.xianshuiyu.webshop.demos.web.mapper;

import com.xianshuiyu.webshop.demos.web.pojo.Commodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CommodityMapper
{
    /**
     * 查询返回所有商品信息
     * @return
     */
    @Select("select * from commodities")
    List<Commodity> findAllCommodities();

    /**
     * 根据id删除商品信息
     * @param id
     */
    @Delete("delete from commodities where commodityId = #{id}")
    void DeleteByCommodity(Integer id);

    /**
     * 根据商品ID查询商品信息
     * @param id
     * @return
     */
    @Select("select * from commodities where commodityId = #{id}")
    Commodity findCommoditiyById(Integer id);

    /**
     * 根据商品名字模糊查询商品信息
     * @param name
     * @return
     */
    @Select("select * from commodities where commodityName like CONCAT('%', #{name}, '%')")
    List<Commodity> findCommoditiesByName(String name);

    @Select("select * from commodities where categoryId = #{id}")
    List<Commodity> findCommodityByClass(Integer id);

    /**
     * 使用xml映射 更新商品信息
     * @param commodity
     */
    void updateCommodityInfo(Commodity commodity);


    void save(Commodity commodity);
}
