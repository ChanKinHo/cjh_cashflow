package com.house.cjh_cashflow.dto;

public class StockDto {

    private long id;

    private int ratTableId;

    private String roomCode;

    private String name;

    private long interest;

    private int totalCount;

    private long perCost;

    private String createdDate;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

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

    public long getInterest() {
        return interest;
    }

    public void setInterest(long interest) {
        this.interest = interest;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public long getPerCost() {
        return perCost;
    }

    public void setPerCost(long perCost) {
        this.perCost = perCost;
    }

    public int getRatTableId() {
        return ratTableId;
    }

    public void setRatTableId(int ratTableId) {
        this.ratTableId = ratTableId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
