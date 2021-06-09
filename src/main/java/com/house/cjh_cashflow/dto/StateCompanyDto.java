package com.house.cjh_cashflow.dto;

public class StateCompanyDto {

    private long id;

    private int ratTableId;

    private String name;

    private long monthCashFlow;

    private long downPayment;

    private long totalCost;

    private long loan;

    private String type;

    private String createdDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRatTableId() {
        return ratTableId;
    }

    public void setRatTableId(int ratTableId) {
        this.ratTableId = ratTableId;
    }

    public long getMonthCashFlow() {
        return monthCashFlow;
    }

    public void setMonthCashFlow(long monthCashFlow) {
        this.monthCashFlow = monthCashFlow;
    }

    public long getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(long downPayment) {
        this.downPayment = downPayment;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public long getLoan() {
        return loan;
    }

    public void setLoan(long loan) {
        this.loan = loan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public StateCompanyDto(String name, long monthCashFlow, long downPayment, long totalCost, long loan) {
        this.name = name;
        this.monthCashFlow = monthCashFlow;
        this.downPayment = downPayment;
        this.totalCost = totalCost;
        this.loan = loan;
    }
}