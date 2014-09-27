package com.murami.demo.java8.model;

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

    static {
        ISHIKAWA = new Player();
        ISHIKAWA.setFirstName("Takehiro");
        ISHIKAWA.setLastName("Ishikawa");
        ISHIKAWA.setNumber(7);
        ISHIKAWA.setPosition(Position.CENTER_FIELDER);

        KAJITANI = new Player();
        KAJITANI.setFirstName("Takayuki");
        KAJITANI.setLastName("Kajitani");
        KAJITANI.setNumber(3);
        KAJITANI.setPosition(Position.RIGHT_FIELDER);

        GOURRIELL = new Player();
        GOURRIELL.setFirstName("Yulieski");
        GOURRIELL.setLastName("Gourriell");
        GOURRIELL.setNumber(10);
        GOURRIELL.setPosition(Position.SECOND_BASEMAN);

        BLANCO = new Player();
        BLANCO.setFirstName("Tony");
        BLANCO.setLastName("Blanco");
        BLANCO.setNumber(42);
        BLANCO.setPosition(Position.FIRST_BASEMAN);

        TSUTSUGO = new Player();
        TSUTSUGO.setFirstName("Yoshitomo");
        TSUTSUGO.setLastName("Tsutsugo");
        TSUTSUGO.setNumber(25);
        TSUTSUGO.setPosition(Position.LEFT_FIELDER);

        BALDIRIS = new Player();
        BALDIRIS.setFirstName("Aarom");
        BALDIRIS.setLastName("Baldiris");
        BALDIRIS.setNumber(52);
        BALDIRIS.setPosition(Position.THIRD_BASEMAN);

        YAMAZAKI = new Player();
        YAMAZAKI.setFirstName("Noriharu");
        YAMAZAKI.setLastName("Yamazaki");
        YAMAZAKI.setNumber(0);
        YAMAZAKI.setPosition(Position.SHORT_STOP);

        KUROBANE = new Player();
        KUROBANE.setFirstName("Toshiki");
        KUROBANE.setLastName("Kurobane");
        KUROBANE.setNumber(9);
        KUROBANE.setPosition(Position.CATCHER);

        KUBO = new Player();
        KUBO.setFirstName("Yasutomo");
        KUBO.setLastName("Kubo");
        KUBO.setNumber(27);
        KUBO.setPosition(Position.PITCHER);

        NAKAHATA = new Player();
        NAKAHATA.setFirstName("Kiyoshi");
        NAKAHATA.setLastName("Nakahata");
        NAKAHATA.setNumber(70);
        NAKAHATA.setPosition(Position.MANAGER);

    }
}
