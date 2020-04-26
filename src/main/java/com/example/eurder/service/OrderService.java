package com.example.eurder.service;

import com.example.eurder.domain.exceptions.ItemDoesNotExistException;
import com.example.eurder.domain.exceptions.UserDoesNotExistException;
import com.example.eurder.domain.item.CopyOfItem;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.Itemrepository;
import com.example.eurder.domain.itemgroup.ItemGroup;
import com.example.eurder.domain.itemgroup.ItemGroupRepository;
import com.example.eurder.domain.order.Order;
import com.example.eurder.domain.order.OrderRepository;
import com.example.eurder.domain.user.User;
import com.example.eurder.domain.user.UserRepository;
import com.example.eurder.service.dto.CreateOrderDto;
import com.example.eurder.service.dto.ItemGroupDto;
import com.example.eurder.service.dto.OrderDto;
import com.example.eurder.service.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final Itemrepository itemrepository;
    private final ItemGroupRepository itemGroupRepository;

    @Autowired

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, Itemrepository itemrepository, ItemGroupRepository itemGroupRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.itemrepository = itemrepository;
        this.itemGroupRepository = itemGroupRepository;
    }


    public OrderDto createOrder(CreateOrderDto createOrderDto) {
        logger.info("Order is created");
        return OrderMapper.toDto(orderRepository.save(new Order(getItemGroups(createOrderDto.getOrderedItems()),
                        getUser(createOrderDto.getUserId()))));
    }

    private List<ItemGroup> getItemGroups(List<ItemGroupDto> itemGroupDtos) {
        List<ItemGroup> itemGroups = new ArrayList<>();
        for(ItemGroupDto itemGroupDto: itemGroupDtos){
            Item item = getItem(itemGroupDto.getItemId());
            CopyOfItem copyOfItem = new CopyOfItem(item);
            int amountOfItems = itemGroupDto.getAmountOfItems();
            LocalDate shippingDate = item.getShippingDay(amountOfItems);
            ItemGroup itemGroup = itemGroupRepository.save(new ItemGroup(copyOfItem,amountOfItems,shippingDate));
            itemGroups.add(itemGroup);
            decreaseStockAmountOfItem(item, amountOfItems);
        }
        return itemGroups;
    }

    private void decreaseStockAmountOfItem(Item item, int amountOfItems) {
        item.decreaseStockAmount(amountOfItems);
    }

    private Item getItem(long itemId) {
        if(itemrepository.findById(itemId).isEmpty()){
            throw new ItemDoesNotExistException(itemId);
        }
        return itemrepository.findById(itemId).get();
    }

    private User getUser(long userId) {
        if(userRepository.findById(userId).isEmpty()){
            throw new UserDoesNotExistException(userId);
        }
        return userRepository.findById(userId).get();
    }
}
