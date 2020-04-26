package com.example.eurder.service.mapper;

import com.example.eurder.domain.order.Order;
import com.example.eurder.service.dto.OrderDto;

public abstract class OrderMapper {

    public static OrderDto toDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getItemGroups(),
                order.getUser(),
                order.getTotalPrice()
        );
    }
}
