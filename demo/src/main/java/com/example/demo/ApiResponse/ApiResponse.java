package com.example.demo.ApiResponse;
import com.example.demo.ChatMessage.Model.ChatMessage;
import java.util.List;

public class ApiResponse {
    private String message;
    private String status;
    private List<ChatMessage> data;

    public ApiResponse(String message, String status, List<ChatMessage> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(List<ChatMessage> data) {
        this.data = data;
    }
}

