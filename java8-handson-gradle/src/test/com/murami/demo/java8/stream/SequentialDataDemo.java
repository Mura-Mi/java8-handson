package com.murami.demo.java8.stream;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

import com.google.common.collect.Collections2;

/**
 * Stream と Collection の違いを考えるためのクラス．
 * 
 * @author mura_mi
 *
 */
public class SequentialDataDemo {

    public static <T, R> Collection<R> typicalTransform(Collection<T> col, Function<T, R> func) {

        /*
         * MuraMemo: ちょっとだけ下のラムダ式に注意．なぜ func.apply をわざわざ2回呼んでいるのか，分かりますか？
         * FunctionalInterface アノテーションがついていなくても，関数インターフェイスの要件を満たしていればラムダで
         * インターフェイスの実装を記述できること，ラムダ式を評価した結果の型が何かに注意．
         */
        return Collections2.transform(col, input -> func.apply(input));
    }

    public static <T, R> Stream<R> typicalStream(Stream<T> source, Function<T, R> func) {
        return source.map(func);
    }

}
