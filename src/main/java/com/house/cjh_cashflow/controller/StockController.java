package com.house.cjh_cashflow.controller;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.constant.BaseVo;
import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.StockService;
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
public class StockController {

    private Logger logger = LoggerFactory.getLogger(StockController.class);

    @Resource
    StockService stockService;

    @RequestMapping(value = "/stock/addStock")
    @ResponseBody
    public BaseVo addStockPropety(@RequestBody RatTableForm form) {
        logger.info("RatController addStockPropety form " + JSON.toJSONString(form));

        StockDto stockDto;
        try {
            stockDto = stockService.addStock(form);
        } catch (ServiceException se) {
            return BaseVo.fail(se.getCode(),se.getMsg());

        } catch (Exception e) {
            logger.error("RatController addStockPropety err ", e);
            return BaseVo.fail(RespConstant.SYSTEM_FAIL_CODE, RespConstant.SYSTEM_FAIL_CODE_MSG);
        }

        return BaseVo.succ(stockDto);
    }

    @RequestMapping(value = "/stock/sellStock")
    public ModelAndView sellStock(@RequestParam(value = "stockId") String stockId,
                                  @RequestParam(value = "ratId") String ratId,
                                  @RequestParam(value = "roomCode") String roomCode,
                                  @RequestParam(value = "passiveIncome") String passiveIncome,
                                  @RequestParam(value = "totalIncome") String totalIncome,
                                  @RequestParam(value = "totalCashFlow") String totalCashFlow){

        logger.info("sellStock params: stockId="+ stockId + ", ratId=" + ratId + ", roomCode=" + roomCode
                + ", passiveIncome=" + passiveIncome + ", totalIncome=" + totalIncome + ", totalCashFlow="+totalCashFlow);
        ModelAndView mv = new ModelAndView();
        if (StringUtils.isBlank(stockId) || (StringUtils.isBlank(ratId) && StringUtils.isBlank(roomCode))) {
            mv.setViewName("redirect:findRat.html");
            return mv;
        }

        stockService.sellStockById(stockId, ratId, roomCode,passiveIncome,totalIncome,totalCashFlow);

        mv.addObject("roomCode",roomCode);
        mv.addObject("ratId",ratId);
        mv.setViewName("redirect:/rat/findExactRat");

        return mv;
    }
}
