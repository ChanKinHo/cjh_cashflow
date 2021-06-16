package com.house.cjh_cashflow.controller;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.constant.BaseVo;
import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.RatTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RatController {

    Logger logger = LoggerFactory.getLogger(RatController.class);

    @Resource
    RatTableService ratTableService;

    @RequestMapping(value = "/rat/addStock")
    @ResponseBody
    public BaseVo addStockPropety(@RequestBody RatTableForm form) {
        logger.info("RatController addStockPropety form " + JSON.toJSONString(form));

//        StockDto stockDto;
//        try {
//            stockDto = ratTableService.addStock(form);
//        } catch (ServiceException se) {
//            return BaseVo.fail(se.getCode(),se.getMsg());
//
//        } catch (Exception e) {
//            logger.error("RatController addStockPropety err ", e);
//            return BaseVo.fail(RespConstant.SYSTEM_FAIL_CODE, RespConstant.SYSTEM_FAIL_CODE_MSG);
//        }

        return BaseVo.succ(JSON.toJSONString(form));
    }

    @RequestMapping(value = "/test/addStock")
    @ResponseBody
    public BaseVo testAddStock(PropertyForm form){

        System.out.println("查询到的body: " + JSON.toJSONString(form));

        StockDto stockDto = new StockDto();
        stockDto.setName("MYT4U");
        stockDto.setPerCost(30);
        stockDto.setInterest(0);
        stockDto.setTotalCount(600);

        return BaseVo.succ(stockDto);
    }
}
