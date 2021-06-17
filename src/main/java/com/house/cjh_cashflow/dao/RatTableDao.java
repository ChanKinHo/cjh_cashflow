package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.dto.RatTableDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RatTableDao {

    RatTableForm getInitRatCareer(@Param(value = "career") String career);

    void insertRat(RatTableForm ratTableForm);

    Long selectId(RatTableForm ratTableForm);

    RatTableDto selectRatBySome(@Param(value = "ratId") String ratId, @Param(value = "roomCode")String roomCode,
                                @Param(value = "playerId")String playerId,
                                @Param(value = "playerName") String playerName);

    void updateRatSummary(RatTableForm form);
}
