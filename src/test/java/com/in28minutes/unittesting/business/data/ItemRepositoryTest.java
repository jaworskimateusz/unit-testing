package com.in28minutes.unittesting.business.data;

import com.in28minutes.unittesting.model.Item;
import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest //this is used to test repository, if we have logic of course
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void findAll_size() {
        List<Item> items = itemRepository.findAll();
        assertEquals(3,items.size());
    }
}
