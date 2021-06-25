package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.dto.EstateCompanyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EstateCompanyDao {

    List<EstateCompanyDto> findByRatId(@Param(value = "ratId") Long ratId);

    void addOneItemByRatId(PropertyForm property);

    void sellEstateById(@Param(value = "id") String estateId, @Param(value = "ratId")String ratId, @Param(value = "roomCode")String roomCode);

    List<EstateCompanyDto> findListByRichId(@Param(value = "roomCode") String roomCode, @Param(value = "richId") Long richId);

    void sellRichEstate(@Param(value = "richId")long richId, @Param(value = "roomCode")String roomCode);

    void addOneRichItem(PropertyForm form);
}
