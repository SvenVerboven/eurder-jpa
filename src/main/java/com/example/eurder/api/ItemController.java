package com.example.eurder.api;

import com.example.eurder.domain.item.UrgencyIndicator;
import com.example.eurder.service.ItemService;
import com.example.eurder.service.dto.CreateItemDto;
import com.example.eurder.service.dto.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@Valid @RequestBody CreateItemDto createItemDto) {
        return itemService.createItem(createItemDto);
    }

    @PutMapping(path = "/{itemId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto updateItem(@PathVariable long itemId, @Valid @RequestBody CreateItemDto createItemDto) {
        return itemService.updateItem(itemId, createItemDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<ItemDto> getItems(@RequestParam(required = false)UrgencyIndicator urgencyIndicator){
        return itemService.getItems(urgencyIndicator);
    }
}
