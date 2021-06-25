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
    public void saveEstateInfo(PropertyForm form) throws ServiceException {

        if (StringUtils.isBlank(form.getRoomCode()) || form.getPlayerId() == null
                || form.getRatId() == null) {
            throw new ServiceException(RespConstant.MUST_PARAM_NONE_CODE, RespConstant.MUST_PARAM_NONE_MSG);
        }
        //更新被动收入等
        RatTableForm ratTableForm = new RatTableForm();
        ratTableForm.setId(form.getRatId());
        ratTableForm.setRoomCode(form.getRoomCode());
        ratTableForm.setPlayerId(form.getPlayerId());
        ratTableForm.setMonthCashFlow(form.getMonthCashFlow());
        ratTableForm.setTotalIncome(form.getTotalIncome());
        ratTableForm.setPassiveIncome(form.getPassiveIncome());
        ratTableDao.updateRatSummary(ratTableForm);


        estateCompanyDao.addOneItemByRatId(form);
    }

    @Override
    public void sellEstateById(String estateId, String ratId, String roomCode, String passiveIncome, String totalIncome, String totalCashFlow) {
        RatTableForm ratTableForm = new RatTableForm();
        ratTableForm.setPassiveIncome(passiveIncome);
        ratTableForm.setTotalIncome(totalIncome);
        ratTableForm.setMonthCashFlow(totalCashFlow);
        ratTableForm.setId(Long.parseLong(ratId));
        ratTableForm.setRoomCode(roomCode);
        ratTableDao.updateRatSummary(ratTableForm);

        estateCompanyDao.sellEstateById(estateId,ratId,roomCode);
    }
}
