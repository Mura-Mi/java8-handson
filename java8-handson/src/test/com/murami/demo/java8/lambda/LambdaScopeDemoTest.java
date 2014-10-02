package com.murami.demo.java8.lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.google.common.base.Supplier;
import com.murami.model.BaystarsMembers;
import com.murami.model.Player;

public class LambdaScopeDemoTest {

    /**
     * ラムダ式に渡せる変数は，「実質的に final」 である必要がある． つまり， final として宣言されているか，
     * 一度値が代入された後に再代入されていない必要がある． 以下のように if 文を噛ませても，勿論ダメ．
     */
    @Test
    public void demo() {

        /* final */Player p = BaystarsMembers.KAJITANI;

        Supplier<String> nameSupplier = () -> p.getLastName();
        assertThat(nameSupplier.get(), is("Kajitani"));

        // Compile Error Occurs.
        // if (new Random().nextDouble() > 0) {
        // p = BaystarsPlayers.YAMAZAKI;
        // assertThat(nameSupplier.get(), is("Yamazaki"));
        // }
    }
}
