package com.house.cjh_cashflow;

import com.house.cjh_cashflow.constant.CareerEunm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class CjhCashflowApplicationTests {

    @Test
    void contextLoads() {

        Map<String, String> map = CareerEunm.map;

        String s = map.get("1");

        System.out.println(s);
    }

}
