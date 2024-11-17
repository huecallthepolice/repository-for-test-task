package com.testproject.rest.Service;

import com.testproject.rest.Model.Item;
import com.testproject.rest.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
      if(itemRepository.existsById(id)) {
          item.setId(id);
          return itemRepository.save(item);
      }
        return null;
    }

    public void deleteById(Long id) {
        if(itemRepository.existsById(id)) {itemRepository.deleteById(id);};
    }

    public void deleteAll() {
       itemRepository.deleteAll();

    }


}

