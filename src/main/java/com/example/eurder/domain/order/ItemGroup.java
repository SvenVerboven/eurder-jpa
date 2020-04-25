package com.example.eurder.domain.order;

import com.example.eurder.domain.item.CopyOfItem;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "itemGroup")
public class ItemGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private CopyOfItem copyOfItem;

    @Column(name = "amountOfItems")
    private int amountOfItems;

    @Column(name = "shippingDate")
    private LocalDate shippingDate;

    public ItemGroup() {
    }

    public ItemGroup(CopyOfItem copyOfItem, int amountOfItems, LocalDate shippingDate) {
        this.copyOfItem = copyOfItem;
        this.amountOfItems = amountOfItems;
        this.shippingDate = shippingDate;
    }
}
