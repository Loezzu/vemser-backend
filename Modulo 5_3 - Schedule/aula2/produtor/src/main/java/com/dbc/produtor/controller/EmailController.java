package com.dbc.produtor.controller;


import com.dbc.produtor.dto.EmailDTO;
import com.dbc.produtor.service.EmailProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailProducerService emailProducerService;

    @PostMapping("/send")
    public void sendEmail(@RequestParam String destinatario, @RequestParam String assunto, @RequestBody String mensagem) throws JsonProcessingException {
        emailProducerService.sendEmail(destinatario, assunto, mensagem);
    }
}
