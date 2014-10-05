package com.murami.demo.java8.optional;

import java.math.BigDecimal;
import java.util.Collection;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.murami.model.game.GameResult;
import com.murami.model.game.GameSummary;
import com.murami.model.player.BaystarsMembers;
import com.murami.model.player.Player;

public class OptionalDemo {

    /**
     * ランダムに試合結果を生成して返します．
     * 
     * @return
     */
    public static GameSummary getNewGameResult() {
        double random = Math.random();
        GameResult result = random > 0.5 ? GameResult.WIN : GameResult.LOSE;

        Player hero;
        if (result == GameResult.WIN) {
            Collection<Player> players = Collections2.filter(BaystarsMembers.collection(), Player::isPlayable);
            hero = Lists.newArrayList(players).get(BigDecimal.valueOf(players.size() * random / 2).intValue());
        } else {
            hero = null;
        }

        return new GameSummary(result, hero);
    }

}
