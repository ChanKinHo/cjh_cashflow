package com.house.cjh_cashflow.service.impl;

import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.RoomForm;
import com.house.cjh_cashflow.dao.RoomDao;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.RoomDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.PlayerService;
import com.house.cjh_cashflow.service.RatTableService;
import com.house.cjh_cashflow.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

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
    public RoomDto createRoom(String roomName, String playerName) throws ServiceException {
        //生成6位整数房间号
        int roomNum = (int) ((Math.random()*900000-1)+100000);

        RoomForm roomForm = new RoomForm();
        roomForm.setCode(String.valueOf(roomNum));
        roomForm.setCreator(playerName);
        roomForm.setName(roomName);

        //查询表中有无重复房间号
        List<RoomDto> roomDtos = roomDao.queryRooms(roomForm);
        if (roomDtos != null) {
            throw new ServiceException(RespConstant.ROOM_NUM_EXISTS_CODE,RespConstant.ROOM_NUM_EXISTS_MSG);
        }


        roomDao.insertRoom(roomForm);

        RoomDto roomDto = new RoomDto();
        roomDto.setCode(String.valueOf(roomNum));

        return roomDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAndFeedBack(String roomName, String playerName, String career, ModelMap map) throws ServiceException {
        //保存房间
        RoomDto roomDto = createRoom(roomName, playerName);

        //生成玩家信息
        long playerId = playerService.createPlayerInfo(career,roomDto.getCode(),playerName);

        //获取初始老鼠表并生成玩家老鼠表
        RatTableDto ratTableDto = ratTableService.getInitRatCareer(career, playerId, roomDto.getCode());

        map.addAttribute("ratObj", ratTableDto);
        map.addAttribute("roomObj",roomDto);
    }
}
