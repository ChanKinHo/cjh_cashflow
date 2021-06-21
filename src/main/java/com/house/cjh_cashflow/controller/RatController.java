package com.house.cjh_cashflow.controller;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.constant.BaseVo;
import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.RatTableService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class RatController {

    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final String RAT_OBJ = "ratObj";
    private Logger logger = LoggerFactory.getLogger(RatController.class);

    @Resource
    RatTableService ratTableService;

    @RequestMapping(value = "/rat/findExactRat")
    public String findExactRat(@RequestParam(value = "playerId", required = false) String playerId,
                               @RequestParam(value = "roomCode", required = false) String roomCode,
                               @RequestParam(value = "ratId",required = false) String ratId,
                               @RequestParam(value = "playerName", required = false) String playerName,
                               ModelMap map) {
        logger.info("RatController findExactRat param : playerId=" + playerId + ", roomCode=" +roomCode + ", ratId=" + ratId + ", playerName=" + playerName);

        if (StringUtils.isBlank(roomCode) || (StringUtils.isBlank(playerId) && StringUtils.isBlank(playerName) && StringUtils.isBlank(ratId))) {
            map.put(CODE,RespConstant.FIND_RAT_PARAM_CODE);
            map.put(MSG,RespConstant.FIND_RAT_PARAM_MSG);
            return "findRatError";
        }

        RatTableDto ratTableDto;
        try {
            ratTableDto = ratTableService.findExactRatInfo(playerId,roomCode,ratId,playerName);
        } catch (Exception e) {
            logger.error("RatController findExactRat err", e);
            map.put(CODE,RespConstant.SYSTEM_FAIL_CODE);
            map.put(MSG,RespConstant.SYSTEM_FAIL_CODE_MSG);
            return "findRatError";
        }

        if (ratTableDto == null) {
            map.put(CODE,RespConstant.NO_RAT_PLAYER_CODE);
            map.put(MSG,RespConstant.NO_RAT_PLAYER_MSG);
            return "findRatError";
        }

        map.put(RAT_OBJ,ratTableDto);
        return "ratTable";
    }

    @RequestMapping(value = "/rat/addStock")
    @ResponseBody
    public BaseVo addStockPropety(@RequestBody RatTableForm form) {
        logger.info("RatController addStockPropety form " + JSON.toJSONString(form));

        StockDto stockDto;
        try {
            stockDto = ratTableService.addStock(form);
        } catch (ServiceException se) {
            return BaseVo.fail(se.getCode(),se.getMsg());

        } catch (Exception e) {
            logger.error("RatController addStockPropety err ", e);
            return BaseVo.fail(RespConstant.SYSTEM_FAIL_CODE, RespConstant.SYSTEM_FAIL_CODE_MSG);
        }

        return BaseVo.succ(stockDto);
    }

    @RequestMapping(value = "/rat/sellStock")
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

        ratTableService.sellStockById(stockId, ratId, roomCode,passiveIncome,totalIncome,totalCashFlow);

        mv.addObject("roomCode",roomCode);
        mv.addObject("ratId",ratId);
        mv.setViewName("redirect:/rat/findExactRat");

        return mv;
    }
}
