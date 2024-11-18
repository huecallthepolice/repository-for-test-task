package com.testproject.rest.Service;

import com.testproject.rest.Model.Item;
import com.testproject.rest.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }


    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item item) {
        if (itemRepository.existsById(id)) {
            item.setId(id);
            return itemRepository.save(item);
        }
        return null;
    }

    public void deleteById(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        }
    }

    public void deleteAll() {
        itemRepository.deleteAll();

    }

    public List<Item> sortingAndFiltering(String name, BigDecimal price, BigDecimal minPrice, BigDecimal maxPrice,
                                          Boolean inStock, String sortBy, int limit) {


        if (name != null && name.length() > 255) {
            throw new IllegalArgumentException("Название товара обязательно  и не должно превышать 255 символов");
        }

        if (price != null && price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Цена не может быть меньше нуля");
        }

        if (minPrice != null && minPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Цена не может быть меньше нуля");
        }

        if (maxPrice != null && maxPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Цена не может быть меньше нуля");
        }

        if (minPrice != null && maxPrice != null && minPrice.compareTo(maxPrice) > 0) {
            throw new IllegalArgumentException("Максимальная Цена не может быть меньше минимальной");
        }

        if (limit < 0) {
            throw new IllegalArgumentException("Лимит не может быть отрицательным");
        }
        List<Item> items = itemRepository.findAll();

        if (name != null && !name.isEmpty()) {
            items = items.stream()
                    .filter(item -> item.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }


        if (price != null) {
            items = items.stream()
                    .filter(item -> item.getPrice().compareTo(price) == 0)
                    .collect(Collectors.toList());
        }

        if (minPrice != null ) {
            items = items.stream()
                    .filter(item -> item.getPrice().compareTo(minPrice) > 0)
                    .collect(Collectors.toList());
        }

        if (maxPrice != null ) {
            items = items.stream()
                    .filter(item -> item.getPrice().compareTo(maxPrice) < 0)
                    .collect(Collectors.toList());
        }

        if (inStock != null) {
            items = items.stream()
                    .filter(item -> item.isInStock() == inStock)
                    .collect(Collectors.toList());
        }


        if ("name".equalsIgnoreCase(sortBy)) {
            items.sort(Comparator.comparing(Item::getName));
        } else if ("price".equalsIgnoreCase(sortBy)) {
            items.sort(Comparator.comparing(Item::getPrice));
        }

        if (limit > 0 && limit < items.size()) {
            items = items.subList(0, limit);
        }

        return items;
    }
}

