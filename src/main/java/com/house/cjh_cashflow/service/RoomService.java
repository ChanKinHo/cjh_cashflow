package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.dto.PlayerDto;
import com.house.cjh_cashflow.dto.RoomDto;
import com.house.cjh_cashflow.exception.ServiceException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface RoomService {

    List<RoomDto> queryRooms();

    String createRoom(String roomName, String playerName) throws ServiceException;

    void createAndFeedBack(String roomName, String playerName, String career, ModelAndView mv) throws ServiceException;

    List<PlayerDto> findPlayers(String roomCode);

    List<RoomDto> findRooms();

    void joinRoom(String playerName, String roomCode, String career, ModelAndView mv) throws ServiceException;
}
