package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.controller.form.RatTableForm;
import com.house.cjh_cashflow.dto.RatTableDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RatTableDao {

    RatTableDto getInitRatCareer(@Param(value = "career") String career);

    void insertRat(RatTableForm ratTableForm);

    Long selectId(RatTableForm ratTableForm);
}
