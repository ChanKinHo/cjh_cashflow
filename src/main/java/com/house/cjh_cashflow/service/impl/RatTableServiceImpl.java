package com.house.cjh_cashflow.service.impl;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.dao.RatTableDao;
import com.house.cjh_cashflow.dto.RatTableDto;
import com.house.cjh_cashflow.service.RatTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatTableServiceImpl implements RatTableService {

    @Autowired
    RatTableDao ratTableDao;

    @Override
    public RatTableDto getInitRatCareer(String career) {
        return ratTableDao.getInitRatCareer(career);
    }
}
