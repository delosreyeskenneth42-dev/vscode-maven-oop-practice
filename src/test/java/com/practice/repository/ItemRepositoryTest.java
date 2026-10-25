package com.practice.repository;

import org.junit.Test;
import com.practice.Item;
import org.junit.Assert;

public class ItemRepositoryTest {
    
    ItemRepository i = new ItemRepository();
    Item it = new Item(101, "Wallet", "Black leather wallet");
    
    @Test
    public void findByIdReturnsItemWhenIdExists(){
        
        i.save(it);
        Item r = i.findById(101);

        Assert.assertSame(it, r);
    }
    @Test
    public void findByIdReturnsNullWhenIdDoesNotExist(){
        ItemRepository a = new ItemRepository();

        Item q = a.findById(101);
        
        Assert.assertNull(q);
    }
}
