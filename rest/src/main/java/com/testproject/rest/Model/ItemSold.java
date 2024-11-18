package com.testproject.rest.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "sold")
public class ItemSold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name_of_document",nullable = false, length = 255)
    private String nameOfDocument;

    @ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id", nullable = false)
    private Item item;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name ="cost", nullable = false )
    private BigDecimal cost;

    public ItemSold(Long id, String nameOfDocument, Item item, Integer quantity, BigDecimal cost) {
        this.id = id;
        this.nameOfDocument = nameOfDocument;
        this.item = item;
        this.quantity = quantity;
        this.cost = cost;
    }

    public ItemSold() {

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(String nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = item.getPrice().multiply(BigDecimal.valueOf(this.quantity));
//        if (cost == null || cost.equals(BigDecimal.ZERO)) {
//            this.cost = item.getPrice().multiply(BigDecimal.valueOf(this.quantity));
//        } else {
//            this.cost = cost;
//        }
    }
}
