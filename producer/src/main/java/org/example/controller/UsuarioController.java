package org.example.controller;

import org.example.dto.UsuarioCriado;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class UsuarioController {
    private final KafkaTemplate<String, UsuarioCriado> kafkaTemplate;
    @Value("${spring.kafka.topic}")
    private String topic;

    public UsuarioController(KafkaTemplate<String, UsuarioCriado> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public void send(@RequestBody UsuarioCriado usuarioCriado) {
        kafkaTemplate.send(topic, usuarioCriado);
    }
}
