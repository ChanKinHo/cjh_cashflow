package com.house.cjh_cashflow.controller;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.constant.BaseVo;
import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.RatTableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RatController {

    @Resource
    RatTableService ratTableService;

    @RequestMapping(value = "/rat/addPropery")
    public String addProperties(@RequestBody PropertyForm form) {

        try {
            RatTableDto ratTableDto = ratTableService.addProperties(form);
        } catch (ServiceException e) {

        }

        return "";
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
