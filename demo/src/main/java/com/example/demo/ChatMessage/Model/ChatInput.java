package com.example.demo.ChatMessage.Model;


public class ChatInput {
    private Integer driverId;
    private Integer passengerId;

    public ChatInput(Integer driverId, Integer passengerId) {
        this.driverId = driverId;
        this.passengerId = passengerId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }
}
