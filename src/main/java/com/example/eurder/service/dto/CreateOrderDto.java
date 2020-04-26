package com.example.eurder.service.dto;

import java.util.List;

public class CreateOrderDto {

    private final long userId;
    private final List<ItemGroupDto> orderedItems;

    public CreateOrderDto(long userId, List<ItemGroupDto> orderedItems) {
        this.userId = userId;
        this.orderedItems = orderedItems;
    }

    public long getUserId() {
        return userId;
    }

    public List<ItemGroupDto> getOrderedItems() {
        return orderedItems;
    }
}

