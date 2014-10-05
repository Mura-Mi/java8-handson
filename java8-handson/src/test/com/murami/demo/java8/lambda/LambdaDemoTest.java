package com.murami.demo.java8.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.Function;

import org.junit.Test;

import com.murami.model.player.BaystarsMembers;
import com.murami.model.player.Player;

public class LambdaDemoTest {

    @Test
    public void testPlayerNameUpperCase() {
        Function<Player, String> nameResolver = LambdaDemo.createPlayerUpperCaseNameResolver();

        assertThat(nameResolver.apply(BaystarsMembers.KAJITANI), is("KAJITANI"));
        assertThat(nameResolver.apply(BaystarsMembers.TSUTSUGO), is("TSUTSUGO"));
    }
}
