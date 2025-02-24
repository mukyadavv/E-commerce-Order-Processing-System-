package com.app.Ecommerce.repository;

import com.app.Ecommerce.model.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends ElasticsearchRepository<Order, String> {
    List<Order> findByProduct(String product);
}


