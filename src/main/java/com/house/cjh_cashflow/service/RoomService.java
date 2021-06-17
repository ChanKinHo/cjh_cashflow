package com.house.cjh_cashflow.service;

import com.house.cjh_cashflow.dto.RoomDto;
import com.house.cjh_cashflow.exception.ServiceException;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface RoomService {

    List<RoomDto> queryRooms();

    String createRoom(String roomName, String playerName) throws ServiceException;

    void createAndFeedBack(String roomName, String playerName, String career, ModelAndView mv) throws ServiceException;
}
