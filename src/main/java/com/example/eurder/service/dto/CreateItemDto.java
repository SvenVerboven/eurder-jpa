package com.example.eurder.service.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class CreateItemDto {

    @NotEmpty(message = "name can't be empty")
    private final String name;
    @NotEmpty(message = "description can't be empty")
    private final String description;
    @Positive(message = "price must be a positive number")
    private final double price;
    @PositiveOrZero(message = "stock amount must be '0' or positive")
    private final int stockAmount;

    public CreateItemDto(String name, String description, double price, int stockAmount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
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
}
