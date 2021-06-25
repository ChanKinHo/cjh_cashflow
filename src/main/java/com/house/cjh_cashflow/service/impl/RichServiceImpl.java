package com.house.cjh_cashflow.service.impl;

import com.alibaba.fastjson.JSON;
import com.house.cjh_cashflow.controller.form.RichTableForm;
import com.house.cjh_cashflow.dao.EstateCompanyDao;
import com.house.cjh_cashflow.dao.PlayerDao;
import com.house.cjh_cashflow.dao.RichDao;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import com.house.cjh_cashflow.dto.RichTableDto;
import com.house.cjh_cashflow.service.RichService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RichServiceImpl implements RichService {
    @Resource
    RichDao richDao;

    @Resource
    PlayerDao playerDao;

    @Resource
    EstateCompanyDao estateCompanyDao;


    @Override
    public void createRich(String roomCode, String playerId, String passiveIncome) {

        Long exist = richDao.checkExist(roomCode,playerId);

        if (exist != null && exist > 0) {
            return;
        }

        Long cashFlow = Long.parseLong(passiveIncome);
        Long richCashFlow = cashFlow *100;
        Long initCashFlow = cashFlow * 100;
        Long winCashFlow = initCashFlow + 50000;

        RichTableForm richTableForm = new RichTableForm();
        richTableForm.setPlayerId(Long.parseLong(playerId));
        richTableForm.setRoomCode(roomCode);
        richTableForm.setRichCashFlow(richCashFlow);
        richTableForm.setMonthCashFlow(cashFlow);
        richTableForm.setInitCashFlow(initCashFlow);
        richTableForm.setWinCashFlow(winCashFlow);

        String playerName = playerDao.findNameById(playerId);

        System.out.println("创建富人playerId=" +playerId);
        playerDao.becomeRich(Long.parseLong(playerId));
        richTableForm.setPlayerName(playerName);

        richDao.createPlayerRich(richTableForm);

    }

    @Override
    public RichTableDto findOneRich(String roomCode, String playerId, String playerName) {

        RichTableDto richTableDto = richDao.findExactOne(roomCode,playerId,playerName);

        Long richId;
        if (richTableDto != null) {
            richId = richTableDto.getId();

            List<EstateCompanyDto> estateCompanyDtos = estateCompanyDao.findListByRichId(roomCode,richId);
            
            richTableDto.setEstateCompanyDtos(estateCompanyDtos);
        }

        return richTableDto;
    }

    @Override
    public void backToRat(String roomCode, String playerId, String richId) {
        playerDao.becomeRat(Long.parseLong(playerId));

        estateCompanyDao.sellRichEstate(Long.parseLong(richId),roomCode);
        richDao.backRat(roomCode,playerId);
    }
}
