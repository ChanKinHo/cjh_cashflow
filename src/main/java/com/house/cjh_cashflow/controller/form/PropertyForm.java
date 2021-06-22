package com.house.cjh_cashflow.controller.form;

public class PropertyForm {

    private Long ratId;

    private Long stockId;

    private Long estateCompanyId;

    private String roomCode;

    private Long playerId;

    private String stockName;

    private String stockNum;

    private String stockValue;

    private String interest;

    private String estateName;

    private String downPayment;

    private String estateTotalValue;

    private String estateMonthCashFlow;

    private String estateLoan;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getEstateCompanyId() {
        return estateCompanyId;
    }

    public void setEstateCompanyId(Long estateCompanyId) {
        this.estateCompanyId = estateCompanyId;
    }

    public Long getRatId() {
        return ratId;
    }

    public void setRatId(Long ratId) {
        this.ratId = ratId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public String getStockValue() {
        return stockValue;
    }

    public void setStockValue(String stockValue) {
        this.stockValue = stockValue;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(String downPayment) {
        this.downPayment = downPayment;
    }

    public String getEstateLoan() {
        return estateLoan;
    }

    public void setEstateLoan(String estateLoan) {
        this.estateLoan = estateLoan;
    }

    public String getEstateTotalValue() {
        return estateTotalValue;
    }

    public void setEstateTotalValue(String estateTotalValue) {
        this.estateTotalValue = estateTotalValue;
    }

    public String getEstateMonthCashFlow() {
        return estateMonthCashFlow;
    }

    public void setEstateMonthCashFlow(String estateMonthCashFlow) {
        this.estateMonthCashFlow = estateMonthCashFlow;
    }
}
