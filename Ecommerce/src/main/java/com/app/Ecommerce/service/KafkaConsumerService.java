package com.app.Ecommerce.service;

import com.app.Ecommerce.model.Order;
import com.app.Ecommerce.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final OrderRepository orderRepository;

    public KafkaConsumerService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "orders", groupId = "order_group")
    public void consume(Order order) {
        System.out.println("Consumed order from Kafka: " + order);
        orderRepository.save(order);
    }
}