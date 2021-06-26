package com.house.cjh_cashflow.service.impl;

import com.house.cjh_cashflow.constant.CareerEunm;
import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.controller.form.RoomForm;
import com.house.cjh_cashflow.dao.PlayerDao;
import com.house.cjh_cashflow.dao.RoomDao;
import com.house.cjh_cashflow.dto.PlayerDto;
import com.house.cjh_cashflow.dto.RoomDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.PlayerService;
import com.house.cjh_cashflow.service.RatTableService;
import com.house.cjh_cashflow.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomSerivceImpl implements RoomService {

    private static final String PLAYER_ID = "playerId";
    private static final String ROOM_CODE = "roomCode";
    private static final String RAT_ID = "ratId";
    private Logger logger = LoggerFactory.getLogger(RoomSerivceImpl.class);

    @Resource
    RoomDao roomDao;

    @Resource
    PlayerDao playerDao;

    @Resource
    RatTableService ratTableService;

    @Resource
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

        if (count != null && count > 0) {
            throw new ServiceException(RespConstant.ROOM_NUM_EXISTS_CODE,RespConstant.ROOM_NUM_EXISTS_MSG);
        }

        roomDao.insertRoom(roomForm);

        return roomCode;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAndFeedBack(String roomName, String playerName, String career, ModelAndView mv) throws ServiceException {
        //保存房间
        String roomCode = createRoom(roomName, playerName);

        creatNewRatTable(playerName,career,mv,roomCode);

    }

    private void creatNewRatTable(String playerName, String career, ModelAndView mv,String roomCode) throws ServiceException {
        //检测同一房间玩家名重复
        Long count = playerService.checkPlayerNameExist(playerName, roomCode);
        if (count != null && count>0) {
            throw new ServiceException(RespConstant.PLAYER_NAME_EXISTS_CODE, RespConstant.PLAYER_NAME_EXISTS_MSG);
        }

        String careerName = CareerEunm.map.get(career);

        //生成玩家信息
        Long playerId = playerService.createPlayerInfo(career,roomCode,playerName,careerName);

        logger.info("createAndFeedBack 生成的玩家id ： " + playerId);

        //获取初始老鼠表并生成玩家老鼠表
        RatTableForm ratTableForm = ratTableService.getInitRatCareer(career, playerId, roomCode);
        ratTableForm.setRoomCode(roomCode);
        ratTableForm.setPlayerId(playerId);
        ratTableForm.setCareerName(careerName);
        ratTableForm.setPlayerName(playerName);

        //生成玩家老鼠表
        Long ratId = ratTableService.insertRat(ratTableForm);

        logger.info("createAndFeedBack 生成的老鼠id：" + ratId);

        mv.addObject(PLAYER_ID,playerId);
        mv.addObject(ROOM_CODE,roomCode);
        mv.addObject(RAT_ID,ratId);
    }

    @Override
    public List<PlayerDto> findPlayers(String roomCode) {

        return playerDao.findListByRoomCode(roomCode);
    }

    @Override
    public List<RoomDto> findRooms() {
        return roomDao.findRecentRooms();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void joinRoom(String playerName, String roomCode, String career, ModelAndView mv) throws ServiceException {

        Long isExist = roomDao.checkRoomCodeExist(roomCode);

        if (isExist == null || isExist == 0) {
            throw new ServiceException(RespConstant.ROOM_NUM_NOT_EXISTS_CODE, RespConstant.ROOM_NUM_NOT_EXISTS_MSG);
        }

        creatNewRatTable(playerName,career,mv,roomCode);
    }
}
