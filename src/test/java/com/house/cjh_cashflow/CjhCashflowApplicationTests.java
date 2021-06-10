package com.house.cjh_cashflow;

import com.house.cjh_cashflow.constant.CareerEunm;
import com.house.cjh_cashflow.exception.ServiceException;
import com.house.cjh_cashflow.service.impl.RoomSerivceImpl;
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

    @Test
    void randomTest(){

        for (int i = 0; i < 10; i++) {
            int random = (int) ((Math.random()*900000-1)+100000);

            System.out.println(random);
        }
    }

    @Test
    void testException(){
        RoomSerivceImpl roomSerivce = new RoomSerivceImpl();
        try {
            roomSerivce.createRoom("","");
        } catch (ServiceException e) {
            System.out.println(e.getCode() + "," +e.getMsg());
        } catch (Exception e) {
            System.out.println("系统错误："+ e.getMessage());
        }


    }

}
