package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.dto.RichTableDto;

public interface RichService {
    void createRich(String roomCode, String playerId, String passiveIncome);

    RichTableDto findOneRich(String roomCode, String playerId, String playerName);

    void backToRat(String roomCode, String playerId, String richId);
}
