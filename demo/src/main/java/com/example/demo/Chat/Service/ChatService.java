package com.example.demo.Chat.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.ApiResponseChat.ApiResponseChat;
import com.example.demo.Chat.Model.Chat;
import com.example.demo.Chat.Repository.ChatRepo;

@Service
public class ChatService {
    @Autowired
    ChatRepo repositorio;


    public ResponseEntity<ApiResponseChat> createChat(Chat chat){
        try{
            //Guardar el chat en la base de datos
            repositorio.save(chat);
            
            ApiResponseChat response = new ApiResponseChat("Chat saved successfully", "OK", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
        ApiResponseChat response = new ApiResponseChat("Failed to save chat", "NOOK", null);
        System.out.println(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }
    //Actualiza el chat para el pasajero, es decir, los mensajes del conductor al pasajero
    public void updateChatPassenger(int id_chat, String last_message_driver, Date last_message_driver_date){
        Chat chat =repositorio.findByIdChat(id_chat);
        chat.setLast_message_driver(last_message_driver);
        chat.setLast_message_driver_date(last_message_driver_date);
        chat.setUnread_messages_driver(chat.getUnread_messages_driver() + 1); //mensajes sin leer de parte del conductor
        repositorio.save(chat);
    }

    //Actualiza el chat para el conductor, es decir, los mensajes del pasajero al conductor
    public void updateChatDriver(int id_chat, String last_message_passenger, Date last_message_passenger_date){
        Chat chat =repositorio.findByIdChat(id_chat);
        chat.setLast_message_passenger(last_message_passenger);
        chat.setLast_message_passenger_date(last_message_passenger_date);
        chat.setUnread_messages_passenger(chat.getUnread_messages_passenger() + 1); //mensajes sin leer de parte del pasajero
        repositorio.save(chat);
    }

    public ResponseEntity<ApiResponseChat> getDriverChats(int driver_id){
        try{
            ApiResponseChat response = new ApiResponseChat("Chats retrieved successfully", "OK",
                 repositorio.findByDriverId(driver_id));
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            ApiResponseChat response = new ApiResponseChat("Failed to get chats", "NOOK", null);
            System.out.println(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public ResponseEntity<ApiResponseChat> getPassengersChat(int passenger_id){
        try{
            ApiResponseChat response = new ApiResponseChat("Chats retrieved successfully", "OK",
                 repositorio.findByDriverId(passenger_id));
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            ApiResponseChat response = new ApiResponseChat("Failed to get chats", "NOOK", null);
            System.out.println(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiResponseChat> readMessagesPassenger(int id_chat){
        try{
        Chat chat =repositorio.findByIdChat(id_chat);
        chat.setUnread_messages_passenger(0);
        repositorio.save(chat);

        ApiResponseChat response = new ApiResponseChat("Chat saves successfully", "OK", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
        catch(Exception e){
            ApiResponseChat response = new ApiResponseChat("Failed to save chat", "NOOK", null);
            System.out.println(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<ApiResponseChat> readMessagesDriver(int id_chat){    
        try{
        Chat chat =repositorio.findByIdChat(id_chat);
        chat.setUnread_messages_driver(0);
        repositorio.save(chat);
        ApiResponseChat response = new ApiResponseChat("Chat saves successfully", "OK", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
        catch(Exception e){
            ApiResponseChat response = new ApiResponseChat("Failed to save chat", "NOOK", null);
            System.out.println(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
