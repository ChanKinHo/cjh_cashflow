package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.exception.ServiceException;

public interface EstateCompanyService {
    EstateCompanyDto saveEstateInfo(RatTableForm form) throws ServiceException;

    void sellEstateById(String estateId, String ratId, String roomCode, String passiveIncome, String totalIncome, String totalCashFlow);
}
