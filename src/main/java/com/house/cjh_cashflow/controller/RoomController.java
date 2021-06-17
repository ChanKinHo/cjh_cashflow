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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoomController {

    Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    RoomService roomService;


    @RequestMapping(value = "/room/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam(value = "playerName") String playerName,
                               @RequestParam(value = "roomName") String roomName,
                               @RequestParam(value = "career") String career) {

        logger.info("创建房间入参: playerName = " + playerName + ", roomName = " + roomName +", career = " + career);

        ModelAndView mv = new ModelAndView();
        if (playerName.length() > 10 || roomName.length() > 10 ) {
            mv.addObject("code",RespConstant.PARAM_TOO_LONG_CODE);
            mv.addObject("msg",RespConstant.PARAM_TOO_LONG_MSG);
            mv.setViewName("createRoomError");
            return mv;
        }

        try {
            roomService.createAndFeedBack(roomName, playerName, career, mv);
        } catch (ServiceException se) {
            mv.addObject("code",se.getCode());
            mv.addObject("msg",se.getMsg());
            mv.setViewName("createRoomError");
            return mv;
        } catch (Exception e) {
            mv.addObject("code",RespConstant.SYSTEM_FAIL_CODE);
            mv.addObject("msg", RespConstant.SYSTEM_FAIL_CODE_MSG);
            mv.setViewName("createRoomError");
            logger.error("RoomController createRoom err ",e);
            return mv;
        }

        mv.setViewName("redirect:/rat/findExactRat");
        return mv;

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
