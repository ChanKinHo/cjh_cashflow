package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.controller.form.PlayerForm;

public interface PlayerService {

    long createPlayerInfo(String career, String roomCode, String playerName);
}
