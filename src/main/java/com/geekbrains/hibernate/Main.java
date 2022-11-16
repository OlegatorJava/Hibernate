package com.geekbrains.hibernate;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try{
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            Product product = new Product("Coffee", 76);
            productDao.saveOrUpdate(product);
            productDao.byId(1L);
            System.out.println(productDao.findAll());
            productDao.deleteById(5L);
            System.out.println(productDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sessionFactoryUtils.shutdown();
        }

    }
}
