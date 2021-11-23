package com.csf.oop.domino.api.impl;

import com.csf.oop.domino.game.PlayerMove;
import com.csf.oop.domino.api.PlayerStrategy;
import com.csf.oop.domino.domain.GameSide;
import com.csf.oop.domino.game.PlayerInGame;
import com.csf.oop.domino.model.Domino;
import com.csf.oop.domino.model.Player;

import java.awt.*;
import java.awt.event.AWTEventListener;

public class SimpleBotPlayer extends PlayerInGame {

    public SimpleBotPlayer(Player player, Integer team) {
        super(player, team);
    }

    @Override
    public PlayerStrategy getStrategy() {
        return new SimpleBotPlayerStrategy();
    }

    @Override
    public String toString() {
        return this.getPlayer().toString();
    }

    private class SimpleBotPlayerStrategy implements PlayerStrategy {
        @Override
        public PlayerMove play(int topValue, int downValue) {
            // TODO - Improve intelligence
            for (Domino domino : getHand()) {
                if (domino.getUpValue().equals(topValue) || domino.getDownValue().equals(topValue)) {
                    return playAMove(domino, GameSide.UP);
                }
                if (domino.getUpValue().equals(downValue) || domino.getDownValue().equals(downValue)) {
                    return playAMove(domino, GameSide.DOWN);
                }
            }


            return new PlayerMove();
        }

        @Override
        public PlayerMove getHighestDomino() {
            Domino highest = null;
            int highestValue = Integer.MIN_VALUE;
            for (Domino domino : getHand()) {
                if (domino.getSummedValue() > highestValue) {
                    if (highest == null || !highest.isSameValue() || domino.isSameValue()) {
                        highest = domino;
                        highestValue = domino.getSummedValue();
                    }
                }
            }
            return playAMove(highest, GameSide.BOTH);
        }

        @Override
        public void notifyPlayerMove(PlayerMove playerMove, int topValue, int downValue) {

        }

        @Override
        public void notifyPlayerHasBoughtADomino(PlayerInGame playerInGame) {

        }
    }

}
