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

    public CopyOfItem(Item item) {
        this.itemName = item.getName();
        this.itemDescription = item.getDescription();
        this.itemPrice = item.getPrice();
    }

    public CopyOfItem() {
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}


