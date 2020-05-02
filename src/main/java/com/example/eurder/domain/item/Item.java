package com.example.eurder.domain.item;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "stockAmount")
    private int stockAmount;

    public Item() {
    }

    public Item(String name, String description, double price, int stockAmount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public LocalDate getShippingDay(int orderedAmountOfItems) {
        if (stockAmount >= orderedAmountOfItems) {
            return LocalDate.now().plusDays(1);
        }
        return LocalDate.now().plusDays(7);
    }

    public void decreaseStockAmount(int amount){
        this.stockAmount -= amount;
    }
}
