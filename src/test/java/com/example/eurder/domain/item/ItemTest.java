package com.example.eurder.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getShippingDate_whenStockAmountIsBiggerOrEqualThenOrderedAmount_thenShippingDateIsTodayPlusOneDay() {
        // Given
        Item item = new Item("PS4", "a gaming console", 500.0, 10);
        int orderedAmountOfItems = 10;
        // When
        LocalDate shippingDay = item.getShippingDay(orderedAmountOfItems);
        // Then
        Assertions.assertThat(shippingDay).isEqualTo(LocalDate.now().plusDays(1));
    }
    @Test
    void getShippingDate_whenStockAmountIsSmallerThenOrderedAmount_thenShippingDateIsTodayPlusSevenDays() {
        // Given
        Item item = new Item("PS4", "a gaming console", 500.0, 10);
        int orderedAmountOfItems = 11;
        // When
        LocalDate shippingDay = item.getShippingDay(orderedAmountOfItems);
        // Then
        Assertions.assertThat(shippingDay).isEqualTo(LocalDate.now().plusDays(7));
    }
}