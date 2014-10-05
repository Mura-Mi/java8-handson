package com.murami.model.game;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.murami.model.player.Player;

/**
 * 試合の勝敗および，勝ち試合のヒーローインタビューに呼ばれた選手を格納するクラスです．
 */
@AllArgsConstructor
public class GameSummary {
    @Getter
    private final GameResult result;

    private final Player hero;

    /**
     * 勝ち試合の場合はインタビューに呼ばれた選手を，そうでない場合は空の {@link Optional} を返します．
     * 
     * @return
     */
    public Optional<Player> getHero() {
        return Optional.ofNullable(hero);
    }
}