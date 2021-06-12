package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.PlayerForm;

public interface PlayerService {

    Long createPlayerInfo(String career, String roomCode, String playerName);

    Long checkPlayerNameExist(String playerName, String roomCode);
}
