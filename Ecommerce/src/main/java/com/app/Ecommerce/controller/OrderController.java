package com.app.Ecommerce.controller;

import com.app.Ecommerce.model.Order;
import com.app.Ecommerce.repository.OrderRedisRepository;
import com.app.Ecommerce.repository.OrderRepository;
import com.app.Ecommerce.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final KafkaProducerService producerService;
    private final OrderRepository orderRepository;
    private final OrderRedisRepository orderRedisRepository;

    public OrderController(KafkaProducerService producerService, OrderRepository orderRepository, OrderRedisRepository orderRedisRepository) {
        this.producerService = producerService;
        this.orderRepository = orderRepository;
        this.orderRedisRepository = orderRedisRepository;
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

    @GetMapping("/{orderId}")
    public Optional<Order> getOrder(@PathVariable String orderId) {
        return orderRedisRepository.findById(orderId);
    }
}
