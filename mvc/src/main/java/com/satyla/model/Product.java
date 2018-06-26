package com.satyla.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private ProductType type;
    @Column
    private Available available;
    @Column
    private int amount;
    @Transient
    private BigDecimal plPrice;

    public Product() {
    }

    public Product(String name, BigDecimal price, ProductType type, Available available, int amount) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.available = available;
        this.amount = amount;
    }

    public Product(Product product) {
        name = product.getName();
        price = product.getPrice();
        type = product.getType();
        available = product.getAvailable();
        amount = product.getAmount();
        id = product.getId();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}
