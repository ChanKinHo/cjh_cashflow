package com.house.cjh_cashflow.controller;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.constant.BaseVo;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.EstateCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
