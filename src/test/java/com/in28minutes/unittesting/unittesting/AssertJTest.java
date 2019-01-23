package com.in28minutes.unittesting.unittesting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,15,52);
        //assertThat(numbers, hasSize(3));
        assertThat(numbers).hasSize(3)
                .contains(12)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 0);


        //assertThat("ABCD", containsString("AB"));

        assertThat("").isEmpty();

        assertThat("ABCD").contains("CD")
                                .startsWith("A")
                                .endsWith("D");


    }

}
