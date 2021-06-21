package com.house.cjh_cashflow.constant;

public class RespConstant {

    public static final String SYSTEM_SUCCESS_CODE = "000000";
    public static final String SYSTEM_SUCCESS_MSG = "成功";


    public static final String ROOM_NUM_EXISTS_CODE = "200201";
    public static final String ROOM_NUM_EXISTS_MSG = "房间号重复，请重新创建房间";

    public static final String SYSTEM_FAIL_CODE = "100101";
    public static final String SYSTEM_FAIL_CODE_MSG = "系统错误";

    public static final String PLAYER_NAME_EXISTS_CODE = "200202";
    public static final String PLAYER_NAME_EXISTS_MSG = "同一房间玩家名称不得重复";

    public static final String MUST_PARAM_NONE_CODE = "300512";
    public static final String MUST_PARAM_NONE_MSG = "房间号或玩家id或老鼠表id为空";

    public static final String NO_PROPERTY_PARAM_CODE = "300513";
    public static final String NO_PROPERTY_PARAM_MSG = "资产必要参数没有传入";

    public static final String MUST_WHOLE_NUM_CODE = "500001";
    public static final String MUST_WHOLE_NUM_MSG = "资产相关参数必须为整数";

    public static final String PARAM_TOO_LONG_CODE = "500002";
    public static final String PARAM_TOO_LONG_MSG = "输入玩家名称或房间名不能超过10个字";

    public static final String FIND_RAT_PARAM_CODE = "500003";
    public static final String FIND_RAT_PARAM_MSG = "房间号或玩家名称且玩家id为空";

    public static final String NO_RAT_PLAYER_CODE = "500113";
    public static final String NO_RAT_PLAYER_MSG = "还未加入过房间";
}
