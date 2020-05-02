package com.example.eurder.api;

import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.ItemRepository;
import com.example.eurder.service.dto.CreateItemDto;
import com.example.eurder.service.dto.ItemDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTest {

    public static final String ITEMS_PATH = "/items";
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ItemRepository itemrepository;


    @Test
    void createItem() {
        // Given
        CreateItemDto createItemDto = new CreateItemDto("PS4", "a gaming console", 500.0, 10);
        // When
        // Then
        webTestClient.post()
                .uri(ITEMS_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createItemDto), CreateItemDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(ItemDto.class)
                .value(itemDto -> assertThat(itemDto.getId()).isNotNull())
                .value(itemDto -> assertThat(itemDto.getName()).isEqualTo(createItemDto.getName()))
                .value(itemDto -> assertThat(itemDto.getDescription()).isEqualTo(createItemDto.getDescription()))
                .value(itemDto -> assertThat(itemDto.getPrice()).isEqualTo(createItemDto.getPrice()))
                .value(itemDto -> assertThat(itemDto.getStockAmount()).isEqualTo(createItemDto.getStockAmount()));
    }

    @Test
    void updateItem() {
        // Given
        long itemId = itemrepository.save(new Item("PS4", "a gaming console", 500.0, 10)).getId();
        CreateItemDto createItemDto = new CreateItemDto("XBOX", "the best gaming console", 350.0, 50);
        // When
        // Then
        webTestClient.put()
                .uri(ITEMS_PATH + "/" + itemId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(createItemDto),CreateItemDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(ItemDto.class)
                .value(itemDto -> assertThat(itemDto).isNotNull());
    }

    @AfterEach
    void tearDown() {
        itemrepository.deleteAll();
    }
}
