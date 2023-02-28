package io.github.mat3e.fridge;

import io.github.mat3e.product.Product;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fridges")

public class Fridge {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int fridge_id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "fridge_id")
    private List<Product> productList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setFridge_id(int id) {
        this.fridge_id = id;
    }

    public int getFridge_id() {
        return fridge_id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}


