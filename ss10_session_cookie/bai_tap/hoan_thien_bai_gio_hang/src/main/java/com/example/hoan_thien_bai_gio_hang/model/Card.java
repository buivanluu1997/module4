package com.example.hoan_thien_bai_gio_hang.model;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private Map<Product, Integer> productMap = new HashMap<>();

    public Card() {
    }
    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addToCard(Product product) {
        if (productMap.containsKey(product)) {
            Integer count = productMap.get(product);
            productMap.replace(product, count + 1);
        } else {
            productMap.put(product, 1);
        }
    }

    public void increaseQuantity(Product product) {
        if (productMap.containsKey(product)) {
            Integer count = productMap.get(product);
            productMap.replace(product, count + 1);
        }
    }

    public void decreaseQuantity(Product product) {
        if (productMap.containsKey(product)) {
            Integer count = productMap.get(product);
            if (count > 1) {
                productMap.replace(product, count - 1);
            } else {
                productMap.remove(product);
            }
        }
    }

    public double totalAmount(){
        double sum = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            sum += entry.getValue() * entry.getKey().getPrice();
        }
        return sum;
    }
}
