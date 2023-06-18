package fridge.szackie.fridge;

import fridge.szackie.HibernateUtil;
import fridge.szackie.product.Product;
import fridge.szackie.product.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FridgeRepository {

    List<Product> productList = new ArrayList<>();
    ProductRepository productRepository = new ProductRepository();

    public Fridge addFridge(Fridge newFridge) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var allFridges = findAll();
        for (Fridge fridge : allFridges) {
            if (fridge.getName().equals(newFridge.getName()))
                return fridge;
        }
        for (Product product : productRepository.findAll()) {
            if (product.getFridge_id() == newFridge.getFridge_id())
                productList.add(product);
        }
        newFridge.setProductList(productList);

        session.persist("fridges", newFridge);

        transaction.commit();
        session.close();
        return newFridge;
    }

    public void deleteUnusedFridge() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        for (Fridge fridge : findAll()) {
            if (fridge.getProductList().isEmpty()) {
                var id = fridge.getFridge_id();
                var emptyFridge = session.load(Fridge.class, id);
                session.delete("fridges", emptyFridge);
            }
        }
        transaction.commit();
        session.close();
    }

    public List<Fridge> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createQuery("from Fridge ", Fridge.class).list();
        transaction.commit();
        session.close();

        return result;
    }

    public Optional<Fridge> findById(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = Optional.ofNullable(session.get(Fridge.class, id));

        transaction.commit();
        session.close();
        return result;
    }

}


