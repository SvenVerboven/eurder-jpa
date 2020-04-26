package com.example.eurder.service.mapper;

import com.example.eurder.domain.order.Order;
import com.example.eurder.service.dto.OrderDto;
import com.example.eurder.service.dto.OrdersDto;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class OrderMapper {

    public static OrderDto toDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getItemGroups(),
                order.getUser(),
                order.getTotalPrice()
        );
    }

    public static Collection<OrderDto> toDto(Collection<Order> orders){
        return orders.stream().map(OrderMapper::toDto).collect(Collectors.toList());
    }

    public static OrdersDto toOrdersDto(Collection<Order> orders){
        return new OrdersDto(
                orders.stream().map(OrderMapper::toDto).collect(Collectors.toList()));

    }
}
