package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.controller.form.PlayerForm;
import com.house.cjh_cashflow.dto.PlayerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlayerDao {
    void insertPlayer(PlayerForm form);

    Long checkNameExist(@Param(value = "playerName") String playerName, @Param(value = "roomCode") String roomCode);

    List<PlayerDto> findListByRoomCode(@Param(value = "roomCode") String roomCode);

    String findNameById(@Param(value = "id") String playerId);

    void becomeRich(@Param(value = "playerId") Long playerId);

    void becomeRat(Long playerId);

    String checkRich(@Param(value = "playerId")String playerId, @Param(value = "playerName") String playerName, @Param(value = "roomCode") String roomCode);
}
