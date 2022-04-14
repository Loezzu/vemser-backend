package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.ProdutorDTO;
import com.dbc.chatkafka.enums.Chat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private final ObjectMapper objectMapper;


    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @KafkaListener(
            groupId = "luiz",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "geral",
            topicPartitions = {@TopicPartition(topic = "chat-marcar-churrasco", partitions = {"0"})})
    public void consumeChatGeral(@Payload String message) throws JsonProcessingException {
        ProdutorDTO produtorDTO = objectMapper.readValue(message, ProdutorDTO.class);
        String data = produtorDTO.getDataCriacao().format(formatter);
        System.out.println(data + " [" + produtorDTO.getUsuario() + "] "  + produtorDTO.getMensagem());
    }

    @KafkaListener(
            groupId = "luiz",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "private",
            topicPartitions = {@TopicPartition(topic = "chat-marcar-churrasco", partitions = {"10"})})
    public void consumeMyChat(@Payload String message)throws JsonProcessingException {
        ProdutorDTO produtorDTO = objectMapper.readValue(message, ProdutorDTO.class);
        String data = produtorDTO.getDataCriacao().format(formatter);
        System.out.println(data + " [" + produtorDTO.getUsuario() + "] (privada): "  + produtorDTO.getMensagem());

    }
}
