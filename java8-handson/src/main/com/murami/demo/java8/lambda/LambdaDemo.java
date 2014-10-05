package com.murami.demo.java8.lambda;

import java.util.function.Function;

import com.murami.model.player.Player;

public class LambdaDemo {

    public static Function<Player, String> createPlayerUpperCaseNameResolver() {
        return new Function<Player, String>() {

            @Override
            public String apply(Player t) {
                return t.getLastName().toUpperCase();
            }
        };
    }

}
