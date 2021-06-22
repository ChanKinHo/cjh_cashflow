package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.exception.ServiceException;

public interface StockService {
    StockDto addStock(RatTableForm form) throws ServiceException;

    void sellStockById(String stockId, String ratId, String roomCode, String passiveIncome, String totalIncome, String totalCashFlow);

}
