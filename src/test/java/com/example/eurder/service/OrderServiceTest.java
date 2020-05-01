package com.example.eurder.service;

import com.example.eurder.domain.item.CopyOfItem;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.ItemRepository;
import com.example.eurder.domain.itemgroup.ItemGroup;
import com.example.eurder.domain.itemgroup.ItemGroupRepository;
import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.order.OrderRepository;
import com.example.eurder.domain.user.Address;
import com.example.eurder.domain.user.PhoneNumber;
import com.example.eurder.domain.user.User;
import com.example.eurder.domain.user.UserRepository;
import com.example.eurder.service.dto.CreateOrderDto;
import com.example.eurder.service.dto.ItemGroupDto;
import com.example.eurder.service.dto.OrderDto;
import com.example.eurder.service.dto.OrdersDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemrepository;
    @Autowired
    private ItemGroupRepository itemGroupRepository;

    @Test
    void createOrder() {
        // Given
        User user = userRepository.save(new User("Sven", "Verboven", "sven@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032", "456986521"),
                "asecret"));
        Item item = itemrepository.save(new Item("PS4", "a gaming console", 500.0, 10));
        ItemGroupDto itemGroupDto = new ItemGroupDto(item.getId(), 1);
        CreateOrderDto createOrderDto = new CreateOrderDto(user.getId(), List.of(itemGroupDto));
        // When
        OrderDto orderDto = orderService.createOrder(createOrderDto);
        // Then
        assertThat(orderDto).isNotNull();
        assertThat(orderDto.getId()).isNotNull();
        assertThat(orderDto.getItemGroups()).hasSize(1);
        assertThat(orderDto.getUser()).isEqualTo(user);
        assertThat(orderDto.getTotalPrice()).isEqualTo(500);
    }

    @Test
    void getOrdersByUser_givenTwoOrdersOfAUser_thenReturnTwoOrders() {
        // Given
        User user = userRepository.save(new User("Sven", "Verboven", "sven@gmail.com",
                new Address("straatje", "30", "3290", "Schaffen", "België"),
                new PhoneNumber("032", "456986521"),
                "asecret"));
        Item item = itemrepository.save(new Item("PS4", "a gaming console", 500.0, 10));
        ItemGroup itemGroup1 = itemGroupRepository.save(new ItemGroup(new CopyOfItem(item), 1, item.getShippingDay(1)));
        Order order1 = new Order(List.of(itemGroup1),user);
        ItemGroup itemGroup2 = itemGroupRepository.save(new ItemGroup(new CopyOfItem(item), 1, item.getShippingDay(1)));
        Order order2 = new Order(List.of(itemGroup2),user);
        orderRepository.saveAll(List.of(order1,order2));
        // When
        OrdersDto ordersByUser = orderService.getOrdersOfUser(user.getId());
        // Then
        assertThat(ordersByUser.getOrders()).hasSize(2);
    }
}
