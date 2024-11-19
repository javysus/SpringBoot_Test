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
    @Column(name="id")
    private Long id;

    @Column(name="message")
    private String message;

    @Column(name="fromWho")
    private String fromWho;

    @Column(name="fecha")
    private Date fecha;

    @Column(name="chat")
    private Integer chat;

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

    public ChatMessage(String message, String fromWho, Date fecha, Integer chat, Integer driver_id, Integer passenger_id,
    Integer sender_id, Integer receiver_id){
        this.message = message;
        this.fromWho = fromWho;
        this.fecha = fecha;
        this.chat = chat;
        this.driverId = driver_id;
        this.passengerId = passenger_id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
    
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getChat() {
        return chat;
    }

    public void setChat(Integer chat) {
        this.chat = chat;
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
