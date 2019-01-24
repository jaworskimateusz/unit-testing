package com.in28minutes.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JsonPathTest {

    @Test
    public void learning() {
        String responseFromService = "[\n" +
                "    {\"id\": 1000, \"name\": \"Glass\", \"quantity\": 3},\n" +
                "    {\"id\": 1001, \"name\": \"Ice\", \"quantity\": 12},\n" +
                "    {\"id\": 1002, \"name\": \"Burbon\", \"quantity\": 1}\n" +
                "]";

        DocumentContext parse = JsonPath.parse(responseFromService);
        int length = parse.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = parse.read("$..id");

        assertThat(ids).containsExactly(1000,1001,1002);

        System.out.println(parse.read("$.[1]").toString());
        System.out.println(parse.read("$.[?(@.quantity=='Ice')]").toString());

    }
}
