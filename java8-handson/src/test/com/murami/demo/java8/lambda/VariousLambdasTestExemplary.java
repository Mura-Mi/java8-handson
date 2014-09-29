package com.murami.demo.java8.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;

import org.junit.Test;

import com.murami.demo.java8.lambda.VariousLambdas;
import com.murami.demo.java8.model.BaystarsPlayers;
import com.murami.demo.java8.model.Player;

public class VariousLambdasTestExemplary {

    /**
     * Long Adder を動かしてみる．
     */
    @Test
    public void testIntAdder() {
        AtomicLong sum = new AtomicLong();
        IntConsumer summer = VariousLambdas.createIntAdder(sum);

        // TRY Stream 式を用いて書き換えられるけど，それはまた今度．
        for (int i = 0; i < 10; i++) {
            summer.accept(i);
        }

        assertThat(sum.get(), is(45L));
    }

    @Test
    public void testNumberResolver() {
        Function<Player, Integer> resolver = VariousLambdas.createNumberResolver();

        assertThat(resolver.apply(BaystarsPlayers.KAJITANI), is(3));
        assertThat(resolver.apply(BaystarsPlayers.KUBO), is(27));
        assertThat(resolver.apply(BaystarsPlayers.BLANCO), is(42));
    }

    @Test
    public void testBetterNumberResolver() {
        ToIntFunction<Player> resolver = VariousLambdas.createBetterNumberResolver();

        assertThat(resolver.applyAsInt(BaystarsPlayers.KAJITANI), is(3));
        assertThat(resolver.applyAsInt(BaystarsPlayers.KUBO), is(27));
        assertThat(resolver.applyAsInt(BaystarsPlayers.BLANCO), is(42));
    }
}
