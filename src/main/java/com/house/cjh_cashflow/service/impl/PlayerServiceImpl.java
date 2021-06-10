package com.house.cjh_cashflow.service.impl;

import com.house.cjh_cashflow.controller.form.PlayerForm;
import com.house.cjh_cashflow.dao.PlayerDao;
import com.house.cjh_cashflow.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerDao playerDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long createPlayerInfo(String career, String roomCode, String playerName) {

        PlayerForm form = new PlayerForm();
        form.setCareer(career);
        form.setName(playerName);

        form.setRoomCode(roomCode);
        playerDao.insertPlayer(form);

        return playerDao.selectId(form);
    }
}
