package com.testproject.rest.Controller;

import com.testproject.rest.Model.ItemDelivery;
import com.testproject.rest.Model.ItemSold;
import com.testproject.rest.Service.ItemSoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class ItemSoldController {

    @Autowired
    private ItemSoldService itemSoldService;

    @GetMapping("/sales")
    public ResponseEntity<List<ItemSold>> getAllSales() {
        try {
            if (itemSoldService.findAllSales().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(itemSoldService.findAllSales(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<ItemSold> getSaleyById(@PathVariable("id") Long id) {
        if (itemSoldService.findSoldById(id) != null) {
            return new ResponseEntity<>(itemSoldService.findSoldById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/sales")
    public ResponseEntity<ItemSold> createSale(@RequestBody ItemSold sale) {
        try {
            ItemSold newItemSold = itemSoldService.createItemSale(sale);
            return new ResponseEntity<>(newItemSold, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/sales/{id}")
    public ResponseEntity<ItemSold> updateSale(@PathVariable("id") Long id, @RequestBody ItemSold sale) {
        ItemSold updatedItemSale = itemSoldService.updateItemSold(id, sale);
        if (updatedItemSale != null) {
            return new ResponseEntity<>(updatedItemSale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<HttpStatus> deleteSale(@PathVariable("id")Long id) {
        try {
            itemSoldService.deleteSoldById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/sales")
    public ResponseEntity<HttpStatus> deleteAllSales() {
        try {
            itemSoldService.deleteAllSold();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}


