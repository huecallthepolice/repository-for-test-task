package com.testproject.rest.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery")
public class ItemDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_document", nullable = false, length = 255)
    private String nameOfDocument;
    @ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",nullable = false)
    private Item item;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public ItemDelivery(Long id, String nameOfDocument, Item item, Integer quantity) {
        this.id = id;
        this.nameOfDocument = nameOfDocument;
        this.item = item;
        this.quantity = quantity;
    }
    public ItemDelivery() {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNameOfDocument() {
        return nameOfDocument;
    }

    public void setNameOfDocument(String nameOfDocument) {
        this.nameOfDocument = nameOfDocument;
    }
}
