package com.murami.demo.java8.stream;

import java.util.List;

public class NumberCollectionConverter {

    /**
     * 引数で与えられた整数コレクションのすべての要素を2倍したコレクションを返却します．
     * <p>
     * Stream API は， Lambda Expression を用いてコレクションに対しての処理を効率よく記述することを可能にする API
     * です．
     * 
     * @param collection
     * @return
     */
    public void makeCollectionTwice(List<Integer> collection) {
        // TRY Stream API を用いてリファクタしてみましょう．
        for (int i = 0; i < collection.size(); i++) {
            collection.set(i, collection.get(i) * 2);
        }

    }

}
