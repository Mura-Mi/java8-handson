package com.murami.demo.java8.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Function;

import org.junit.Test;

import com.murami.demo.java8.model.BaystarsPlayers;
import com.murami.demo.java8.model.Player;

public class VariousLambdasTest {

    @Test
    public void testIntAdder() {
        // TRY 1 から 10 まで足してみましょう．
    }

    @Test
    public void testNumberResolver() {
        // TRY createNumberResolver の結果を動かしてみましょう．
    }

    @Test
    public void testBetterNumberResolver() {
        // TRY createBetterNumberResolver の結果を動かしてみましょう．
    }

    @Test
    public void testPositionStringConverter() {
        Function<Player, String> converter = VariousLambdas.createPositionStringConverter();

        assertThat("TRY: make this test success.", converter.apply(BaystarsPlayers.NAKAHATA), is("MANAGER"));
        assertThat("TRY: make this test success.", converter.apply(BaystarsPlayers.BLANCO), is("FIRST_BASEMAN"));
        assertThat("TRY: make this test success.", converter.apply(BaystarsPlayers.TSUTSUGO), is("LEFT_FIELDER"));
    }

}
