package com.example.eurder.domain.order;

import com.example.eurder.domain.itemgroup.ItemGroup;
import com.example.eurder.domain.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(name = "ORDER_SEQUENCE", sequenceName = "ORDER_SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDER_SEQUENCE")
    private long id;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<ItemGroup> itemGroups;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    public Order() {
    }

    public Order(List<ItemGroup> itemGroups, User user) {
        this.itemGroups = itemGroups;
        this.user = user;
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
        return itemGroups.stream().mapToDouble(x -> x.getCopyOfItem().getItemPrice() * x.getAmountOfItems()).sum();
    }
}
