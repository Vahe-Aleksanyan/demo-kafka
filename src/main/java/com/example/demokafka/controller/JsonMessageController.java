package com.example.demokafka.controller;

import com.example.demokafka.kafka.JsonKafkaProducer;
import com.example.demokafka.kafka.KafkaProducer;
import com.example.demokafka.model.User;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }




    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        if (user == null || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getLastName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User name and last name are required.");
        }

        try {
            kafkaProducer.sendMessage(user);
            return ResponseEntity.ok("JSON message has been successfully sent to the Kafka topic.");
        } catch (Exception e) {
            // Log the error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send JSON message to Kafka topic.");
        }
    }
}
