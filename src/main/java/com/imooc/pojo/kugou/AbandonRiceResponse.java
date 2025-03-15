package com.imooc.pojo.kugou;

public class AbandonRiceResponse {

    private Integer returnCode;
    private String errorMsg;
    private AbandonRiceDataResponse data;

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public AbandonRiceDataResponse getData() {
        return data;
    }

    public void setData(AbandonRiceDataResponse data) {
        this.data = data;
    }
}
