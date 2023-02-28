package io.github.mat3e.product;

import io.github.mat3e.HibernateUtil;

import java.util.List;

public class ProductRepository {


    public Product addProduct(Product newProduct) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        session.persist("products", newProduct);

        transaction.commit();
        session.close();
        return newProduct;
    }

    public Product toggleProduct(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var product = session.load(Product.class, id);
        product.setDone(!product.isDone());

        transaction.commit();
        session.close();
        return product;

    }

    public void deleteProduct(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var product = session.load(Product.class, id);
        session.delete("products", product);


        transaction.commit();
        session.close();
    }

    public List<Product> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.createQuery("from Product", Product.class).list();
        transaction.commit();
        session.close();

        return result;
    }


}
