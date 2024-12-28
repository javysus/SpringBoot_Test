package com.example.demo.Chat.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="chat")
public class Chat {
    @Id
    @Column(name="id_chat")
    private Integer idChat;
    
    @Column(name="id_viaje")
    private Integer id_viaje;

    @Column(name="viaje_activo")
    private Boolean viaje_activo;

    @Column(name="driver_id")
    private Integer driverId;

    @Column(name="passenger_id")
    private Integer passengerId;

    @Column(name="last_message_driver")
    private String last_message_driver;

    @Column(name="last_message_passenger")
    private String last_message_passenger;

    @Column(name="last_message_driver_date")
    private Date last_message_driver_date;

    @Column(name="last_message_passenger_date")
    private Date last_message_passenger_date;

    @Column(name="name_driver")
    private String name_driver;

    @Column(name="name_passenger")
    private String name_passenger;


    @Column(name="url_image_driver")
    private String url_image_driver;

    @Column(name="url_image_passenger")
    private String url_image_passenger;

    @Column(name="unread_messages_driver")
    private int unread_messages_driver;

    @Column(name="unread_messages_passenger")
    private int unread_messages_passenger;

    public Chat() {
    }

    public Chat(Integer id_chat, Integer id_viaje, Boolean viaje_activo, Integer driverId, Integer passengerId, String last_message_driver, String last_message_passenger, Date last_message_driver_date, Date last_message_passenger_date, String url_image_driver, String url_image_passenger, int unread_messages_driver, int unread_messages_passenger) {
        this.idChat = id_chat;
        this.id_viaje = id_viaje;
        this.viaje_activo = viaje_activo;
        this.driverId = driverId;
        this.passengerId = passengerId;
        this.last_message_driver = last_message_driver;
        this.last_message_passenger = last_message_passenger;
        this.last_message_driver_date = last_message_driver_date;
        this.last_message_passenger_date = last_message_passenger_date;
        this.url_image_driver = url_image_driver;
        this.url_image_passenger = url_image_passenger;
        this.unread_messages_driver = unread_messages_driver;
        this.unread_messages_passenger = unread_messages_passenger;
    }

    public Integer getId_chat() {        
        return idChat;
    }    

    public void setId_chat(Integer id_chat) {
        this.idChat = id_chat;
    }

    public Integer getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(Integer id_viaje) {
        this.id_viaje = id_viaje;
    }

    public Boolean getViaje_activo() {
        return viaje_activo;
    }

    public void setViaje_activo(Boolean viaje_activo) {
        this.viaje_activo = viaje_activo;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getLast_message_driver() {
        return last_message_driver;
    }

    public void setLast_message_driver(String last_message_driver) {
        this.last_message_driver = last_message_driver;
    }

    public String getLast_message_passenger() {
        return last_message_passenger;
    }

    public void setLast_message_passenger(String last_message_passenger) {
        this.last_message_passenger = last_message_passenger;
    }

    public Date getLast_message_driver_date() {
        return last_message_driver_date;
    }

    public void setLast_message_driver_date(Date last_message_driver_date) {
        this.last_message_driver_date = last_message_driver_date;
    }

    public Date getLast_message_passenger_date() {
        return last_message_passenger_date;
    }

    public void setLast_message_passenger_date(Date last_message_passenger_date) {
        this.last_message_passenger_date = last_message_passenger_date;
    }

    public String getUrl_image_driver() {
        return url_image_driver;
    }

    public void setUrl_image_driver(String url_image_driver) {
        this.url_image_driver = url_image_driver;
    }

    public String getUrl_image_passenger() {
        return url_image_passenger;
    }

    public void setUrl_image_passenger(String url_image_passenger) {
        this.url_image_passenger = url_image_passenger;
    }

    public int getUnread_messages_driver() {
        return unread_messages_driver;
    }

    public void setUnread_messages_driver(int unread_messages_driver) {
        this.unread_messages_driver = unread_messages_driver;
    }

    public int getUnread_messages_passenger() {
        return unread_messages_passenger;
    }

    public void setUnread_messages_passenger(int unread_messages_passenger) {
        this.unread_messages_passenger = unread_messages_passenger;
    }

    public String getName_driver() {
        return name_driver;
    }

    public void setName_driver(String name_driver) {
        this.name_driver = name_driver;
    }

    public String getName_passenger() {
        return name_passenger;
    }

    public void setName_passenger(String name_passenger) {
        this.name_passenger = name_passenger;
    }
    
}
