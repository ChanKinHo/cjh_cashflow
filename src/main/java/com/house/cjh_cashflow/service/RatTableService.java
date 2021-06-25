package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.RatTableDto;


public interface RatTableService {

    RatTableForm getInitRatCareer(String career, long playerId, String roomCode);

    Long insertRat(RatTableForm ratTableForm);

    RatTableDto findExactRatInfo(String playerId, String roomCode, String ratId, String playerName);

    void borrowBank(RatTableForm form);

    void makeChild(RatTableForm form);

    void backFixLoans(RatTableForm form);

    boolean judgeIsRich(String playerId, String playerName, String roomCode);

}
