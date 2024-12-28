package com.example.demo.ApiResponseChat;
import com.example.demo.Chat.Model.Chat;
import java.util.List;

public class ApiResponseChat {
    private String message;
    private String status;
    private List<Chat> data;

    public ApiResponseChat(String message, String status, List<Chat> data) {
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

    public void setData(List<Chat> data) {
        this.data = data;
    }
}

