package com.example.demo.ChatMessage.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiResponse.ApiResponse;
import com.example.demo.ChatMessage.Model.ChatInput;
import com.example.demo.ChatMessage.Model.ChatMessage;
import com.example.demo.ChatMessage.Service.ChatMessageService;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
//import java.util.Map;

@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/mensajes")
public class ChatMessageController {
    @Autowired
    ChatMessageService servicio;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Mapa para almacenar las conexiones activas de los usuarios (por ejemplo, basadas en ID de usuario)
    private java.util.Map<String, String> userSessions = new HashMap<>();


    @PostMapping("/sendMessageApi")
    public ResponseEntity<ApiResponse> sendMessage(@RequestBody ChatMessage message){
        return servicio.sendMessage(message);
    }

    @GetMapping("/getChat")
    public ResponseEntity<ApiResponse> getChat(@RequestBody ChatInput chat){
        return servicio.getChat(chat.getDriverId(), chat.getPassengerId());
    }

    @MessageMapping("/sendMessage") // Ruta donde el cliente envía mensajes
    //@SendTo("/topic/messages")      // Ruta donde los suscriptores recibirán mensajes
    public ResponseEntity<ApiResponse> handleMessage(ChatMessage message) {
        // Puedes procesar el mensaje si es necesario
        System.out.println("Mensaje recibido: " + message.getMessage());

        ResponseEntity<ApiResponse> respuesta = servicio.sendMessage(message);
        
        if(respuesta.getStatusCode() == HttpStatus.OK){

            // Obtén el destinatario del mensaje (por ejemplo, mediante un campo en el mensaje)
            int recipientId = message.getReceiver_id(); 

            // Verifica si el destinatario está conectado
            //String destination = "/user/" + Integer.toString(recipientId) + "/queue/messages"; // Canal privado para el destinatario
            
            String to_who = "driver";

            if (message.getfrom_who().equals("passenger")){
                to_who = "driver"; //Si el mensaje es del pasajero, debe ser enviado al conductor
            }

            else{
                to_who = "passenger";
            }
            
            String destination = "/queue/"+to_who+"/"+Integer.toString(recipientId)+"/messages";
            String destination_user = "/queue/"+message.getfrom_who()+"/"+Integer.toString(recipientId)+"/messages";
            // Envía el mensaje solo al destinatario
            System.out.println("Destino: " + destination);
            //messagingTemplate.convertAndSendToUser(Integer.toString(recipientId), destination, message);
            messagingTemplate.convertAndSend(destination_user, message); 
            messagingTemplate.convertAndSend(destination, message);    
        }

        return respuesta; // Devuelve el mensaje a los suscriptores
    }

    @MessageMapping("/connect")
    public void connectUser(int userId) {
        userSessions.put(Integer.toString(userId), "/user/" + userId); // Guarda la sesión del usuario
    }


}
