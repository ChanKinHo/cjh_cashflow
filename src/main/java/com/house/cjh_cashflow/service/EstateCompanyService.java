package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.exception.ServiceException;

public interface EstateCompanyService {
    void saveEstateInfo(PropertyForm form) throws ServiceException;

    void sellEstateById(String estateId, String ratId, String roomCode, String passiveIncome, String totalIncome, String totalCashFlow);
}
