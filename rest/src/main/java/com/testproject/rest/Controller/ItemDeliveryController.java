package com.testproject.rest.Controller;

import com.testproject.rest.Model.Item;
import com.testproject.rest.Model.ItemDelivery;
import com.testproject.rest.Service.ItemDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemDeliveryController {

    @Autowired
    private ItemDeliveryService deliveryService;

    @GetMapping("/deliveries")
    public ResponseEntity<List<ItemDelivery>> getAllDeliveries() {
        try {
            if (deliveryService.findAllDeliveries().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(deliveryService.findAllDeliveries(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/deliveries/{id}")
    public ResponseEntity<ItemDelivery> getDeliveryById(@PathVariable("id") Long id) {
        if (deliveryService.findDeliveryById(id) != null) {
            return new ResponseEntity<>(deliveryService.findDeliveryById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/deliveries")
    public ResponseEntity<ItemDelivery> createDelivery(@RequestBody ItemDelivery delivery) {
        try {
            ItemDelivery newItemDelivery = deliveryService.createItemDelivery(delivery);
            return new ResponseEntity<>(newItemDelivery, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/deliveries/{id}")
    public ResponseEntity<ItemDelivery> updateDelivery(@PathVariable("id") Long id, @RequestBody ItemDelivery delivery) {
        ItemDelivery updatedItemDelivery = deliveryService.updateItemDelivery(id, delivery);
        if (updatedItemDelivery != null) {
            return new ResponseEntity<>(updatedItemDelivery, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deliveries/{id}")
    public ResponseEntity<HttpStatus> deleteDelivery(@PathVariable("id") Long id) {
        try {
            deliveryService.deleteDeliveryById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deliveries")
    public ResponseEntity<HttpStatus> deleteAllDeliveries() {
        try {
            deliveryService.deleteAllDeliveries();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
