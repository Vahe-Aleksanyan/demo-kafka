

package com.example.demokafka.kafka;

import com.example.demokafka.model.User;
import com.example.demokafka.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    private UserRepo userRepository;
    private DataSource dataSource;
    public JsonKafkaConsumer(UserRepo userRepository, DataSource dataSource) {
        this.userRepository = userRepository;
        this.dataSource = dataSource;

        checkDatabaseConnection();
    }

    private void checkDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            // Execute a simple query to verify connectivity
            String testQuery = "SELECT 1";
            connection.prepareStatement(testQuery).execute();
//            LOGGER.info("Database connection is OK");
            System.out.println("Database connection is OK");
        } catch (SQLException e) {
//            LOGGER.error("Error connecting to the database: {}", e.getMessage());
            System.out.println("Error ===== " + e.getMessage());
        }
    }


    @KafkaListener(topics = "javaguides_json", groupId = "myGroup")
    public void consume(User user) {
        LOGGER.info("Received JSON message: {}", user);

        try {
            // Insert the received user into the database

            User savedUser = userRepository.save(user);
            LOGGER.info("User saved successfully with ID: {}", savedUser.getId());
        } catch (Exception e) {
//            LOGGER.error("Error saving user to the database: {}", e.getMessage(), e);
            System.out.println(e.getMessage());
        }
    }
}
