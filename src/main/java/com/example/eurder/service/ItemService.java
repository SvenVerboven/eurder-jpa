package com.example.eurder.service;

import com.example.eurder.domain.exceptions.ItemDoesNotExistException;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.ItemRepository;
import com.example.eurder.service.dto.CreateItemDto;
import com.example.eurder.service.dto.ItemDto;
import com.example.eurder.service.mapper.ItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemService {

    private final Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemrepository;

    public ItemService(ItemRepository itemrepository) {
        this.itemrepository = itemrepository;
    }


    public ItemDto createItem(CreateItemDto createItemDto) {
        logger.info("Item is created");
        return ItemMapper.toDto(itemrepository.save(ItemMapper.toItem(createItemDto)));
    }

    public ItemDto updateItem(long itemId, CreateItemDto createItemDto) {
        if(itemrepository.findById(itemId).isEmpty()){
            throw new ItemDoesNotExistException(itemId);
        }
        Item item = itemrepository.findById(itemId).get();
        item.setName(createItemDto.getName());
        item.setDescription(createItemDto.getDescription());
        item.setPrice(createItemDto.getPrice());
        item.setStockAmount(createItemDto.getStockAmount());
        logger.info("Updated item");
        return ItemMapper.toDto(item);
    }
}
