package com.app.Ecommerce.repository;

import com.app.Ecommerce.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRedisRepository extends CrudRepository<Order, String> {
}
