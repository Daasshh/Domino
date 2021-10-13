package сom.csf.oop.java.domino.api;

import сom.csf.oop.java.domino.game.PlayerInGame;
import сom.csf.oop.java.domino.game.PlayerMove;

public interface PlayerStrategy {

    PlayerMove play(int topValue, int downValue);

    PlayerMove getHighestDomino();

    void notifyPlayerMove(PlayerMove playerMove, int topValue, int downValue);

    void notifyPlayerHasBoughtADomino(PlayerInGame playerInGame);

}
