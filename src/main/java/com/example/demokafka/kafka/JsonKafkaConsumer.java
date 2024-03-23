//package com.example.demokafka.kafka;
//
//import com.example.demokafka.model.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//
//
//@Service
//public class JsonKafkaConsumer {
//    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
//
//    @KafkaListener(topics = "javaguides_json", groupId = "myGroup")
//    public void consumer(User user) {
//        LOGGER.info(String.format("Json Message recieved - ", user.toString()));
//    }
//}


package com.example.demokafka.kafka;

import com.example.demokafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "javaguides_json", groupId = "myGroup")
    public void consume(User user) {
        LOGGER.info("Received JSON message: {}", user);
        // Add your processing logic here
    }
}
