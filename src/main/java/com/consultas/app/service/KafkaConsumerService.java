package com.consultas.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.consultas.app.model.TaskDetail;
import com.consultas.app.repository.TaskDetailRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumerService {

    @Autowired
    private TaskDetailRepository kafkaTaskRepository;

    @KafkaListener(topics = "${spring.kafka.topic:test}", groupId = "${spring.kafka.consumer.group-id:grupo-api2}")
    public void consumir(String mensaje) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(mensaje);
            String idTask = node.get("idTask").toString();
            List<String> coments = mapper.convertValue(node.get("coments"),
                    mapper.getTypeFactory().constructCollectionType(List.class, String.class));
            TaskDetail kafkaTask = new TaskDetail(idTask, coments);
            kafkaTaskRepository.save(kafkaTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
