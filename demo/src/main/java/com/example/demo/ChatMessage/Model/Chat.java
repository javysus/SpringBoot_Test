package com.example.demo.ChatMessage.Model;


public class Chat {
    private Integer driverId;
    private Integer passengerId;

    public Chat(Integer driverId, Integer passengerId) {
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
