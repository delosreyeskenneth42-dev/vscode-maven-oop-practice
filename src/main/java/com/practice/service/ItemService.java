
package com.practice.service;

import com.practice.Item;
import com.practice.repository.ItemRepository;

import java.util.List;

public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void registerItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException(
                    "Item cannot be null.");
        }

        if (item.getName() == null || item.getName().isBlank()) {
            throw new IllegalArgumentException(
                    "Item name cannot be blank.");
        }

        itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(int id) {
        return itemRepository.findById(id);
    }

    public void updateItem(int id, String newName, String newDescription){
        Item item = itemRepository.findById(id);

        if(item == null){
            throw new IllegalArgumentException("The ID you search doesn't exist!");
        }
        item.setName(newName);
        item.setDescription(newDescription);
    }

    public boolean deleteItem(int id){
        return itemRepository.deleteById(id);
    }
}
