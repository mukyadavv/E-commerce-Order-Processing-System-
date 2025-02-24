package com.app.Ecommerce.controller;

import com.app.Ecommerce.model.Order;
import com.app.Ecommerce.repository.OrderRepository;
import com.app.Ecommerce.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final KafkaProducerService producerService;
    private final OrderRepository orderRepository;

    public OrderController(KafkaProducerService producerService, OrderRepository orderRepository) {
        this.producerService = producerService;
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        producerService.sendOrder(order);
        return "Order published to Kafka!";
    }

    @GetMapping("/search")
    public List<Order> searchOrders(@RequestParam String product) {
        return orderRepository.findByProduct(product);
    }
}
