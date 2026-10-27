
package com.practice.service;

import com.practice.Item;
import com.practice.repository.ItemRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;

public class ItemServiceTest {

    private ItemRepository repository;
    private ItemService service;

    Item item = new Item(101, "Wallet", "Black leather wallet");

    @Before
    public void setUp() {
        repository = new ItemRepository();
        service = new ItemService(repository);
    }

    @Test
    public void shouldRegisterValidItem() {
        Item item = new Item(1, "Wallet", "Black leather wallet");

        service.registerItem(item);

        assertEquals(1, service.getAllItems().size());
        assertEquals("Wallet", service.getAllItems().get(0).getName());
    }

    @Test
    public void shouldRejectBlankItemName() {
        Item item = new Item(2, "   ", "An item with a blank name");

        try {
            service.registerItem(item);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            // Expected: the service rejects a blank name.
        }

        assertEquals(0, service.getAllItems().size());
    }

    @Test
    public void shouldRejectNullItem() {
        try {
            service.registerItem(null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            // Expected: the service rejects a null item.
        }

        assertEquals(0, service.getAllItems().size());
    }

    @Test
    public void shouldReturnItemWhenIdExists() {
        service.registerItem(item);

        Item r = service.getItemById(101);
        Assert.assertSame(item, r);
    }

    @Test
    public void shouldUpdateExistingItem(){
        Item i = new Item(101, "Wallet", "Black leather wallet");

        service.registerItem(i);
        
        service.updateItem(101, "Brown Wallet", "Black leather wallet");

        service.getItemById(101);

        Assert.assertEquals("Brown Wallet", i.getName());
    }
}
