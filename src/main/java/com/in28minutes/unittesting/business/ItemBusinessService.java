package com.in28minutes.unittesting.business;

import com.in28minutes.unittesting.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    public Item retrieveHardcodedItem() {
        return new Item(2,"Gun",1200,100);
    }

}
