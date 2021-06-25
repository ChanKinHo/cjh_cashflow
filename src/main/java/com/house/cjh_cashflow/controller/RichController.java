package com.house.cjh_cashflow.controller;

import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.RichTableDto;
import com.house.cjh_cashflow.service.RichService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class RichController {

    private Logger logger = LoggerFactory.getLogger(RichController.class);

    @Resource
    RichService richService;

    @RequestMapping(value = "/rich/createRich")
    public ModelAndView createRich(@RequestParam(value = "roomCode", required = false) String roomCode,
                                   @RequestParam(value = "playerId", required = false) String playerId,
                                   @RequestParam(value = "monthCashFlow", required = false) String monthCashFlow) {

        ModelAndView mv = new ModelAndView();
        if (StringUtils.isBlank(roomCode) || StringUtils.isBlank(playerId) || StringUtils.isBlank(monthCashFlow)) {
            mv.addObject("code", RespConstant.MUST_PARAM_NONE_CODE);
            mv.addObject("msg",RespConstant.MUST_PARAM_NONE_MSG);
            mv.setViewName("findRatError");
        }


        try {
            richService.createRich(roomCode,playerId,monthCashFlow);

        } catch (Exception e) {
            logger.error("RichController createRich err ",e);
            mv.addObject("code", RespConstant.SYSTEM_FAIL_CODE);
            mv.addObject("msg",RespConstant.SYSTEM_FAIL_CODE_MSG);
            mv.setViewName("findRatError");
        }

        mv.addObject("roomCode", roomCode);
        mv.addObject("playerId", playerId);
        mv.setViewName("redirect:/rich/findExactRich");

        return mv;
    }

    @RequestMapping(value = "/rich/findExactRich")
    public String findOneRich(@RequestParam(value = "roomCode", required = false) String roomCode,
                              @RequestParam(value = "playerId", required = false) String playerId,
                              @RequestParam(value = "playerName", required = false) String playerName,
                              ModelMap map) {

        RichTableDto richTableDto;
        try {
            richTableDto = richService.findOneRich(roomCode, playerId, playerName);

        } catch (Exception e) {
            logger.error("RichController findOneRich err ",e);
            map.put("code", RespConstant.SYSTEM_FAIL_CODE);
            map.put("msg",RespConstant.SYSTEM_FAIL_CODE_MSG);
            return "findRatError";
        }

        map.put("richObj",richTableDto);
        return "richTable";
    }


    @RequestMapping(value = "/rich/backRat")
    public ModelAndView backRatMan(@RequestParam(value = "roomCode", required = false) String roomCode,
                                   @RequestParam(value = "playerId", required = false) String playerId){

        ModelAndView mv = new ModelAndView();

        System.out.println("roomCode=" + roomCode + ", playerId="+playerId);


        if (StringUtils.isBlank(roomCode) || StringUtils.isBlank(playerId)) {
            mv.addObject("code", RespConstant.MUST_PARAM_NONE_CODE);
            mv.addObject("msg",RespConstant.MUST_PARAM_NONE_MSG);
            mv.setViewName("findRatError");
            return mv;
        }
        try {
            richService.backToRat(roomCode,playerId);

        } catch (Exception e) {
            logger.error("RichController backRatMan err ",e);
            mv.addObject("code", RespConstant.SYSTEM_FAIL_CODE);
            mv.addObject("msg",RespConstant.SYSTEM_FAIL_CODE_MSG);
            mv.setViewName("findRatError");
        }

        mv.addObject("roomCode", roomCode);
        mv.addObject("playerId", playerId);
        mv.setViewName("redirect:/rat/findExactRat");

        return mv;
    }
}
