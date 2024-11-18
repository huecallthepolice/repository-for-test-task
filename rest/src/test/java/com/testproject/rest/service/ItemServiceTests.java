package com.testproject.rest.service;



import com.testproject.rest.Model.Item;
import com.testproject.rest.Service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemServiceTests {

    @Autowired
    private ItemService itemService;

    @Before
    public void setUp() {
        itemService.createItem(new Item("first","description1", new BigDecimal(17.95),false));
        itemService.createItem(new Item("second","description2", new BigDecimal(13.00),true));
        itemService.createItem(new Item("third","description3", new BigDecimal(27.95),true));
        itemService.createItem(new Item("fourth","description4", new BigDecimal(19.95),false));
    }

    @Test
    public void testGetAll() throws Exception {
        List<Item> result= itemService.findAll();

        assertEquals(8, result.size());
    }

    @Test
    public void testGetItemByIDExist() throws Exception {
        Item result =itemService.findById(2L);

        assertEquals("second", result.getName());
        assertEquals("description2", result.getDescription());
        assertEquals(new BigDecimal(13.00), result.getPrice());
    }


    @Test
    public void testGetItemByIDNotExist() throws Exception {
        Item result =itemService.findById(6L);

       assertNull(result);
    }

}
