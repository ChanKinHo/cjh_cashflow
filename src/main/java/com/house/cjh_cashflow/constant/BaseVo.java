package com.house.cjh_cashflow.constant;

public class BaseVo<T> {

    private String respCode;

    private String respMsg;

    private T data;

    public static BaseVo succ(Object data){

        BaseVo<Object> baseVo = new BaseVo<Object>();
        baseVo.setRespCode("000000");
        baseVo.setRespMsg("成功");
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
