package com.example.eurder.service;

import com.example.eurder.domain.exceptions.ItemDoesNotExistException;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.ItemRepository;
import com.example.eurder.domain.item.UrgencyIndicator;
import com.example.eurder.service.dto.CreateItemDto;
import com.example.eurder.service.dto.ItemDto;
import com.example.eurder.service.mapper.ItemMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemrepository;

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
        .isInstanceOf(ItemDoesNotExistException.class);
    }

    @Test
    void getItems_givenItemsAndNoUrgencyIndicator_thenReturnAllItemsSortedFromLowStockToHighStock() {
        // Given
        ItemDto mediumStockItem =  ItemMapper.toDto(itemrepository.save(new Item("XBOX", "a gaming console", 350.0, 6)));
        ItemDto highStockItem =  ItemMapper.toDto(itemrepository.save(new Item("WII", "a gaming console", 200.0, 15)));
        ItemDto lowStockItem =  ItemMapper.toDto(itemrepository.save(new Item("PS4", "a gaming console", 500.0, 2)));
        // When
        Collection<ItemDto> items = itemService.getItems(null);
        // Then
        assertThat(items).containsExactly(lowStockItem,mediumStockItem,highStockItem);
    }

    @Test
    void getItems_givenItemsAndUrgencyIndicatorStockLow_thenReturnAllItemsWithStockLow() {
        // Given
        ItemMapper.toDto(itemrepository.save(new Item("XBOX", "a gaming console", 350.0, 6)));
        ItemMapper.toDto(itemrepository.save(new Item("WII", "a gaming console", 200.0, 15)));
        ItemDto lowStockItem =  ItemMapper.toDto(itemrepository.save(new Item("PS4", "a gaming console", 500.0, 2)));
        // When
        Collection<ItemDto> items = itemService.getItems(UrgencyIndicator.STOCK_LOW);
        // Then
        assertThat(items).containsExactly(lowStockItem);
    }

    @Test
    void getItems_givenItemsAndUrgencyIndicatorStockMedium_thenReturnAllItemsWithStockMedium() {
        // Given
        ItemDto mediumStockItem =  ItemMapper.toDto(itemrepository.save(new Item("XBOX", "a gaming console", 350.0, 6)));
        ItemMapper.toDto(itemrepository.save(new Item("WII", "a gaming console", 200.0, 15)));
        ItemMapper.toDto(itemrepository.save(new Item("PS4", "a gaming console", 500.0, 2)));
        // When
        Collection<ItemDto> items = itemService.getItems(UrgencyIndicator.STOCK_MEDIUM);
        // Then
        assertThat(items).containsExactly(mediumStockItem);
    }

    @Test
    void getItems_givenItemsAndUrgencyIndicatorStockHigh_thenReturnAllItemsWithStockHigh() {
        // Given
        ItemMapper.toDto(itemrepository.save(new Item("XBOX", "a gaming console", 350.0, 6)));
        ItemDto highStockItem =  ItemMapper.toDto(itemrepository.save(new Item("WII", "a gaming console", 200.0, 15)));
        ItemMapper.toDto(itemrepository.save(new Item("PS4", "a gaming console", 500.0, 2)));
        // When
        Collection<ItemDto> items = itemService.getItems(UrgencyIndicator.STOCK_HIGH);
        // Then
        assertThat(items).containsExactly(highStockItem);
    }

    @Test
    void getItem_givenItemAndItemId_thenReturnItem() {
        // Given
        ItemDto expected = ItemMapper.toDto(itemrepository.save(new Item("XBOX", "a gaming console", 350.0, 6)));
        // When
        ItemDto actual = itemService.getItem(expected.getId());
        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getItem_givenWrongItemId_thenThrowItemDoesNotExistException() {
        // Given
        long id = 100;
        // When
        // Then
        assertThatThrownBy(()-> itemService.getItem(id))
        .isInstanceOf(ItemDoesNotExistException.class);
    }

    @AfterEach
    void tearDown() {
        itemrepository.deleteAll();
    }
}
