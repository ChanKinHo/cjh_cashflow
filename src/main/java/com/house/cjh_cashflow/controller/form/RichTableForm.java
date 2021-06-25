package com.house.cjh_cashflow.controller.form;

public class RichTableForm {

    private Long id;

    private Long playerId;

    private String playerName;

    private String roomCode;

    private Long initCashFlow;
    private Long winCashFlow;

    private Long richCashFlow;

    private Long monthCashFlow;

    private String createdDate;

    private String updatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Long getRichCashFlow() {
        return richCashFlow;
    }

    public void setRichCashFlow(Long richCashFlow) {
        this.richCashFlow = richCashFlow;
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

    public Long getMonthCashFlow() {
        return monthCashFlow;
    }

    public void setMonthCashFlow(Long monthCashFlow) {
        this.monthCashFlow = monthCashFlow;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Long getInitCashFlow() {
        return initCashFlow;
    }

    public void setInitCashFlow(Long initCashFlow) {
        this.initCashFlow = initCashFlow;
    }

    public Long getWinCashFlow() {
        return winCashFlow;
    }

    public void setWinCashFlow(Long winCashFlow) {
        this.winCashFlow = winCashFlow;
    }
}
