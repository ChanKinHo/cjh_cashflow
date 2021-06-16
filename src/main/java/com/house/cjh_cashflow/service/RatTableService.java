package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.exception.ServiceException;
import org.springframework.stereotype.Service;

public interface RatTableService {

    RatTableDto getInitRatCareer(String career, long playerId, String roomCode);

    Long insertRat(RatTableForm ratTableForm);

    StockDto addStock(RatTableForm form) throws ServiceException;
}
