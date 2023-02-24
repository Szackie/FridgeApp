package io.github.mat3e.fridge;

import io.github.mat3e.HibernateUtil;
import io.github.mat3e.product.Product;

import java.util.List;

public class FridgeRepository {
        public Fridge addFridge(Fridge newFridge) {
            var session = HibernateUtil.getSessionFactory().openSession();
            var transaction = session.beginTransaction();

            session.persist("fridges", newFridge);

            transaction.commit();
            session.close();
            return newFridge;
        }

//        public void deleteFridge(Integer id) {
//            var session = HibernateUtil.getSessionFactory().openSession();
//            var transaction = session.beginTransaction();
//
//            var product = session.load(Fridge.class, id);
//            session.delete("fridges", );
//
//
//            transaction.commit();
//            session.close();
//        }

        public List<Fridge> findAll() {
            var session = HibernateUtil.getSessionFactory().openSession();
            var transaction = session.beginTransaction();
            var result = session.createQuery("from Fridge ", Fridge.class).list();
            transaction.commit();
            session.close();

            return result;
        }


    }


