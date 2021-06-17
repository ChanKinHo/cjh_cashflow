package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.dto.EstateCompanyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EstateCompanyDao {

    List<EstateCompanyDto> findByRatId(@Param(value = "ratId") Long ratId);
}
