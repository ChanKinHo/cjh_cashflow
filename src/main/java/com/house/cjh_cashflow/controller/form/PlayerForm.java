package com.house.cjh_cashflow.controller.form;

public class PlayerForm {

    private Long id;

    private String name;

    private String roomCode;

    private String career;

    private String isRich;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getIsRich() {
        return isRich;
    }

    public void setIsRich(String isRich) {
        this.isRich = isRich;
    }
}
