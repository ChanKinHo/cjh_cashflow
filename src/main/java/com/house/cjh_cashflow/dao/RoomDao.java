package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.dto.RoomDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomDao {

    List<RoomDto> queryRooms();
}
