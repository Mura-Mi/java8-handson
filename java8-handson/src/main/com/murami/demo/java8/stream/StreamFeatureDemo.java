package com.murami.demo.java8.stream;

import java.util.stream.Stream;

import com.murami.demo.java8.model.BaystarsMembers;
import com.murami.demo.java8.model.Player;

public class StreamFeatureDemo {

    public static Stream<Player> createStream() {
        return BaystarsMembers.stream();
    }

    public static Stream<Player> createStreamFromCollection() {
        return BaystarsMembers.collection().stream();
    }

    public static Stream<Player> createParallelStream() {
        return BaystarsMembers.collection().parallelStream();
    }

    public static Stream<Player> createEndlessTakehiro() {
        return Stream.generate(() -> BaystarsMembers.ISHIKAWA);
    }
}
