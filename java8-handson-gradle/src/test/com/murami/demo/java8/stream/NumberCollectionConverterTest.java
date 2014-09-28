package com.murami.demo.java8.stream;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class NumberCollectionConverterTest {

    private NumberCollectionConverter subject;

    @Before
    public void setup() {
        this.subject = new NumberCollectionConverter();
    }

    @Test
    public void testSummarize() {
        ArrayList<Integer> col = Lists.newArrayList(1, 2, 3, 4, 5);
        subject.makeCollectionTwice(col);
        assertThat(col, hasItem(2));
        assertThat(col, hasItem(4));
        assertThat(col, hasItem(6));
        assertThat(col, hasItem(8));
        assertThat(col, hasItem(10));
    }
}
