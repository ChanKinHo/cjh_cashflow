package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.controller.form.PlayerForm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayerDao {
    void insertPlayer(PlayerForm form);

    long selectId(PlayerForm form);
}
