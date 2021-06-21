package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.exception.ServiceException;

public interface RatTableService {

    RatTableForm getInitRatCareer(String career, long playerId, String roomCode);

    Long insertRat(RatTableForm ratTableForm);

    StockDto addStock(RatTableForm form) throws ServiceException;

    RatTableDto findExactRatInfo(String playerId, String roomCode, String ratId, String playerName);


    void sellStockById(String stockId, String ratId, String roomCode, String passiveIncome, String totalIncome, String totalCashFlow);
}
