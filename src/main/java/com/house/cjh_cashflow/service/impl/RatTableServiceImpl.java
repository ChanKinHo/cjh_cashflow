package com.house.cjh_cashflow.service.impl;

import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dao.EstateCompanyDao;
import com.house.cjh_cashflow.dao.RatTableDao;
import com.house.cjh_cashflow.dao.StockDao;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.dto.StockDto;
import com.house.cjh_cashflow.service.RatTableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RatTableServiceImpl implements RatTableService {

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
    @Transactional(rollbackFor = Exception.class)
    public void borrowBank(RatTableForm form) {
        ratTableDao.updateBanKByRatId(form);
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
    public void makeChild(RatTableForm form) {
        ratTableDao.updateChildInfoByRatId(form);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void backFixLoans(RatTableForm form) {
        ratTableDao.updateFixLoans(form);
    }
}
