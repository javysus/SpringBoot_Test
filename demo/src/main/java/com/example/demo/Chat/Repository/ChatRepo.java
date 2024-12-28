package com.example.demo.Chat.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Chat.Model.Chat;

public interface ChatRepo extends JpaRepository<Chat, Serializable>{
    public abstract Chat findByIdChat(int id_chat);

    public abstract List<Chat> findByDriverId(int driver_id);

    public abstract List<Chat> findByPassengerId(int passenger_id);

}
