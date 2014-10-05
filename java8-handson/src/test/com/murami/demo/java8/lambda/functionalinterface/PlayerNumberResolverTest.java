package com.murami.demo.java8.lambda.functionalinterface;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.murami.demo.java8.lambda.functionalinterface.PlayerNumberResolver;
import com.murami.model.player.BaystarsMembers;
import com.murami.model.player.Player;

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

        assertThat(resolver.resolve(BaystarsMembers.KAJITANI), is(3));
        assertThat(resolver.resolve(BaystarsMembers.YAMAZAKI), is(0));
        assertThat(resolver.resolve(BaystarsMembers.GOURRIELL), is(10));
    }

}
