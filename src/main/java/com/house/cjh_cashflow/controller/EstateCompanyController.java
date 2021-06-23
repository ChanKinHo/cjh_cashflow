package com.house.cjh_cashflow.controller;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.constant.BaseVo;
import com.house.cjh_cashflow.controller.form.RatTableForm;
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
    @ResponseBody
    public BaseVo addEstateInfo(@RequestBody RatTableForm form) {

        logger.info("EstateCompanyController addEstateInfo param: " + JSON.toJSONString(form));

        EstateCompanyDto estateCompanyDto;
        try {
            estateCompanyDto = estateCompanyService.saveEstateInfo(form);
        } catch (ServiceException se) {
            return BaseVo.fail(se.getCode(),se.getMsg());
        } catch (Exception e) {
            logger.error("EstateCompanyController addEstateInfo err ",e);
            return BaseVo.fail();
        }

        return BaseVo.succ(estateCompanyDto);
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
}
