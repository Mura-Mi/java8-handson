package com.murami.demo.java8.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.Function;

import org.junit.Test;

import com.murami.demo.java8.model.BaystarsPlayers;
import com.murami.demo.java8.model.Player;

public class LambdaDemoTest {

    @Test
    public void testPlayerNameUpperCase() {
        Function<Player, String> nameResolver = LambdaDemo.createPlayerUpperCaseNameResolver();

        assertThat(nameResolver.apply(BaystarsPlayers.KAJITANI), is("KAJITANI"));
        assertThat(nameResolver.apply(BaystarsPlayers.TSUTSUGO), is("KAJITANI"));
    }
}
