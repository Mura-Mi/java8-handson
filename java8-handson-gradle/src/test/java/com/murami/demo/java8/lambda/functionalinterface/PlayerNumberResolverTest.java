package com.murami.demo.java8.lambda.functionalinterface;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.murami.demo.java8.model.BaystarsPlayers;
import com.murami.demo.java8.model.Player;

public class PlayerNumberResolverTest {

    @Test
    public void testResolve() {

        // TRY 自作の Interface でもラムダ式で書けることを確認しましょう．
        PlayerNumberResolver resolver = new PlayerNumberResolver() {

            @Override
            public int resolve(Player p) {
                return p.getNumber();
            }
        };

        assertThat(resolver.resolve(BaystarsPlayers.KAJITANI), is(3));
        assertThat(resolver.resolve(BaystarsPlayers.YAMAZAKI), is(0));
        assertThat(resolver.resolve(BaystarsPlayers.GOURRIELL), is(10));
    }

}
