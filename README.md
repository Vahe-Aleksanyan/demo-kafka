<!DOCTYPE html>
<html lang="en">
<body>

  <h1>Demo Kafka Application</h1>

  <p>This repository contains a demo Kafka application built with Spring Boot. The application demonstrates how to consume JSON messages from a Kafka topic, process them, and store them in a PostgreSQL database.</p>

  <h2>Features</h2>
  <ul>
    <li><strong>Kafka Integration:</strong> Consumes JSON messages from a Kafka topic (<code>javaguides_json</code>).</li>
    <li><strong>Database Integration:</strong> Stores processed data in a PostgreSQL database.</li>
    <li><strong>REST API:</strong> Exposes a RESTful API to publish JSON messages to the Kafka topic.</li>
    <li>cors validation</li>
  </ul>

  <h2>Setup Instructions</h2>
  <ol>
    <li><strong>Clone Repository:</strong> <code>git clone &lt;repository_url&gt;</code></li>
    <li><strong>Configure PostgreSQL:</strong> 
      <ul>
        <li>Install PostgreSQL server.</li>
        <li>Create a database and update the <code>application.properties</code> file with the database URL, username, and password.</li>
      </ul>
    </li>
    <li><strong>Start Kafka Server:</strong> 
      <ul>
        <li>Install Kafka and start the Kafka server.</li>
          <ul>
              <li>bin/zookeeper-server-start.sh config/zookeeper.properties</li>
              <li>bin/kafka-server-start.sh config/server.properties</li>
          </ul>
        <li>Create a topic named <code>javaguides_json</code>.</li>
      </ul>
    </li>
    <li><strong>Build and Run Application:</strong> <code>cd demo-kafka</code>, then <code>mvn spring-boot:run</code></li>
    <li><strong>Send JSON Messages:</strong> 
      <ul>
        <li>Use tools like Postman to send JSON messages to the REST API (<code>http://localhost:8080/api/v1/kafka/publish</code>).</li>
      </ul>
    </li>
  </ol>

  <h2>Technologies Used</h2>
  <ul>
    <li>Spring Boot</li>
    <li>Kafka</li>
    <li>PostgreSQL</li>
    <li>Maven</li>
  </ul>

  <h2>Contributors</h2>
  <ul>
    <li><a href="https://github.com/your_username">Vahe Aleksanyan</a></li>
  </ul>

 

</body>
</html>
