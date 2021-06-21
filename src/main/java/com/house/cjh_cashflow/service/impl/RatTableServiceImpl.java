package com.house.cjh_cashflow.service.impl;

import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dao.EstateCompanyDao;
import com.house.cjh_cashflow.dao.RatTableDao;
import com.house.cjh_cashflow.dao.StockDao;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.RatTableService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RatTableServiceImpl implements RatTableService {

    private static final String MATCH_REG = "^-?\\d+$";

    @Resource
    RatTableDao ratTableDao;

    @Resource
    StockDao stockDao;

    @Resource
    EstateCompanyDao estateCompanyDao;

    @Override
    public RatTableDto findExactRatInfo(String playerId, String roomCode, String ratId, String playerName) {

        RatTableDto ratTableDto = ratTableDao.selectRatBySome(ratId,roomCode,playerId, playerName);

        List<StockDto> stockDtos = stockDao.findByRatId(ratTableDto.getId());

        List<EstateCompanyDto> estateCompanyDtos = estateCompanyDao.findByRatId(ratTableDto.getId());

        ratTableDto.setStockDtos(stockDtos);
        ratTableDto.setEstateCompanyDtos(estateCompanyDtos);

        return ratTableDto;
    }

    @Override
    public void sellStockById(String stockId, String ratId, String roomCode,
                              String passiveIncome, String totalIncome, String totalCashFlow) {

        RatTableForm ratTableForm = new RatTableForm();
        ratTableForm.setPassiveIncome(passiveIncome);
        ratTableForm.setTotalIncome(totalIncome);
        ratTableForm.setMonthCashFlow(totalCashFlow);
        ratTableForm.setId(Long.parseLong(ratId));
        ratTableForm.setRoomCode(roomCode);
        ratTableDao.updateRatSummary(ratTableForm);

        stockDao.sellStockById(stockId,ratId,roomCode);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RatTableForm getInitRatCareer(String career, long playerId, String roomCode) {
        return ratTableDao.getInitRatCareer(career);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long insertRat(RatTableForm ratTableForm) {
        ratTableDao.insertRat(ratTableForm);

        return ratTableForm.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public StockDto addStock(RatTableForm form) throws ServiceException {

        if (StringUtils.isBlank(form.getRoomCode()) || form.getPlayerId() == null
            || form.getId() == null) {
            throw new ServiceException(RespConstant.MUST_PARAM_NONE_CODE, RespConstant.MUST_PARAM_NONE_MSG);
        }

        PropertyForm property = form.getProperty();
        String stockValue = property.getStockValue();
        String stockNum = property.getStockNum();
        String interest = property.getInterest();
        String stockName = property.getStockName();

        if (StringUtils.isBlank(stockName) || StringUtils.isBlank(stockNum) || StringUtils.isBlank(stockValue) || StringUtils.isBlank(interest)) {
            throw new ServiceException(RespConstant.NO_PROPERTY_PARAM_CODE, RespConstant.NO_PROPERTY_PARAM_MSG);
        }


        //修改玩家老鼠表
        ratTableDao.updateRatSummary(form);

        //新增股票基金表
        property.setRatId(form.getId());
        property.setRoomCode(form.getRoomCode());
        stockDao.addOneItemByRatId(property);


        StockDto stockDto = new StockDto();
        stockDto.setRatTableId(form.getId());
        stockDto.setRoomCode(form.getRoomCode());
        stockDto.setId(property.getStockId());
        stockDto.setName(stockName);
        stockDto.setTotalCount(Integer.parseInt(stockNum));
        stockDto.setPerCost(Long.parseLong(stockValue));
        stockDto.setInterest(Long.parseLong(interest));

        return stockDto;
    }


}
