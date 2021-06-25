package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.controller.form.RichTableForm;
import com.house.cjh_cashflow.dto.RichTableDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RichDao {
    void createPlayerRich(RichTableForm richTableForm);

    RichTableDto findExactOne(@Param(value = "roomCode") String roomCode,
                              @Param(value = "playerId")String playerId,
                              @Param(value = "playerName")String playerName);

    Long checkExist(@Param(value = "roomCode") String roomCode,
                    @Param(value = "playerId")String playerId);


    void backRat(@Param(value = "roomCode") String roomCode,
                 @Param(value = "playerId")String playerId);
}
