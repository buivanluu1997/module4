package com.example.product_manager.repository;

import com.example.product_manager.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "Iphone 16", 1500, "Apple"));
        products.add(new Product(2, "SamSung S23", 900, "SamSung"));
        products.add(new Product(3, "Oppo A10 ", 800, "Oppo"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getId() == id){
                products.remove(products.get(i));
                break;
            }
        }
    }

    @Override
    public void update(Product product) {
        for (Product product1 : products) {
            if (product1.getId() == product.getId()){
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setManufacturer(product.getManufacturer());
                break;
            }
        }
    }

    @Override
    public List<Product> searchName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(product);
            }
        }
        return result;
    }
}
