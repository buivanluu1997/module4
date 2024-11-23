package com.example.product_manager_validete_session.dto;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private Map<ProductDto, Integer> card = new HashMap<>();

    public Card() {
    }

    public Map<ProductDto, Integer> getCard() {
        return card;
    }

    public void setCard(Map<ProductDto, Integer> card) {
        this.card = card;
    }

    public void addCard(ProductDto productDto){
        if(card.containsKey(productDto)){
            card.put(productDto, card.get(productDto)+1);
        } else {
            card.put(productDto, 1);
        }
    }

    public void increaseCard(ProductDto productDto){
        if(card.containsKey(productDto)){
            card.replace(productDto, card.get(productDto)+1);
        }
    }

    public void decreaseCard(ProductDto productDto){
        if(card.containsKey(productDto)){
            if (card.get(productDto) > 1){
                card.replace(productDto, card.get(productDto)-1);
            } else {
                card.remove(productDto);
            }
        }
    }

    public double totalCard(){
        double sum = 0;
        for (Map.Entry<ProductDto, Integer> entry : card.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }
}
