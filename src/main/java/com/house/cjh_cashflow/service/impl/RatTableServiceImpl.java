package com.house.cjh_cashflow.service.impl;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dao.RatTableDao;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.RatTableService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class RatTableServiceImpl implements RatTableService {

    @Autowired
    RatTableDao ratTableDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RatTableDto getInitRatCareer(String career, long playerId, String roomCode) {
        return ratTableDao.getInitRatCareer(career);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long insertRat(RatTableForm ratTableForm) {
        ratTableDao.insertRat(ratTableForm);

        return ratTableDao.selectId(ratTableForm);
    }

    @Override
    public RatTableDto addProperties(PropertyForm form) throws ServiceException {

        String ratId = form.getRatId();
        String roomCode = form.getRoomCode();
        String playerId = form.getPlayerId();

        String stockName = form.getStockName();
        String stockNum = form.getStockNum();
        String stockValue = form.getStockValue();
        String interest = form.getInterest();

        String estateName = form.getEstateName();
        String estateLoan = form.getEstateLoan();
        String downPayment = form.getDownPayment();
        String monthCashFlow = form.getMonthCashFlow();
        String totalValue = form.getTotalValue();

        if (StringUtils.isBlank(ratId) || StringUtils.isBlank(roomCode)) {
            throw new ServiceException(RespConstant.MUST_PARAM_NONE_CODE, RespConstant.MUST_PARAM_NONE_MSG);
        }

        RatTableDto ratTableDto;
        if (StringUtils.isBlank(estateName) || StringUtils.isBlank(estateLoan)
            || StringUtils.isBlank(downPayment) || StringUtils.isBlank(monthCashFlow)
            || StringUtils.isBlank(totalValue)) {

            if (StringUtils.isBlank(stockName) || StringUtils.isBlank(stockNum)
                || StringUtils.isBlank(stockValue)) {

                throw new ServiceException(RespConstant.NO_PROPERTY_PARAM_CODE,RespConstant.NO_PROPERTY_PARAM_MSG);
            }

            //基金股票插入新条目
            ratTableDao.insertStockItem(form);

            ratTableDto = ratTableDao.selectRatById(ratId,roomCode,playerId);
            List<EstateCompanyDto> companyDtoList = ratTableDao.selectEstateCompanyList(ratId,roomCode);
            ratTableDto.setEstateCompanyDtos(companyDtoList);



        }

        return null;

    }
}
