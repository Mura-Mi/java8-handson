package com.murami.demo.java8.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.function.Function;

import org.junit.Test;

import com.murami.model.player.BaystarsMembers;
import com.murami.model.player.Player;

public class VariousLambdasTest {

    @Test
    public void testIntAdder() {
        fail("TRY: 1 から 10 まで足してみましょう．");
    }

    @Test
    public void testNumberResolver() {
        fail("TRY createNumberResolver の結果を動かしてみましょう．");
    }

    @Test
    public void testBetterNumberResolver() {
        fail("TRY createBetterNumberResolver の結果を動かしてみましょう．");
    }

    @Test
    public void testPositionStringConverter() {
        Function<Player, String> converter = VariousLambdas.createPositionStringConverter();

        assertThat("TRY: make this test success.", converter.apply(BaystarsMembers.NAKAHATA), is("MANAGER"));
        assertThat("TRY: make this test success.", converter.apply(BaystarsMembers.BLANCO), is("FIRST_BASEMAN"));
        assertThat("TRY: make this test success.", converter.apply(BaystarsMembers.TSUTSUGO), is("LEFT_FIELDER"));
    }

}
