package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.controller.form.PlayerForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlayerDao {
    void insertPlayer(PlayerForm form);

    Long selectId(PlayerForm form);

    Long checkNameExist(@Param(value = "playerName") String playerName, @Param(value = "roomCode") String roomCode);
}
