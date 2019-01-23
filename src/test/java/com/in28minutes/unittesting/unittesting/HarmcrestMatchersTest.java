package com.in28minutes.unittesting.unittesting;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import org.junit.Test;

import java.util.List;

public class HarmcrestMatchersTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,15,52);
        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12,52));
        assertThat(numbers, everyItem(greaterThan(10)));

        assertThat("", isEmptyString());
        assertThat("ABCD", containsString("AB"));
    }

}
