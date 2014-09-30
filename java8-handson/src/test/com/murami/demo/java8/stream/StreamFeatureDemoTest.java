package com.murami.demo.java8.stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.murami.demo.java8.model.BaystarsMembers;
import com.murami.demo.java8.model.Player;
import com.murami.demo.java8.model.Position;

public class StreamFeatureDemoTest {

    @Rule
    public Timeout timeout = Timeout.seconds(2);

    @Test
    public void testPlayersStream() {
        StreamFeatureDemo.createStream().forEach(System.out::println);
    }

    /**
     * 選手だけを抽出する悪い例を示します．
     * <p>
     * {@link BaystarsMembers#collection()} の返り値がグローバルだし modifiable
     * なので色々と問題が起こせます．<br>
     * さすがにそこまで悪い設計をスる人もいないかと思いますが，出来てしまうことが問題．<br>
     * また，グローバルな static 変数とまでは行かなくとも，ドメインモデルに持たせたコレクションでこのようなことが起きる可能性は十分にある．
     */
    @Test
    public void testBadFilter() {
        Collection<Player> players = BaystarsMembers.collection();
        // 以下でアカン filter をやってしまっている．
        List<Player> toRemove = Lists.newArrayList();
        for (Player p : players) {
            if (!p.isPlayable()) {
                toRemove.add(p);
            }
        }
        players.removeAll(toRemove);

        for (Player p : players) {
            assertThat(p.toString(), p.isPlayable(), is(true));
        }

        /*-*-*-*- ここまでが前座 -*-*-*-*/

        Player kiyoshi70 = null;
        for (Player p : BaystarsMembers.collection()) {
            if (p.getPosition() == Position.MANAGER) {
                kiyoshi70 = p;
                break;
            }
        }

        assertThat("TRY: キヨシを見つけているはずなのに null になってしまった!!なぜ？", kiyoshi70, is(BaystarsMembers.NAKAHATA));
    }

    /**
     * {@link Collections2#filter(Collection, com.google.common.base.Predicate)}
     * を用いたマトモな filter を示します．
     * <p>
     * {@link Collections2} は {@link Iterator} にアダプタを噛ませているので安心です．<br>
     * 普段のお仕事でもこうやって filter してますよね？
     */
    @Test
    public void testBetterFilter() {
        // Collections2#filter もラムダ式でスッキリ！!
        Collection<Player> players = Collections2.filter(BaystarsMembers.collection(), Player::isPlayable);

        // Collection を回すのもラムダと Java8 で加わった API
        // で簡素に書けるのですが…今までは以下のようにやっていましたよね??
        for (Player p : players) {
            assertThat(p.isPlayable(), is(true));
        }

        Player kiyoshi70 = null;
        for (Player p : BaystarsMembers.collection()) {
            if (p.getPosition() == Position.MANAGER) {
                kiyoshi70 = p;
                break;
            }
        }
        // 無事，中畑監督が消えてしまわないで済みました．
        assertThat(kiyoshi70, is(BaystarsMembers.NAKAHATA));
    }

    /**
     * {@link Stream#filter(java.util.function.Predicate)} を使う場合は以下のように書きます．
     * <p>
     * Stream がデータをストレージしないこと，一回の消費でライフサイクルを終えること，変更不可能であることを確認して下さい．
     * 
     */
    @Test
    public void testBestFilterByStream() {
        BaystarsMembers.stream().filter(Player::isPlayable).forEach((p) -> assertThat(p.isPlayable(), is(true)));
        // 以下の書き方も可能．
        assertThat(BaystarsMembers.stream().filter(Player::isPlayable).allMatch(Player::isPlayable), is(true));

        // 終端操作をしてしまった後は Stream の操作ができないので，新しく Stream を生成する．
        Optional<Player> kiyoshi70 = BaystarsMembers.stream().filter(p -> p.getPosition() == Position.MANAGER)
                .findFirst();
        assertThat(kiyoshi70.isPresent(), is(true));
        assertThat(kiyoshi70.get(), is(BaystarsMembers.NAKAHATA));
    }

    /**
     * Stream が使いきりであることを確認して下さい．
     */
    @Test
    public void testStreamConsumable() {
        Stream<Player> stream = BaystarsMembers.stream();
        stream.forEach(System.out::println); // これは終端操作．もう stream に対して操作はできない．

        try {
            stream.forEach(System.out::println);
            fail("ここに入ったらおかしい");
        } catch (IllegalStateException e) {
            // SUCCESS
        }

    }

    /**
     * 無限に続く {@link Stream} に対する操作に気をつけなければならないことを示します．<br>
     * このテストは {@link Timeout} ルールに抵触して失敗します．
     */
    @Test
    public void testEndlessTakehiro() {
        Stream<Player> endlessTakehiro = StreamFeatureDemo.createEndlessTakehiro();
        endlessTakehiro.count();
    }
}
