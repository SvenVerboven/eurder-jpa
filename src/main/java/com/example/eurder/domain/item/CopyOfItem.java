package com.example.eurder.domain.item;

import com.example.eurder.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CopyOfItem {

    @Column(name = "itemName")
    @JsonView(Views.Public.class)
    private String itemName;

    @Column(name = "itemDescription")
    @JsonView(Views.Detailed.class)
    private String itemDescription;

    @Column(name = "itemPrice")
    @JsonView(Views.Public.class)
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


