package com.example.quan_ly_khach_hang_orm.repository;

import com.example.quan_ly_khach_hang_orm.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Transactional
    @Override
    public void update(Product product) {
        Product product1 = findById(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setManufacturer(product.getManufacturer());
        entityManager.merge(product1);
    }

    @Override
    public List<Product> searchName(String name) {
        String searchName = "select p from Product p where p.name like :name";
        TypedQuery<Product> query = entityManager.createQuery(searchName, Product.class);
        query.setParameter("name", "%" + name + "%");
        List<Product> products = query.getResultList();
        System.out.println(products.size());
        return products;
    }
}
