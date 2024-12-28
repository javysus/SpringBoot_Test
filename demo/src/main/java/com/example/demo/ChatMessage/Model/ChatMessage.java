package com.example.demo.ChatMessage.Model;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_message")
    private Long id_message;

    @Column(name="message")
    private String message;

    @Column(name="from_who")
    private String from_who;

    @Column(name="fecha")
    private Date fecha;

    @Column(name="id_chat")
    private Integer id_chat;

    @Column(name="driver_id")
    private Integer driverId;

    @Column(name="passenger_id")
    private Integer passengerId;

    @Column(name="sender_id")
    private Integer sender_id;

    @Column(name="receiver_id")
    private Integer receiver_id;

    public ChatMessage() {
    }

    public ChatMessage(String message, String from_who, Date fecha, Integer id_chat, Integer driver_id, Integer passenger_id,
    Integer sender_id, Integer receiver_id){
        this.message = message;
        this.from_who = from_who;
        this.fecha = fecha;
        this.id_chat = id_chat;
        this.driverId = driver_id;
        this.passengerId = passenger_id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
    
    }

    public Long getId() {
        return id_message;
    }
    public void setId(Long id_message) {
        this.id_message = id_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getfrom_who() {
        return from_who;
    }

    public void setfrom_who(String from_who) {
        this.from_who = from_who;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getChat() {
        return id_chat;
    }

    public void setChat(Integer id_chat) {
        this.id_chat = id_chat;
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

    public Integer getSender_id() {
        return sender_id;
    }

    public void setSender_id(Integer sender_id) {
        this.sender_id = sender_id;
    }

    public Integer getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(Integer receiver_id) {
        this.receiver_id = receiver_id;
    }

    
}
