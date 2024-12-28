package com.example.demo.ChatMessage.Service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.Chat.Service.ChatService;
import com.example.demo.ChatMessage.Model.ChatMessage;
import com.example.demo.ChatMessage.Repository.ChatMessageRepo;

@Service
public class ChatMessageService {
    @Autowired
    ChatMessageRepo repositorio;

    @Autowired
    ChatService chatService;

    public ResponseEntity<ApiResponse> sendMessage(ChatMessage message){
        try{
            //Guardar el mensaje en la base de datos
            repositorio.save(message);
            
            if(message.getfrom_who().equals("driver")){
                //Si el mensaje es del conductor, actualizar el chat del pasajero
                chatService.updateChatPassenger(message.getChat(), message.getMessage(), message.getFecha());
            }
            else if (message.getfrom_who().equals("passenger")){
                //Si el mensaje es del pasajero, actualizar el chat del conductor
                chatService.updateChatDriver(message.getChat(), message.getMessage(), message.getFecha());
            }
            
            ApiResponse response = new ApiResponse("Message saved successfully", "OK", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
        ApiResponse response = new ApiResponse("Failed to save message", "NOOK", null);
        System.out.println(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ApiResponse> getChat(int driver_id, int passenger_id){
            try{
                //List<ChatMessage> chat = repositorio.findByDriverIdAndPassengerId(driver_id, passenger_id);
                //System.out.println(repositorio.findByDriverIdAndPassengerId(driver_id, passenger_id).get(0).getMessage());
                ApiResponse response = new ApiResponse("Chat retrieved successfully", "OK",
                 repositorio.findByDriverIdAndPassengerId(driver_id, passenger_id));
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {        
                ApiResponse response = new ApiResponse("Failed to retrieve chat", "NOOK", null);
                System.out.println(e.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }
    
}
