package com.dbc.chatkafka.enums;

public enum Chat {
    CHAT_GERAL("chat-geral"),
    CHAT_LUIZ("chat-luiz"),
    CHAT_GUILHERME("chat-guilherme"),
    CHAT_PABLO("chat-pablo"),
    CHAT_NICOLAS("chat-nicolas"),
    CHAT_ANA("chat-ana"),
    CHAT_GABRIEL("chat-gabriel"),
    CHAT_GUSTAVO("chat-gustavo"),
    CHAT_JOAO("chat-joao"),
    CHAT_LUCAS("chat-lucas"),
    CHAT_EZEQUIAS("chat-ezequias"),
    CHAT_MAICON("chat-maicon");

    private String chatName;

    Chat(String chatName) {
        this.chatName = chatName;
    }

    public String getChatName() {
        return chatName;
    }

}
