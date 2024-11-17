package com.testproject.rest.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false, length = 255)
    @NotBlank(message = "Название товара обязательно")
    private String name;

    @Column(name="description",nullable = false, length = 4096)
    private String description;

    @Column(name="price",nullable = false)
    private BigDecimal price= BigDecimal.ZERO;;

    @Column(name="in_stock", nullable = false)
    private boolean inStock = false;

    public Item(String name, String description, BigDecimal price, boolean inStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 255) {
            throw new IllegalArgumentException("Название товара обязательно и не может превышать 255 символов.");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 4096) {
            throw new IllegalArgumentException("Описание товара не может превышать 4096 символов.");
        }
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price == null)price= BigDecimal.ZERO;
        this.price = price;

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Цена товара не может быть меньше 0.");
        }

    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
