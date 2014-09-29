package com.murami.demo.java8.model;

import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class BaystarsPlayers {

    public static final Player ISHIKAWA;
    public static final Player KAJITANI;
    public static final Player GOURRIELL;
    public static final Player BLANCO;
    public static final Player TSUTSUGO;
    public static final Player BALDIRIS;
    public static final Player YAMAZAKI;
    public static final Player KUROBANE;
    public static final Player KUBO;
    public static final Player NAKAHATA;

    private static final Stream<Player> PLAYERS;

    static {
        Builder<Player> builder = Stream.builder();

        ISHIKAWA = new Player();
        ISHIKAWA.setFirstName("Takehiro");
        ISHIKAWA.setLastName("Ishikawa");
        ISHIKAWA.setNumber(7);
        ISHIKAWA.setPosition(Position.CENTER_FIELDER);
        builder.accept(ISHIKAWA);

        KAJITANI = new Player();
        KAJITANI.setFirstName("Takayuki");
        KAJITANI.setLastName("Kajitani");
        KAJITANI.setNumber(3);
        KAJITANI.setPosition(Position.RIGHT_FIELDER);
        builder.accept(KAJITANI);

        GOURRIELL = new Player();
        GOURRIELL.setFirstName("Yulieski");
        GOURRIELL.setLastName("Gourriell");
        GOURRIELL.setNumber(10);
        GOURRIELL.setPosition(Position.SECOND_BASEMAN);
        builder.accept(GOURRIELL);

        BLANCO = new Player();
        BLANCO.setFirstName("Tony");
        BLANCO.setLastName("Blanco");
        BLANCO.setNumber(42);
        BLANCO.setPosition(Position.FIRST_BASEMAN);
        builder.accept(BLANCO);

        TSUTSUGO = new Player();
        TSUTSUGO.setFirstName("Yoshitomo");
        TSUTSUGO.setLastName("Tsutsugo");
        TSUTSUGO.setNumber(25);
        TSUTSUGO.setPosition(Position.LEFT_FIELDER);
        builder.accept(TSUTSUGO);

        BALDIRIS = new Player();
        BALDIRIS.setFirstName("Aarom");
        BALDIRIS.setLastName("Baldiris");
        BALDIRIS.setNumber(52);
        BALDIRIS.setPosition(Position.THIRD_BASEMAN);
        builder.accept(BALDIRIS);

        YAMAZAKI = new Player();
        YAMAZAKI.setFirstName("Noriharu");
        YAMAZAKI.setLastName("Yamazaki");
        YAMAZAKI.setNumber(0);
        YAMAZAKI.setPosition(Position.SHORT_STOP);
        builder.accept(YAMAZAKI);

        KUROBANE = new Player();
        KUROBANE.setFirstName("Toshiki");
        KUROBANE.setLastName("Kurobane");
        KUROBANE.setNumber(9);
        KUROBANE.setPosition(Position.CATCHER);
        builder.accept(KUROBANE);

        KUBO = new Player();
        KUBO.setFirstName("Yasutomo");
        KUBO.setLastName("Kubo");
        KUBO.setNumber(27);
        KUBO.setPosition(Position.PITCHER);
        builder.accept(KUBO);

        NAKAHATA = new Player();
        NAKAHATA.setFirstName("Kiyoshi");
        NAKAHATA.setLastName("Nakahata");
        NAKAHATA.setNumber(70);
        NAKAHATA.setPosition(Position.MANAGER);
        builder.accept(NAKAHATA);

        PLAYERS = builder.build();
    }

    public static Stream<Player> stream() {
        return PLAYERS;
    }
}
