package com.example.eurder.domain.itemgroup;

import com.example.eurder.domain.Views;
import com.example.eurder.domain.item.CopyOfItem;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "itemGroup")
public class ItemGroup {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonView(Views.Detailed.class)
    private long id;

    @JsonView(Views.Public.class)
    @Embedded
    private CopyOfItem copyOfItem;

    @JsonView(Views.Public.class)
    @Column(name = "amountOfItems")
    private int amountOfItems;

    @JsonView(Views.Detailed.class)
    @Column(name = "shippingDate")
    private LocalDate shippingDate;

    public ItemGroup() {
    }

    public ItemGroup(CopyOfItem copyOfItem, int amountOfItems, LocalDate shippingDate) {
        this.copyOfItem = copyOfItem;
        this.amountOfItems = amountOfItems;
        this.shippingDate = shippingDate;
    }

    public long getId() {
        return id;
    }

    public CopyOfItem getCopyOfItem() {
        return copyOfItem;
    }

    public int getAmountOfItems() {
        return amountOfItems;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
