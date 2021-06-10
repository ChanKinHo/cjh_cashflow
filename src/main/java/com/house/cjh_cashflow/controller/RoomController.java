package com.house.cjh_cashflow.controller;

import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.PlayerForm;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.RoomDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.PlayerService;
import com.house.cjh_cashflow.service.RatTableService;
import com.house.cjh_cashflow.service.RoomService;
import org.apache.commons.lang.StringUtils;
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
            return "createRoomError";
        }

        if (StringUtils.isBlank(career)) {
            return "ratTable";
        }

        try {
            roomService.createAndFeedBack(roomName, playerName, career, map);
        } catch (ServiceException se) {
            map.addAttribute("msg", se.getMsg());
            return "error";
        } catch (Exception e) {
            map.addAttribute("msg", RespConstant.SYSTEM_FAIL_CODE_MSG);
            logger.error("RoomController createRoom err ",e);
            return "error";
        }

        return "ratTable";

    }

    @RequestMapping("/room/check")
    @ResponseBody
    public List<RoomDto> checkRoom() {

        return roomService.queryRooms();
    }

    @RequestMapping("/room/test")
    public String checkRat() {

        return "ratTable";
    }
}
