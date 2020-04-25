package com.example.eurder.domain.order;

import com.example.eurder.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<ItemGroup> itemGroups;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    public Order() {
    }
}
