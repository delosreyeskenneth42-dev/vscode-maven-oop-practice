
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

    public Item findById(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (id == items.get(i).getId()) {
                return items.get(i);
            }
        }
        return null;
    }

    public boolean deleteById(int id){
        Item i = findById(id);

        if(i == null){
            return false;
        }
        items.remove(i);

        return true;
    }
}
