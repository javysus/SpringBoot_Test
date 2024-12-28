package com.example.demo.Chat.Model;

public class ChatInput {
    private Integer usuarioId;

    public ChatInput() {
    }

    public ChatInput(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioId() {        
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
