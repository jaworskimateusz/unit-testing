package com.in28minutes.unittesting.controller;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
//integration test

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ItemRepository repository;

    @Test
    public void contextLoads() throws JSONException {
        String response = this.restTemplate.getForObject("/api/all-items",String.class);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]",response,false);
    }
}
