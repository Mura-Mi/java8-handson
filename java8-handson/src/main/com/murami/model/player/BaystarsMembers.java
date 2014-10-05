package com.murami.model.player;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class BaystarsMembers {

    public static final Player ISHIKAWA;
    public static final Player KAJITANI;
    public static final Player GOURRIELL;
    public static final Player BLANCO;
    public static final Player TSUTSUGO;
    public static final Player BALDIRIS;
    public static final Player YAMAZAKI;
    public static final Player KUROBANE;
    public static final Player KUBO;
    public static final Player SHINDO;
    public static final Player NAKAHATA;

    private static final List<Player> PLAYER_LIST;

    static {
        PLAYER_LIST = Lists.newLinkedList();

        ISHIKAWA = new Player();
        ISHIKAWA.setFirstName("Takehiro");
        ISHIKAWA.setLastName("Ishikawa");
        ISHIKAWA.setNumber(7);
        ISHIKAWA.setPosition(Position.CENTER_FIELDER);
        PLAYER_LIST.add(ISHIKAWA);

        KAJITANI = new Player();
        KAJITANI.setFirstName("Takayuki");
        KAJITANI.setLastName("Kajitani");
        KAJITANI.setNumber(3);
        KAJITANI.setPosition(Position.RIGHT_FIELDER);
        PLAYER_LIST.add(KAJITANI);

        GOURRIELL = new Player();
        GOURRIELL.setFirstName("Yulieski");
        GOURRIELL.setLastName("Gourriell");
        GOURRIELL.setNumber(10);
        GOURRIELL.setPosition(Position.SECOND_BASEMAN);
        PLAYER_LIST.add(GOURRIELL);

        BLANCO = new Player();
        BLANCO.setFirstName("Tony");
        BLANCO.setLastName("Blanco");
        BLANCO.setNumber(42);
        BLANCO.setPosition(Position.FIRST_BASEMAN);
        PLAYER_LIST.add(BLANCO);

        TSUTSUGO = new Player();
        TSUTSUGO.setFirstName("Yoshitomo");
        TSUTSUGO.setLastName("Tsutsugo");
        TSUTSUGO.setNumber(25);
        TSUTSUGO.setPosition(Position.LEFT_FIELDER);
        PLAYER_LIST.add(TSUTSUGO);

        BALDIRIS = new Player();
        BALDIRIS.setFirstName("Aarom");
        BALDIRIS.setLastName("Baldiris");
        BALDIRIS.setNumber(52);
        BALDIRIS.setPosition(Position.THIRD_BASEMAN);
        PLAYER_LIST.add(BALDIRIS);

        YAMAZAKI = new Player();
        YAMAZAKI.setFirstName("Noriharu");
        YAMAZAKI.setLastName("Yamazaki");
        YAMAZAKI.setNumber(0);
        YAMAZAKI.setPosition(Position.SHORT_STOP);
        PLAYER_LIST.add(YAMAZAKI);

        KUROBANE = new Player();
        KUROBANE.setFirstName("Toshiki");
        KUROBANE.setLastName("Kurobane");
        KUROBANE.setNumber(9);
        KUROBANE.setPosition(Position.CATCHER);
        PLAYER_LIST.add(KUROBANE);

        KUBO = new Player();
        KUBO.setFirstName("Yasutomo");
        KUBO.setLastName("Kubo");
        KUBO.setNumber(27);
        KUBO.setPosition(Position.PITCHER);
        PLAYER_LIST.add(KUBO);

        SHINDO = new Player();
        SHINDO.setFirstName("Tatsuya");
        SHINDO.setLastName("Shindo");
        SHINDO.setNumber(78);
        SHINDO.setPosition(Position.COATCH);
        PLAYER_LIST.add(SHINDO);

        NAKAHATA = new Player();
        NAKAHATA.setFirstName("Kiyoshi");
        NAKAHATA.setLastName("Nakahata");
        NAKAHATA.setNumber(70);
        NAKAHATA.setPosition(Position.MANAGER);
        PLAYER_LIST.add(NAKAHATA);

    }

    /**
     * すべての選手を提供する {@link Stream} を返します．
     * 
     * @return
     */
    public static Stream<Player> stream() {
        return PLAYER_LIST.stream();
    }

    /**
     * 選手の一覧を表す {@link List} を返します．
     * <p>
     * そもそも {@link List} を static な場所に置くのも間違いだしメソッドの返り値として
     * {@link Collections#unmodifiableCollection(Collection)}
     * で包まないのも問題だけど，それを除いても {@link Collection} が状態を持つがゆえに不都合な部分は多い．
     * 
     */
    public static Collection<Player> collection() {
        return PLAYER_LIST;
    }
}
