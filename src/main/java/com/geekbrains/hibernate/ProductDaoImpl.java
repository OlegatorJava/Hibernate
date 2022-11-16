package com.geekbrains.hibernate;

import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product byId(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> productList =
                    session.createQuery("select p from Product p")
                    .getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
             Product product = session.get(Product.class, id);
            session.remove(product);
            session.getTransaction().commit();

        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            //product.setCost(200);  можно изменить, а можно добавить без изменений...я так понял
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }

}