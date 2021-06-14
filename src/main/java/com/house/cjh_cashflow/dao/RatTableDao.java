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

    RatTableDto getInitRatCareer(@Param(value = "career") String career);

    void insertRat(RatTableForm ratTableForm);

    Long selectId(RatTableForm ratTableForm);

    RatTableDto selectRatById(@Param(value = "ratId") String ratId, @Param(value = "roomCode")String roomCode, @Param(value = "playerId")String playerId);

    List<EstateCompanyDto> selectEstateCompanyList(@Param(value = "ratId")String ratId, @Param(value = "roomCode")String roomCode);

    void insertStockItem(PropertyForm form);
}
