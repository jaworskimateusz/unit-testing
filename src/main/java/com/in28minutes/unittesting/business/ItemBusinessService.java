package com.in28minutes.unittesting.business;

import com.in28minutes.unittesting.model.Item;
import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem() {
        return new Item(2,"Gun",1200,100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = itemRepository.findAll();
        items.forEach(item -> System.out.println(item.getValue()));
        items.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
        items.forEach(item -> System.out.println(item.getValue()));
        return items;
    }

}
