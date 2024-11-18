package com.testproject.rest.Service;

import com.testproject.rest.Model.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<Item>();
    long idNow = 1;

    public List<Item> findAll() {
        return items;
    }



    public Item findById(Long id) {
        return items.stream().filter(item -> id.equals(item.getId())).findAny().orElse(null);

    }


    public Item createItem(Item item) {
        Item newItem = new Item();
        newItem.setId(idNow++);
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setPrice(item.getPrice() != null ? item.getPrice() : BigDecimal.ZERO);
        newItem.setInStock(item.isInStock());
        items.add(newItem);
        return newItem;
    }

    public Item updateItem(Long id, Item item) {
        Item oldItem = findById(id);
        if (oldItem != null) {
            oldItem.setName(item.getName());
            oldItem.setDescription(item.getDescription());
            oldItem.setPrice(item.getPrice() != null ? item.getPrice() : BigDecimal.ZERO);
            oldItem.setInStock(item.isInStock());
            return oldItem;
        }
        return null;
    }

    public void deleteById(Long id) {
        items.removeIf(item -> id.equals(item.getId()));
    }

    public void deleteAll() {
        items.removeAll(items);
    }


}

