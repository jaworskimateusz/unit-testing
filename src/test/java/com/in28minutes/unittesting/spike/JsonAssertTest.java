package com.in28minutes.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class JsonAssertTest {

    private String actualResponse;

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = this.actualResponse;
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
        //third parameter means that is strict check,
        //example: if third parameter is false I can add a space between key-value pairs
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = this.actualResponse;
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
        //and I can write something like this {id: 1, name: Jack, price: 10}

    }
        private void getResponse() {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/dummy-item")
                .accept(org.springframework.http.MediaType.APPLICATION_JSON);
        this.actualResponse = actualResponse.toString();
    }
}
