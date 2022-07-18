package com.house.cjh_cashflow.learnbatis.dao;

import com.house.cjh_cashflow.learnbatis.entity.User;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    List<User> queryUserList();

    User queryById(Long id);

    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    User queryById1(Long id);

    void updateById(@Param("id") Long id, @Param("username") String username);
}
