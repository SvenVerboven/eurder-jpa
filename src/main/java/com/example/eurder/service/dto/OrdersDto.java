package com.example.eurder.service.dto;

import com.example.eurder.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Collection;

public class OrdersDto {

    @JsonView(Views.Public.class)
    private final Collection<OrderDto> orders;
    @JsonView(Views.Public.class)
    private final double totalPriceOfOrders;

    public OrdersDto(Collection<OrderDto> orders) {
        this.orders = orders;
        this.totalPriceOfOrders = calculateTotalPriceOfOrders(orders);
    }

    private double calculateTotalPriceOfOrders(Collection<OrderDto> orders) {
        return orders.stream().mapToDouble(OrderDto::getTotalPrice).sum();
    }

    public Collection<OrderDto> getOrders() {
        return orders;
    }

    public double getTotalPriceOfOrders() {
        return totalPriceOfOrders;
    }
}
