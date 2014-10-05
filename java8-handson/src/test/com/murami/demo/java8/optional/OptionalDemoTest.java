package com.murami.demo.java8.optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Lists;

public class OptionalDemoTest {

    @Test
    public void showOptionalUsage() {

        // null でない値を宣言するときは Optional#of を用いる
        Optional<String> optionalText = Optional.of("Not Null Value");

        // Optional#of に null を渡したら普通に NPE する．
        try {
            @SuppressWarnings("unused")
            Optional<String> nullText = Optional.of(null);
            fail("ぬるぽが起きるのでここは通らないはず");
        } catch (NullPointerException e) {
            // Success
        }

        // null になり得る変数を Optional でラップするときは Optional#ofNullable
        String actuallyNull = null;
        Optional<String> uncertainText = Optional.ofNullable(actuallyNull);

        // null を Optional でラップするときは Optional#empty を用いる．
        Optional<String> certainlyNullText = Optional.empty();

        // Optional で包まれた実際の値を取るには Optional#get する．
        assertThat(optionalText.get(), is("Not Null Value"));

        try {
            assertThat(uncertainText.get(), is(nullValue()));
            fail("空の Optional に get したら例外が出る．");
        } catch (NoSuchElementException e) {
            // Success
        }

        try {
            assertThat(certainlyNullText.get(), is(nullValue()));
            fail("上に同じ．");
        } catch (NoSuchElementException e) {
            // Success
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void showMonadUsage() {
        StringBuilder joined = new StringBuilder();
        Optional<String> optionalText = Optional.of("Not Null Value");
        Optional<String> uncertainText = Optional.ofNullable(null);
        Optional<String> certainlyNullText = Optional.empty();

        // 以下の式も Stream で書けますが…
        for (Optional<String> text : Lists.newArrayList(optionalText, uncertainText, certainlyNullText)) {
            // もし Optional が Monad じゃなかったら，いちいち中身を get する必要があった．
            // 逆に，中身が空だったら get しないようにする必要があった．
            if (text.isPresent()) {
                joined.append(text.get().toUpperCase());
            }
        }
        assertThat(joined.toString(), is("NOT NULL VALUE"));

        // Optional の Monad な処理では， Optional 自体に処理を渡して演算を行える．

        StringBuilder joined2 = new StringBuilder();

        for (Optional<String> text : Lists.newArrayList(optionalText, uncertainText, certainlyNullText)) {
            text.map(String::toUpperCase).ifPresent(joined2::append);
        }
        assertThat(joined2.toString(), is("NOT NULL VALUE"));

        // 途中で null になっても大丈夫
        optionalText.map(s -> null).ifPresent(joined2::append);
        assertThat(joined2.toString(), is("NOT NULL VALUE"));
    }

    @Test
    public void testOrElse() {
        Optional<String> a, b, c;
        a = Optional.of("first");
        b = Optional.empty();
        c = Optional.of("third");

        Stream.of(a, b, c).map(op -> op.orElse("none")).forEach(System.out::println);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testHeavyObjectOptional() {
        Optional<HeavyObject> a = Optional.of(HeavyObject.a);
        Optional<HeavyObject> b = Optional.of(HeavyObject.b);
        Optional<HeavyObject> c = Optional.empty();

        for (Optional<HeavyObject> obj : Lists.newArrayList(a, b, c)) {
            // TRY: 都度 Default の HeavyObject を生成しないためにはどうする？
            System.out.println(String.format("Processing %s ...", obj.orElse(HeavyObject.of("Default"))));
        }
    }

    /**
     * static field で持っている a と b 以外の生成には時間がかかるオブジェクト
     */
    private static class HeavyObject {
        private static HeavyObject a = new HeavyObject("First");
        private static HeavyObject b = new HeavyObject("Second");

        private final String name;

        private HeavyObject(String name) {
            this.name = name;
        }

        static HeavyObject of(String name) {
            System.out.println(String.format("Generated %s", name));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new HeavyObject(name);
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    /*-*-*-* 以下，書いてみたけどわかりにくいので Hands On では扱いません…orz *-*-*-*/

    private static final String I_LOVE_YOKOHAMA = "%s says \"I ☆ YOKOHAMA!\"";

    @Test
    public void displayHeroInterviewDigest() {
        Stream.generate(() -> OptionalDemo.getNewGameResult()).limit(20).forEach((game) -> {
            if (game.getHero().isPresent()) {
                System.out.println(String.format(I_LOVE_YOKOHAMA, game.getHero().get().getLastName()));
            }
        });
    }

    @Test
    public void monadInterviewDigest() {
        Stream.generate(() -> OptionalDemo.getNewGameResult())
                .limit(20)
                .forEach(
                        (game) -> game.getHero().ifPresent(
                                (p) -> System.out.println(String.format(I_LOVE_YOKOHAMA, p.getLastName()))));
    }
}
