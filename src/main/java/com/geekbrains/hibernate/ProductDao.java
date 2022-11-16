package com.geekbrains.hibernate;

import java.util.List;

public interface ProductDao {

    Product byId(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
