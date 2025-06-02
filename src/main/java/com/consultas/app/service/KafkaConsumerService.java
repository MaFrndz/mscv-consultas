package com.consultas.app.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {



    @KafkaListener(topics = "${spring.kafka.topic:test}", groupId = "${spring.kafka.consumer.group-id:grupo-api2}")
    public void consumir(String mensaje) {
   
        System.out.println("Mensaje recibido: " + mensaje);
        // Aquí puedes llamar a un servicio o procesarlo como quieras
    }
}
