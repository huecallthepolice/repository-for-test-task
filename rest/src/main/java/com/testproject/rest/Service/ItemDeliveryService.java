package com.testproject.rest.Service;

import com.testproject.rest.Model.ItemDelivery;
import com.testproject.rest.Repository.ItemDeliveryRepository;
import com.testproject.rest.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDeliveryService {
   @Autowired
    private ItemDeliveryRepository itemDeliveryRepository;

   @Autowired
   private ItemRepository itemRepository;
    public List<ItemDelivery> findAllDeliveries() {
        return itemDeliveryRepository.findAll();
    }

    public ItemDelivery findDeliveryById(Long id) {
        return itemDeliveryRepository.findById(id).orElse(null);
    }


    public ItemDelivery createItemDelivery(ItemDelivery delivery) {
        if (!itemRepository.existsById(delivery.getItem().getId())) { throw new IllegalArgumentException("Товар с id="+delivery.getItem().getId()+"не найден"); }
        if (delivery.getQuantity() <=0) { throw new IllegalArgumentException("Количество товара в доставке должно быть больше чем 0"); }

        return itemDeliveryRepository.save(delivery);
    }

    public ItemDelivery updateItemDelivery(Long id, ItemDelivery delivery) {
        if (itemDeliveryRepository.existsById(id)) {
            delivery.setId(id);
            return itemDeliveryRepository.save(delivery);
        }
        return null;
    }

    public void deleteDeliveryById(Long id) {
        if (itemDeliveryRepository.existsById(id)) {
            itemDeliveryRepository.deleteById(id);
        }
    }

    public void deleteAllDeliveries() {
        itemDeliveryRepository.deleteAll();

    }
}
