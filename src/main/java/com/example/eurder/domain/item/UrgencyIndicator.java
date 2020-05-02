package com.example.eurder.domain.item;

public enum UrgencyIndicator {
    STOCK_LOW,
    STOCK_MEDIUM,
    STOCK_HIGH;


    public static UrgencyIndicator getUrgencyIndicator(int stockAmount){
        if(stockAmount < 5){
            return STOCK_LOW;
        }
        if(stockAmount < 10){
            return STOCK_MEDIUM;
        }
        return STOCK_HIGH;
    }

}
