
package com.practice.repository;

import com.practice.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private final List<Item> items = new ArrayList<>();

    public void save(Item item) {
        items.add(item);
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }
}
