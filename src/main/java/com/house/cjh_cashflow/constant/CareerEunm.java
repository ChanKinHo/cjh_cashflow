package com.house.cjh_cashflow.constant;

import java.util.HashMap;
import java.util.Map;

public enum CareerEunm {
    PILOT("1", "飞行驾驶员"),
    LAWYER("2","律师"),
    ENGINEER("3","工程师"),
    MANAGER("4","经理"),
    TEACHER("5","小学教师"),
    NURSE("6","护士"),
    POLICE_OFFICER("7","警官"),
    SECRETARY("8","秘书"),
    TRUCK_DRIVER("9","卡车司机"),
    MECHANICIAN("10","机械师"),
    GUARD("11","门卫");

    private final String num;

    private final String career;

    public static Map<String, String> map = new HashMap<>();

    CareerEunm(String num, String career) {
        this.num = num;
        this.career = career;
    }

    static {
        for (CareerEunm value : CareerEunm.values()) {
            map.put(value.getNum(),value.getCareer());
        }
    }



    public String getNum() {
        return num;
    }

    public String getCareer() {
        return career;
    }

    public Map<String, String> getMap() {
        return map;
    }
}
