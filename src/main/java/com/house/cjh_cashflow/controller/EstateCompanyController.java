package com.house.cjh_cashflow.controller;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.EstateCompanyService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class EstateCompanyController {

    private Logger logger = LoggerFactory.getLogger(EstateCompanyController.class);

    @Resource
    private EstateCompanyService estateCompanyService;

    @RequestMapping(value = "/estate/addEstate")
    public ModelAndView addEstateInfo(PropertyForm form) {

        logger.info("EstateCompanyController addEstateInfo param: " + JSON.toJSONString(form));

        ModelAndView mv = new ModelAndView();

        if (StringUtils.isBlank(form.getPassiveIncome()) || StringUtils.isBlank(form.getTotalPay())
            || StringUtils.isBlank(form.getRoomCode()) || form.getPlayerId() == null) {
            mv.addObject("code", RespConstant.MUST_PARAM_NONE_CODE);
            mv.addObject("msg",RespConstant.MUST_PARAM_NONE_MSG);
            mv.setViewName("findRatError");
            return mv;
        }

        Long passiveIncome = Long.parseLong(form.getPassiveIncome());
        Long totalPay = Long.parseLong(form.getTotalPay());

        if (passiveIncome > totalPay) {
            mv.addObject("roomCode",form.getRoomCode());
            mv.addObject("playerId",form.getPlayerId());
            mv.addObject("passiveIncome",passiveIncome);
            mv.setViewName("redirect:/rich/createRich");
            return mv;
        }

        try {
            estateCompanyService.saveEstateInfo(form);
        } catch (ServiceException se) {
            mv.addObject("code", se.getCode());
            mv.addObject("msg",se.getMsg());
            mv.setViewName("findRatError");
            return mv;
        } catch (Exception e) {
            logger.error("EstateCompanyController addEstateInfo err ",e);
            mv.addObject("code", RespConstant.SYSTEM_FAIL_CODE);
            mv.addObject("msg",RespConstant.SYSTEM_FAIL_CODE_MSG);
            mv.setViewName("findRatError");
            return mv;
        }

        mv.addObject("roomCode",form.getRoomCode());
        mv.addObject("ratId",form.getRatId());
        mv.setViewName("redirect:/rat/findExactRat");

        return mv;
    }

    @RequestMapping(value = "/estate/sellEstate")
    public ModelAndView sellStock(@RequestParam(value = "estateId") String estateId,
                                  @RequestParam(value = "ratId") String ratId,
                                  @RequestParam(value = "roomCode") String roomCode,
                                  @RequestParam(value = "passiveIncome") String passiveIncome,
                                  @RequestParam(value = "totalIncome") String totalIncome,
                                  @RequestParam(value = "totalCashFlow") String totalCashFlow){

        logger.info("sellEstate params: estateId="+ estateId + ", ratId=" + ratId + ", roomCode=" + roomCode
                + ", passiveIncome=" + passiveIncome + ", totalIncome=" + totalIncome + ", totalCashFlow="+totalCashFlow);
        ModelAndView mv = new ModelAndView();
        if (StringUtils.isBlank(estateId) || (StringUtils.isBlank(ratId) && StringUtils.isBlank(roomCode))) {
            mv.setViewName("redirect:findRat.html");
            return mv;
        }

        estateCompanyService.sellEstateById(estateId, ratId, roomCode,passiveIncome,totalIncome,totalCashFlow);

        mv.addObject("roomCode",roomCode);
        mv.addObject("ratId",ratId);
        mv.setViewName("redirect:/rat/findExactRat");

        return mv;
    }

    @RequestMapping(value = "/estate/addRichEstate")
    public ModelAndView investRichEstate(PropertyForm form) {

        logger.info("添加富人资产入参/" + JSON.toJSONString(form));

        ModelAndView mv = new ModelAndView();

        try {
            estateCompanyService.addRichEstate(form);
        } catch (Exception e) {
            logger.error("EstateCompanyController investRichEstate err ",e);
            mv.addObject("code", RespConstant.SYSTEM_FAIL_CODE);
            mv.addObject("msg",RespConstant.SYSTEM_FAIL_CODE_MSG);
            mv.setViewName("findRatError");
            return mv;

        }

        mv.addObject("roomCode",form.getRoomCode());
        mv.addObject("playerId",form.getPlayerId());
        mv.setViewName("redirect:/rich/findExactRich");
        return mv;
    }
}
