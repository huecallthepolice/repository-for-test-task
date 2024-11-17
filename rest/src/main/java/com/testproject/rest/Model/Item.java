package com.testproject.rest.Model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class Item {

    private Long id;

    @NotBlank(message = "Название товара обязательно")
    @Size(max = 255, message = "Название товара не должно превышать 255 символов")
    private String name;

    @Size(max = 4096, message = "Название товара не должно превышать 255 символов")
    private String description;

    private BigDecimal price;

    private boolean inStock =false;

    public Item( String name, String description, BigDecimal price, boolean inStock) {
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
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
