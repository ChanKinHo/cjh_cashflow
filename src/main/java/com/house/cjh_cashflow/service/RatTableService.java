package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.exception.ServiceException;

public interface RatTableService {

    RatTableDto getInitRatCareer(String career, long playerId, String roomCode);

    Long insertRat(RatTableForm ratTableForm);

    RatTableDto addProperties(PropertyForm form) throws ServiceException;
}
