package com.house.cjh_cashflow.dto;

import java.util.List;

public class RatTableDto {

    private Long id;

    private String career;

    private String roomCode;

    private String careerName;

    private Long playerId;

    private String playerName;

    private String isInit;

    private long passiveIncome;

    private long totalIncome;

    private long totalPay;

    private long monthCashFlow;

    private long salary;

    private long payPerChild;

    private int childCount;

    private long taxPay;

    private long housePay;

    private long educationPay;

    private long carPay;

    private long creditCardPay;

    private long extraPay;

    private long otherPay;

    private long childrenPay;

    private long bankPay;

    private long houseLoan;

    private long educationLoan;

    private long carLoan;

    private long creditCard;

    private long extraDebt;

    private long bankLoan;

    private long bankStore;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    private List<EstateCompanyDto> estateCompanyDtos;

    private List<StockDto> stockDtos;

    private String createdDate;

    private String updatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getIsInit() {
        return isInit;
    }

    public void setIsInit(String isInit) {
        this.isInit = isInit;
    }

    public long getPassiveIncome() {
        return passiveIncome;
    }

    public void setPassiveIncome(long passiveIncome) {
        this.passiveIncome = passiveIncome;
    }

    public long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(long totalIncome) {
        this.totalIncome = totalIncome;
    }

    public long getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(long totalPay) {
        this.totalPay = totalPay;
    }

    public long getMonthCashFlow() {
        return monthCashFlow;
    }

    public void setMonthCashFlow(long monthCashFlow) {
        this.monthCashFlow = monthCashFlow;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getPayPerChild() {
        return payPerChild;
    }

    public void setPayPerChild(long payPerChild) {
        this.payPerChild = payPerChild;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public long getTaxPay() {
        return taxPay;
    }

    public void setTaxPay(long taxPay) {
        this.taxPay = taxPay;
    }

    public long getHousePay() {
        return housePay;
    }

    public void setHousePay(long housePay) {
        this.housePay = housePay;
    }

    public long getEducationPay() {
        return educationPay;
    }

    public void setEducationPay(long educationPay) {
        this.educationPay = educationPay;
    }

    public long getCarPay() {
        return carPay;
    }

    public void setCarPay(long carPay) {
        this.carPay = carPay;
    }

    public long getCreditCardPay() {
        return creditCardPay;
    }

    public void setCreditCardPay(long creditCardPay) {
        this.creditCardPay = creditCardPay;
    }

    public long getExtraPay() {
        return extraPay;
    }

    public void setExtraPay(long extraPay) {
        this.extraPay = extraPay;
    }

    public long getOtherPay() {
        return otherPay;
    }

    public void setOtherPay(long otherPay) {
        this.otherPay = otherPay;
    }

    public long getChildrenPay() {
        return childrenPay;
    }

    public void setChildrenPay(long childrenPay) {
        this.childrenPay = childrenPay;
    }

    public long getBankPay() {
        return bankPay;
    }

    public void setBankPay(long bankPay) {
        this.bankPay = bankPay;
    }

    public long getHouseLoan() {
        return houseLoan;
    }

    public void setHouseLoan(long houseLoan) {
        this.houseLoan = houseLoan;
    }

    public long getEducationLoan() {
        return educationLoan;
    }

    public void setEducationLoan(long educationLoan) {
        this.educationLoan = educationLoan;
    }

    public long getCarLoan() {
        return carLoan;
    }

    public void setCarLoan(long carLoan) {
        this.carLoan = carLoan;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }

    public long getExtraDebt() {
        return extraDebt;
    }

    public void setExtraDebt(long extraDebt) {
        this.extraDebt = extraDebt;
    }

    public long getBankLoan() {
        return bankLoan;
    }

    public void setBankLoan(long bankLoan) {
        this.bankLoan = bankLoan;
    }

    public long getBankStore() {
        return bankStore;
    }

    public void setBankStore(long bankStore) {
        this.bankStore = bankStore;
    }

    public List<EstateCompanyDto> getEstateCompanyDtos() {
        return estateCompanyDtos;
    }

    public void setEstateCompanyDtos(List<EstateCompanyDto> estateCompanyDtos) {
        this.estateCompanyDtos = estateCompanyDtos;
    }

    public List<StockDto> getStockDtos() {
        return stockDtos;
    }

    public void setStockDtos(List<StockDto> stockDtos) {
        this.stockDtos = stockDtos;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
