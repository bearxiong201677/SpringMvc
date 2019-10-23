package com.springmvc.dao.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.springmvc.api.model.User;
import com.springmvc.api.model.UserExample;
import com.springmvc.dao.annotation.Repository;


@Repository
public interface UserRepository {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    int batchInsert(List<User> userList);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}