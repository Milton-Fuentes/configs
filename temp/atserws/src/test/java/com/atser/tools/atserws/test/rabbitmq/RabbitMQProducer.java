/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.test.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author droldan
 */
public class RabbitMQProducer {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        // Step 1. Create an amqp qpid connection
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            // Step 2. Declare the Queue
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World Dayron Perez!";
            // Step 2. Publish Message to the Queue
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbitMQProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
