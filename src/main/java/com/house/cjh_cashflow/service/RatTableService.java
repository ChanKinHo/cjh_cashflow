package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.RatTableDto;

public interface RatTableService {

    RatTableDto getInitRatCareer(String career, long playerId, String roomCode);

    Long insertRat(RatTableForm ratTableForm);
}
