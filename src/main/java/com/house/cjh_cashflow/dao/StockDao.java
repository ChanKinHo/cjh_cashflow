package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.dto.StockDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StockDao {

    void addOneItemByRatId(PropertyForm property);

    List<StockDto> findByRatId(@Param(value = "ratId") Long ratId);

    void sellStockById(@Param(value = "id")String stockId, @Param(value = "ratId")String ratId, @Param(value = "roomCode")String roomCode);
}
