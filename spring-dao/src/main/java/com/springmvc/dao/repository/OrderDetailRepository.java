package com.springmvc.dao.repository;

import java.util.List;

import com.springmvc.dao.annotation.Repository;
import org.apache.ibatis.annotations.Param;
import com.springmvc.api.model.OrderDetail;
import com.springmvc.api.model.OrderDetailExample;


@Repository
public interface OrderDetailRepository {
    int countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}