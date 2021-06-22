package com.house.cjh_cashflow.service.impl;

import com.house.cjh_cashflow.constant.RespConstant;
import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dao.EstateCompanyDao;
import com.house.cjh_cashflow.dao.RatTableDao;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.EstateCompanyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class EstateCompanyServiceImpl implements EstateCompanyService {

    @Resource
    RatTableDao ratTableDao;
    @Resource
    EstateCompanyDao estateCompanyDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EstateCompanyDto saveEstateInfo(RatTableForm form) throws ServiceException {

        if (StringUtils.isBlank(form.getRoomCode()) || form.getPlayerId() == null
                || form.getId() == null) {
            throw new ServiceException(RespConstant.MUST_PARAM_NONE_CODE, RespConstant.MUST_PARAM_NONE_MSG);
        }
        //更新被动收入等
        ratTableDao.updateRatSummary(form);

        PropertyForm property = form.getProperty();
        property.setRoomCode(form.getRoomCode());
        property.setRatId(form.getId());
        estateCompanyDao.addOneItemByRatId(property);

        EstateCompanyDto estateCompanyDto = new EstateCompanyDto();
        estateCompanyDto.setId(property.getEstateCompanyId());
        estateCompanyDto.setRoomCode(form.getRoomCode());
        estateCompanyDto.setRatTableId(form.getId());
        estateCompanyDto.setDownPayment(Long.parseLong(property.getDownPayment()));
        estateCompanyDto.setLoan(Long.parseLong(property.getEstateLoan()));
        estateCompanyDto.setMonthCashFlow(Long.parseLong(property.getEstateMonthCashFlow()));
        estateCompanyDto.setName(property.getEstateName());
        estateCompanyDto.setTotalCost(Long.parseLong(property.getEstateTotalValue()));

        return estateCompanyDto;
    }
}
