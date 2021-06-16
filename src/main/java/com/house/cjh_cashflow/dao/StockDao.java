package com.house.cjh_cashflow.dao;

import com.house.cjh_cashflow.controller.form.PropertyForm;
import com.house.cjh_cashflow.controller.form.RatTableForm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockDao {

    void addOneItemByRatId(PropertyForm property);
}
