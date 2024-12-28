package com.example.demo.Chat.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ApiResponseChat.ApiResponseChat;
import com.example.demo.Chat.Model.Chat;
import com.example.demo.Chat.Model.ChatInput;
import com.example.demo.Chat.Service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService servicio;

    @PostMapping("/createChat")
    public ResponseEntity<ApiResponseChat> createChat(@RequestBody Chat chat) {
    
        return servicio.createChat(chat);
    }
    
    @PutMapping("/readMessagesDriver")
    public ResponseEntity<ApiResponseChat> readMessagesDriver(@RequestBody Integer id_chat){
        return servicio.readMessagesDriver(id_chat);
    }

    @PutMapping("/readMessagesPassenger")
    public ResponseEntity<ApiResponseChat> readMessagesPassenger(@RequestBody Integer id_chat){
        return servicio.readMessagesPassenger(id_chat);
    }

    @GetMapping("/getDriverChats")
    public ResponseEntity<ApiResponseChat> getDriverChats(@RequestBody ChatInput chatInput){
        return servicio.getDriverChats(chatInput.getUsuarioId());
    }

    @GetMapping("/getPassengerChats")
    public ResponseEntity<ApiResponseChat> getPassengerChats(@RequestBody ChatInput chatInput){
        return servicio.getPassengersChat(chatInput.getUsuarioId());
    }
}