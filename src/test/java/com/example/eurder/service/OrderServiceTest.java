package com.example.eurder.service;

import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.Itemrepository;
import com.example.eurder.domain.user.Address;
import com.example.eurder.domain.user.PhoneNumber;
import com.example.eurder.domain.user.User;
import com.example.eurder.domain.user.UserRepository;
import com.example.eurder.service.dto.CreateOrderDto;
import com.example.eurder.service.dto.ItemGroupDto;
import com.example.eurder.service.dto.OrderDto;
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
    private UserRepository userRepository;
    @Autowired
    private Itemrepository itemrepository;

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
}