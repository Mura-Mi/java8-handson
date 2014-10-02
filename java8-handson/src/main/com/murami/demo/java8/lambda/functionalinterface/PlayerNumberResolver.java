package com.murami.demo.java8.lambda.functionalinterface;

import com.murami.model.Player;

@FunctionalInterface
public interface PlayerNumberResolver {

    /**
     * プレイヤーの背番号を解決する関数です．
     * <p>
     * Java8 では関数が言語組み込みの値として扱えるようになったわけではなく， Interface のうち「実装するべきメソッドがひとつの
     * Interface」を「Functional Interface」と分類し，それがラムダ式で表現可能となります．<br>
     * 結構いろんなところで内部クラスを書いていると思うので，かなりすっきりするかも...??
     * 
     * 
     * @param p
     * @return
     */
    int resolve(Player p);
}
