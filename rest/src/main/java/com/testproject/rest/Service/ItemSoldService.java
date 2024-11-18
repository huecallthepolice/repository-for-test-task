package com.testproject.rest.Service;

import com.testproject.rest.Model.Item;
import com.testproject.rest.Model.ItemDelivery;
import com.testproject.rest.Model.ItemSold;
import com.testproject.rest.Repository.ItemRepository;
import com.testproject.rest.Repository.ItemSoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemSoldService {
    @Autowired
    private ItemSoldRepository itemSoldRepository;

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemService itemService;

    public List<ItemSold> findAllSales() {
        return itemSoldRepository.findAll();
    }

    public ItemSold findSoldById(Long id) {
        return itemSoldRepository.findById(id).orElse(null);
    }


    public ItemSold createItemSale(ItemSold sale) {
        if (!itemRepository.existsById(sale.getItem().getId())) {
            throw new IllegalArgumentException("Товар с id=" + sale.getItem().getId() + "не найден");
        }
        if (sale.getQuantity() <= 0) {
            throw new IllegalArgumentException("Количество проданного товара должно быть больше чем 0");
        }


        Item item = itemRepository.findById(sale.getItem().getId()).orElse(null);
        item.sell(sale.getQuantity());
        if(item.getAmountToSell().equals(0)) item.setInStock(false);

        itemService.updateItem(sale.getItem().getId(), item);
        return itemSoldRepository.save(sale);
    }

    public ItemSold updateItemSold(Long id, ItemSold delivery) {
        if (itemSoldRepository.existsById(id)) {
            delivery.setId(id);
            return itemSoldRepository.save(delivery);
        }
        return null;
    }

    public void deleteSoldById(Long id) {
        if (itemSoldRepository.existsById(id)) {
            itemSoldRepository.deleteById(id);
        }
    }

    public void deleteAllSold() {
        itemSoldRepository.deleteAll();

    }
}


