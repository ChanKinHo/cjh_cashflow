package com.house.cjh_cashflow.service.impl;

import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dao.RatTableDao;
import com.house.cjh_cashflow.dao.StockDao;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.RatTableService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.regex.Pattern;

@Service
public class RatTableServiceImpl implements RatTableService {

    private static final String MATCH_REG = "^-?\\d+$";

    @Resource
    RatTableDao ratTableDao;

    @Resource
    StockDao stockDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RatTableDto getInitRatCareer(String career, long playerId, String roomCode) {
        return ratTableDao.getInitRatCareer(career);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long insertRat(RatTableForm ratTableForm) {
        ratTableDao.insertRat(ratTableForm);

        return ratTableForm.getId();
    }

    @Override
    public StockDto addStock(RatTableForm form) throws ServiceException {

//        if (StringUtils.isBlank(form.getRoomCode()) || StringUtils.isBlank(form.getPlayerId())
//                || StringUtils.isBlank(form.getId())) {
//            throw new ServiceException(RespConstant.MUST_PARAM_NONE_CODE, RespConstant.MUST_PARAM_NONE_MSG);
//        }
//
//        PropertyForm property = form.getProperty();
//        String stockValue = property.getStockValue();
//        String stockNum = property.getStockNum();
//        String interest = property.getInterest();
//        String stockName = property.getStockName();
//
//        if (StringUtils.isBlank(stockName) || StringUtils.isBlank(stockNum) || StringUtils.isBlank(stockValue) || StringUtils.isBlank(interest)) {
//            throw new ServiceException(RespConstant.NO_PROPERTY_PARAM_CODE, RespConstant.NO_PROPERTY_PARAM_MSG);
//        }
//
//        if (!Pattern.matches(MATCH_REG,stockNum) || !Pattern.matches(MATCH_REG,stockValue)
//            || !Pattern.matches(MATCH_REG,interest)) {
//            throw new ServiceException(RespConstant.MUST_WHOLE_NUM_CODE,RespConstant.MUST_WHOLE_NUM_MSG);
//        }

        //修改玩家老鼠表
//        ratTableDao.updateRatSummary(form);
//
//        //新增股票基金表
//        property.setRatId(form.getId());
//        stockDao.addOneItemByRatId(property);
//
//        StockDto stockDto = new StockDto();
//        stockDto.setRatTableId(Long.parseLong(form.getId()));
//        stockDto.setName(stockName);
//        stockDto.setTotalCount(Integer.parseInt(stockNum));
//        stockDto.setPerCost(Long.parseLong(stockValue));
//        stockDto.setInterest(Long.parseLong(interest));

        return null;
    }


}
