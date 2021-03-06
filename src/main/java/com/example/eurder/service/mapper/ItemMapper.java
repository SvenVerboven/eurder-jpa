package com.example.eurder.service.mapper;

import com.example.eurder.domain.item.Item;
import com.example.eurder.service.dto.CreateItemDto;
import com.example.eurder.service.dto.ItemDto;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class ItemMapper {

    public static Item toItem(CreateItemDto createItemDto){
        return new Item(
                createItemDto.getName(),
                createItemDto.getDescription(),
                createItemDto.getPrice(),
                createItemDto.getStockAmount()
        );
    }

    public static ItemDto toDto(Item item){
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getStockAmount(),
                item.getUrgencyIndicator()
        );
    }

    public static Collection<ItemDto> toDto(Collection<Item> items){
        return items.stream().map(ItemMapper::toDto).collect(Collectors.toList());
    }
}
