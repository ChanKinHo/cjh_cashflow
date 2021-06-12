package com.house.cjh_cashflow.service.impl;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.constant.CareerEunm;
import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.controller.form.RoomForm;
import com.house.cjh_cashflow.dao.RoomDao;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.RoomDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.PlayerService;
import com.house.cjh_cashflow.service.RatTableService;
import com.house.cjh_cashflow.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomSerivceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;

    @Autowired
    RatTableService ratTableService;

    @Autowired
    PlayerService playerService;

    @Override
    public List<RoomDto> queryRooms() {
        return roomDao.queryRooms(new RoomForm());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createRoom(String roomName, String playerName) throws ServiceException {
        //生成6位整数房间号
        int roomNum = (int) ((Math.random()*900000-1)+100000);

        String roomCode = String.valueOf(roomNum);
        RoomForm roomForm = new RoomForm();
        roomForm.setCode(roomCode);
        roomForm.setCreator(playerName);
        roomForm.setName(roomName);

        //查询表中有无重复房间号
        Long count = roomDao.checkRoomCodeExist(roomCode);

        System.out.println("胜多负少的：" + count);

        if (count != null && count > 0) {
            throw new ServiceException(RespConstant.ROOM_NUM_EXISTS_CODE,RespConstant.ROOM_NUM_EXISTS_MSG);
        }

        roomDao.insertRoom(roomForm);

        return roomCode;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAndFeedBack(String roomName, String playerName, String career, ModelMap map) throws ServiceException {
        //保存房间
        String roomCode = createRoom(roomName, playerName);

        //检测同一房间玩家名重复
        Long count = playerService.checkPlayerNameExist(playerName, roomCode);
        if (count != null && count>0) {
            throw new ServiceException(RespConstant.PLAYER_NAME_EXISTS_CODE, RespConstant.PLAYER_NAME_EXISTS_MSG);
        }
        //生成玩家信息
        Long playerId = playerService.createPlayerInfo(career,roomCode,playerName);

        //获取初始老鼠表并生成玩家老鼠表
        RatTableDto ratTableDto = ratTableService.getInitRatCareer(career, playerId, roomCode);
        ratTableDto.setRoomCode(roomCode);
        ratTableDto.setPlayerName(playerName);
        ratTableDto.setCareerName(CareerEunm.map.get(career));
        ratTableDto.setPlayerId(playerId);

        RatTableForm ratTableForm = new RatTableForm();
        BeanUtils.copyProperties(ratTableDto, ratTableForm);

        //生成玩家老鼠表
        Long ratId = ratTableService.insertRat(ratTableForm);

        ratTableDto.setId(ratId);
        map.addAttribute("ratObj", ratTableDto);
    }
}
