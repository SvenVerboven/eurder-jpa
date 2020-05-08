package com.example.eurder.api;

import com.example.eurder.domain.Views;
import com.example.eurder.service.OrderService;
import com.example.eurder.service.dto.CreateOrderDto;
import com.example.eurder.service.dto.OrderDto;
import com.example.eurder.service.dto.OrdersDto;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
//    @CrossOrigin(origins = "https://order-sven-verboven-gui.herokuapp.com")
    public OrderDto createOrder(@RequestBody CreateOrderDto createOrderDto){
        return orderService.createOrder(createOrderDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(Views.Public.class)
//    @CrossOrigin(origins = "https://order-sven-verboven-gui.herokuapp.com")
    public OrdersDto getOrdersOfUser(@RequestParam long userId){
        return orderService.getOrdersOfUser(userId);
    }
}
