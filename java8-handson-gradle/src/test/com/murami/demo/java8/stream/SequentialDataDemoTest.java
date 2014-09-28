package com.murami.demo.java8.stream;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class SequentialDataDemoTest {

    private static final ArrayList<Integer> SOURCE = Lists.newArrayList(1, 2, 3, 4, 5);

    private static final Function<Integer, Double> FUNCTION = i -> i / 2d;

    /**
     * 典型的な
     * {@link Collections2#transform(Collection, com.google.common.base.Function)}
     * の使い方を示します．
     */
    @Test
    public void testTypicalTransform() {
        Collection<Double> result = SequentialDataDemo.typicalTransform(SOURCE, FUNCTION);

        assertThat(result, hasItem(0.5d));
        assertThat(result, hasItem(1.0d));
        assertThat(result, hasItem(1.5d));
        assertThat(result, hasItem(2.0d));
        assertThat(result, hasItem(2.5d));
    }

    /**
     * 上記の {@link SequentialDataDemoTest#testTypicalTransform()} と同じような処理を，
     * Stream を使って記述します．
     */
    @Test
    public void testTypicalStream() {
        Iterator<Double> result = SequentialDataDemo.typicalStream(SOURCE.stream(), FUNCTION).iterator();

        assertThat(result.next(), is(0.5d));
        assertThat(result.next(), is(1.0d));
        assertThat(result.next(), is(1.5d));
        assertThat(result.next(), is(2.0d));
        assertThat(result.next(), is(2.5d));
        assertThat(result.hasNext(), is(false));
    }

    /**
     * {@link Collection} より {@link Stream} の方が都合が良いケースを考えてみましょう．
     */
    @Test
    public void showStreamAppropreateSituation() {
        fail("TRY: Collection より Stream が有用なケースを考えてテストコードを記述してみましょう．");
    }
}
