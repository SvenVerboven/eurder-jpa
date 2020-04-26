package com.example.eurder.service.dto;

public class ItemGroupDto {

    private final long itemId;
    private final int amountOfItems;

    public ItemGroupDto(long itemId, int amountOfItems) {
        this.itemId = itemId;
        this.amountOfItems = amountOfItems;
    }

    public long getItemId() {
        return itemId;
    }

    public int getAmountOfItems() {
        return amountOfItems;
    }
}
