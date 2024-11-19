package com.example.demo.ChatMessage.Repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ChatMessage.Model.ChatMessage;

@Repository
public interface ChatMessageRepo extends JpaRepository<ChatMessage, Serializable> {

    // public abstract List<ChatMessage> findByChatId(int chat);

    public abstract List<ChatMessage> findByDriverIdAndPassengerId(int driver_id, int passenger_id);
}
