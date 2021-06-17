package com.house.cjh_cashflow.service.impl;

import com.house.cjh_cashflow.controller.form.PlayerForm;
import com.house.cjh_cashflow.dao.PlayerDao;
import com.house.cjh_cashflow.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Resource
    PlayerDao playerDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createPlayerInfo(String career, String roomCode, String playerName, String careerName) {

        PlayerForm form = new PlayerForm();
        form.setCareer(career);
        form.setName(playerName);
        form.setCareerName(careerName);
        form.setRoomCode(roomCode);
        playerDao.insertPlayer(form);

        return form.getId();

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long checkPlayerNameExist(String playerName, String roomCode) {

        return playerDao.checkNameExist(playerName, roomCode);
    }
}
