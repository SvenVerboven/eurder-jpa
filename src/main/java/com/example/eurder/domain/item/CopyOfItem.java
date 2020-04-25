package com.example.eurder.domain.item;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CopyOfItem {

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "itemDescription")
    private String itemDescription;

    @Column(name = "itemPrice")
    private double itemPrice;

    @Column(name = "itemStockAmount")
    private int itemStockAmount;

    public CopyOfItem(String itemName, String itemDescription, double itemPrice, int itemStockAmount) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemStockAmount = itemStockAmount;
    }

    public CopyOfItem() {
    }
}


