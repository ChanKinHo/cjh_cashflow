package com.house.cjh_cashflow.service.impl;

import com.house.cjh_cashflow.dao.RoomDao;
import com.house.cjh_cashflow.dto.RoomDto;
import com.house.cjh_cashflow.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomSerivceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;

    @Override
    public List<RoomDto> queryRooms() {
        return roomDao.queryRooms();
    }
}
