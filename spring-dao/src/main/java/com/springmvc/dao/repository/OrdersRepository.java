package com.springmvc.dao.repository;

import java.util.List;

import com.springmvc.dao.annotation.Repository;
import org.apache.ibatis.annotations.Param;
import com.springmvc.api.model.Orders;
import com.springmvc.api.model.OrdersExample;

@Repository
public interface OrdersRepository {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}