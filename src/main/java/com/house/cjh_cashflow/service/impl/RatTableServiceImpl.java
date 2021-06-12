package com.house.cjh_cashflow.service.impl;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dao.RatTableDao;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.service.RatTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
