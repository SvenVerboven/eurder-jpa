package com.example.eurder.service;

import com.example.eurder.domain.exceptions.ItemDoesNotExistException;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.Itemrepository;
import com.example.eurder.service.dto.CreateItemDto;
import com.example.eurder.service.dto.ItemDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    private Itemrepository itemrepository;

    @Test
    void createItem() {
        // Given
        CreateItemDto createItemDto = new CreateItemDto("PS4", "a gaming console", 500.0, 10);
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

    @Test
    void updateItem_givenItemId_thenReturnItem() {
        // Given
        Item item = itemrepository.save(new Item("PS4", "a gaming console", 500.0, 10));
        CreateItemDto createItemDto = new CreateItemDto("XBOX", "the best gaming console", 350.0, 50);
        // When
        ItemDto itemDto = itemService.updateItem(item.getId(), createItemDto);
        // Then
        assertThat(itemDto).isNotNull();
        assertThat(itemDto.getId()).isNotNull();
        assertThat(itemDto.getName()).isEqualTo(createItemDto.getName());
        assertThat(itemDto.getDescription()).isEqualTo(createItemDto.getDescription());
        assertThat(itemDto.getPrice()).isEqualTo(createItemDto.getPrice());
        assertThat(itemDto.getStockAmount()).isEqualTo(createItemDto.getStockAmount());
    }

    @Test
    void updateItem_givenWrongItemId_thenThrowItemDoesNotExistException() {
        // Given
        long itemId = 100;
        CreateItemDto createItemDto = new CreateItemDto("XBOX", "the best gaming console", 350.0, 50);
        // When
        // Then
        assertThatThrownBy(()-> itemService.updateItem(itemId, createItemDto))
        .isInstanceOf(ItemDoesNotExistException.class)
        .hasMessage("Item with id: " + itemId + " does not exist");
    }

    @AfterEach
    void tearDown() {
        itemrepository.deleteAll();
    }
}