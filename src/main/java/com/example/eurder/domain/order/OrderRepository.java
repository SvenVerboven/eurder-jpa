package com.example.eurder.domain.order;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Collection<Order> findAllByUser_Id(long userId);
}
