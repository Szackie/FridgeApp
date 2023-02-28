package io.github.mat3e.product;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")

public class Product {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private Integer id;
    private String text;
    private boolean done;
    private Integer fridge_id;

    public Product(){}

    public Product(Integer id, String text, boolean done, Integer fridge_id) {
        this.id = id;
        this.text = text;
        this.done = done;
        this.fridge_id=fridge_id;
    }
   public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getFridge_id() {
        return fridge_id;
    }

    public void setFridge_id(Integer fridge_id) {
        this.fridge_id = fridge_id;
    }
}
