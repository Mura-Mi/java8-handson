package com.murami.model.game;

/**
 * 試合の勝敗結果を表す列挙型です．
 * 
 * @author mura_mi
 */
public enum GameResult {

    WIN {

        @Override
        public boolean isWin() {
            return true;
        }

    },

    LOSE {

        @Override
        public boolean isWin() {
            return false;
        }

    },

    DRAW {
        @Override
        public boolean isWin() {
            return false;
        }
    };

    public abstract boolean isWin();
}
