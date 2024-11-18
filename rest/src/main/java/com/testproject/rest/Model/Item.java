package com.testproject.rest.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    @NotBlank(message = "Название товара обязательно")
    private String name;

    @Column(name = "description", nullable = false, length = 4096)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price = BigDecimal.ZERO;
    ;

    @Column(name = "in_stock", nullable = false)
    private boolean inStock = false;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemSold> sold;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDelivery> deliveries;

    @Column(name = "amount_to_sell")
    private Integer amountToSell;


    public Item(String name, String description, BigDecimal price, boolean inStock, Integer toSell) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
        this.amountToSell = toSell;
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
        if (price == null) price = BigDecimal.ZERO;
        this.price = price;

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Цена товара не может быть меньше 0.");
        }

    }

    public Integer getAmountToSell() {
        int amountAvailableToSell = this.amountToSell;
        if (this.deliveries != null) {
            for (ItemDelivery delivery : this.deliveries) {
                if (delivery != null) {
                    amountAvailableToSell += delivery.getQuantity();
                }
            }
        }
        return amountAvailableToSell;
    }

    public void sell(Integer toSell) {
        if (toSell < 0) {
            throw new IllegalArgumentException("количество не может быть отрицательным");
        }

        if (this.getAmountToSell() < toSell) {
            throw new IllegalArgumentException("Недостаточно товара для продажи");
        }

        if (toSell == 0) setInStock(false);
        this.amountToSell -= toSell;
    }

    public void setAmountToSell(Integer amountToSell) {
        if (amountToSell < 0) {  throw new IllegalArgumentException("количество не может быть отрицательным");}
        if (amountToSell == 0) {setInStock(false);} else setInStock(true);
        this.amountToSell = amountToSell;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
