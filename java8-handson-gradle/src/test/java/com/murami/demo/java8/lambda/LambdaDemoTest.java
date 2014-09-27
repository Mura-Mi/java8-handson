package com.murami.demo.java8.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class LambdaDemoTest {

    @Test
    public void testReduceNamesToText() {
        List<String> names = Lists.newLinkedList();
        names.add("Takuro");
        names.add("Haru");
        names.add("Takanori");
        names.add("Rose");
        names.add("Komada");

        assertThat(LambdaDemo.reduceNamesToList(names), is("Takuro, Haru, Takanori, Rose, Komada"));

    }
}
