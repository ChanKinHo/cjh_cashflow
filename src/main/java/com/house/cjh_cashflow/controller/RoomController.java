package com.house.cjh_cashflow.controller;

import com.house.cjh_cashflow.dto.RoomDto;
import com.house.cjh_cashflow.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoomController {

    Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/room/create", method = RequestMethod.POST)
    public String create(@RequestParam(value = "playerName") String playerName,
                         @RequestParam(value = "roomName") String roomName,
                         @RequestParam(value = "career") String career,
                         ModelMap map) {

        logger.info("创建房间入参: playerName = " + playerName + ", roomName = " + roomName +", career = " + career);

        if (playerName.length() > 10 || roomName.length() > 10 ) {
            map.addAttribute("msg", "输入玩家名称或房间名不能超过10个字");
            return "error";
        }

        return "success";

    }

    @RequestMapping("/room/check")
    @ResponseBody
    public List<RoomDto> checkRoom() {

        return roomService.queryRooms();
    }
}
