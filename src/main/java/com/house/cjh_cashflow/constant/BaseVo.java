package com.house.cjh_cashflow.constant;

public class BaseVo<T> {

    private String respCode;

    private String respMsg;

    private T data;

    public static<T> BaseVo<T> succ(){
        return succ(null);
    }

    public static<T> BaseVo<T> succ(T data){

        BaseVo<T> baseVo = new BaseVo<>();
        baseVo.setRespCode(RespConstant.SYSTEM_SUCCESS_CODE);
        baseVo.setRespMsg(RespConstant.SYSTEM_SUCCESS_MSG);
        baseVo.setData(data);
        return baseVo;
    }

    public static BaseVo fail(String code, String msg) {
        BaseVo baseVo = new BaseVo();
        baseVo.setRespCode(code);
        baseVo.setRespMsg(msg);
        return baseVo;
    }

    public static BaseVo fail() {
        BaseVo baseVo = new BaseVo();
        baseVo.setRespCode(RespConstant.SYSTEM_FAIL_CODE);
        baseVo.setRespMsg(RespConstant.SYSTEM_FAIL_CODE_MSG);
        return baseVo;
    }

    public static<T> BaseVo<T> fail(T data){

        BaseVo<T> baseVo = new BaseVo<>();
        baseVo.setRespCode(RespConstant.SYSTEM_FAIL_CODE);
        baseVo.setRespMsg(RespConstant.SYSTEM_FAIL_CODE_MSG);
        baseVo.setData(data);
        return baseVo;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
