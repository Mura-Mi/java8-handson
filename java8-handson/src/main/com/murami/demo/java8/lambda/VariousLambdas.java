package com.murami.demo.java8.lambda;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;

import com.google.common.base.Functions;
import com.murami.model.Player;

public class VariousLambdas {

    /**
     * 選手オブジェクトを受け取り， {@link StringBuilder} に {@code append} する {@link Consumer}
     * を返します．
     * <p>
     * {@link Consumer} は，何かの型を引数にとって何かの処理をして {@code void} を返す関数です．
     * (厳密には，何も返していないし，何らかの状態を変更する副作用をもたらしているので，純粋な関数ではない．) <br>
     * (この関数の場合， {@code builder} の状態を変更している．)
     * 
     * @param builder
     * @return
     */
    public static Consumer<Player> createWritingConsumer(final StringBuilder builder) {

        // TRY Lambda 式表記にリファクタしてみましょう．
        return new Consumer<Player>() {

            @Override
            public void accept(Player t) {
                builder.append(t);
            }

        };
    }

    /**
     * 各関数型には， Generic を用いて記述する型以外に， Primitive 型の引数をとる関数も用意されています．<br>
     * この点は Guava よりも優れているし，特に計算系のモジュールではオートボクシングのコストも回避できることもありそう...!!
     * 
     * read: <br>
     * http://docs.oracle.com/javase/jp/8/api/java/util/function/package-summary
     * .html
     * 
     * @param sum
     * @return
     */
    public static IntConsumer createIntAdder(final AtomicLong sum) {

        // TRY 同じように Lambda 式にリファクタしてみましょう．
        return new IntConsumer() {

            @Override
            public void accept(int value) {
                sum.addAndGet(value);
            }
        };
    }

    /**
     * いままで {@link com.google.common.base.Function} とかなり似ている
     * {@link java.util.Function} もあります． これまで Guava
     * で書いていたところとの住み分けとかは考える必要がありそう．
     * 
     * @return
     */
    public static Function<Player, Integer> createNumberResolver() {

        // TRY リファクタしてみましょう．1行なら上の例よりスマートにかけちゃいます．
        return new Function<Player, Integer>() {

            @Override
            public Integer apply(Player t) {
                return t.getNumber();
            }
        };
    }

    /**
     * {@link Function} にも， Primitive 型向け Function が出来ました．
     * 
     * @return
     */
    public static ToIntFunction<Player> createBetterNumberResolver() {
        return p -> p.getNumber();
    }

    /**
     * 選手のポジションを文字列にして返す関数を作成します．
     * <p>
     * {@link java.util.Function} には，いくつかデフォルト実装されたメソッドがあるので，ソースや JavaDoc
     * を読んでみましょう． <br>
     * Guava なら {@link Functions} で書かれていたことがデフォルト実装されているので，
     * {@link java.util.Function} の方が使いやすい...???
     * 
     * @return
     */
    public static Function<Player, String> createPositionStringConverter() {
        // TRY java.util.Function を使って実装してみましょう．
        // テストが用意されているので，通るように実装しましょう．
        return (p) -> "";
    }

}
