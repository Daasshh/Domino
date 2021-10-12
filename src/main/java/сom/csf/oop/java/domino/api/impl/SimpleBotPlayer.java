package сom.csf.oop.java.domino.api.impl;

import сom.csf.oop.java.domino.api.PlayerStrategy;
import сom.csf.oop.java.domino.domain.GameSide;
import сom.csf.oop.java.domino.game.PlayerInGame;
import сom.csf.oop.java.domino.game.PlayerMove;
import сom.csf.oop.java.domino.model.Domino;
import сom.csf.oop.java.domino.model.Player;

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
