package com.example.demo.ChatMessage.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.ChatMessage.Model.Chat;
import com.example.demo.ChatMessage.Model.ChatMessage;
import com.example.demo.ChatMessage.Service.ChatMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/chat")
public class ChatMessageController {
    @Autowired
    ChatMessageService servicio;

    @PostMapping("/sendMessageApi")
    public ResponseEntity<ApiResponse> sendMessage(@RequestBody ChatMessage message){
        return servicio.sendMessage(message);
    }

    @GetMapping("/getChat")
    public ResponseEntity<ApiResponse> getChat(@RequestBody Chat chat){
        return servicio.getChat(chat.getDriverId(), chat.getPassengerId());
    }

    @MessageMapping("/sendMessage") // Ruta donde el cliente envía mensajes
    @SendTo("/topic/messages")      // Ruta donde los suscriptores recibirán mensajes
    public ChatMessage handleMessage(ChatMessage message) {
        // Puedes procesar el mensaje si es necesario
        System.out.println("Mensaje recibido: " + message.getMessage());
        servicio.sendMessage(message);
        return message; // Devuelve el mensaje a los suscriptores
    }
}
