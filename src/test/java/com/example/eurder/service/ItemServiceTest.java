package com.example.eurder.service;

import com.example.eurder.service.dto.CreateItemDto;
import com.example.eurder.service.dto.ItemDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Test
    void createItem() {
        // Given
        CreateItemDto createItemDto = new CreateItemDto("PS4","a gaming console",500.0,10);
        // When
        ItemDto itemDto = itemService.createItem(createItemDto);
        // Then
        assertThat(itemDto).isNotNull();
        assertThat(itemDto.getId()).isNotNull();
        assertThat(itemDto.getName()).isEqualTo(createItemDto.getName());
        assertThat(itemDto.getDescription()).isEqualTo(createItemDto.getDescription());
        assertThat(itemDto.getPrice()).isEqualTo(createItemDto.getPrice());
        assertThat(itemDto.getStockAmount()).isEqualTo(createItemDto.getStockAmount());
    }
}