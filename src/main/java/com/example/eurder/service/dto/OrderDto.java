package com.example.eurder.service.dto;

import com.example.eurder.domain.Views;
import com.example.eurder.domain.itemgroup.ItemGroup;
import com.example.eurder.domain.user.User;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class OrderDto {

    @JsonView(Views.Public.class)
    private final long id;

    @JsonView(Views.Public.class)
    private final List<ItemGroup> itemGroups;

    @JsonView(Views.Detailed.class)
    private final User user;

    @JsonView(Views.Public.class)
    private final double totalPrice;

    public OrderDto(long id, List<ItemGroup> itemGroups, User user, double totalPrice) {
        this.id = id;
        this.itemGroups = itemGroups;
        this.user = user;
        this.totalPrice = totalPrice;
    }


    public long getId() {
        return id;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public User getUser() {
        return user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
