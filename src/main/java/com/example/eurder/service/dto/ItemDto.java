package com.example.eurder.service.dto;

import com.example.eurder.domain.item.UrgencyIndicator;

public class ItemDto {

    private final long id;
    private final String name;
    private final String description;
    private final double price;
    private final int stockAmount;
    private final UrgencyIndicator urgencyIndicator;

    public ItemDto(long id, String name, String description, double price, int stockAmount, UrgencyIndicator urgencyIndicator) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
        this.urgencyIndicator = urgencyIndicator;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public UrgencyIndicator getUrgencyIndicator() {
        return urgencyIndicator;
    }
}
