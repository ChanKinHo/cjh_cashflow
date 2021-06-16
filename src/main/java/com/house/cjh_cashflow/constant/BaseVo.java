package com.house.cjh_cashflow.constant;

public class BaseVo<T> {

    private String respCode;

    private String respMsg;

    private T data;

    public static BaseVo succ(){
        return succ(null);
    }

    public static BaseVo succ(Object data){

        BaseVo<Object> baseVo = new BaseVo<Object>();
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
