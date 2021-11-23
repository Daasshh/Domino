package com.csf.oop.domino.api;

import com.csf.oop.domino.game.PlayerMove;
import com.csf.oop.domino.game.PlayerInGame;

public interface PlayerStrategy {

    PlayerMove play(int topValue, int downValue);

    PlayerMove getHighestDomino();

    void notifyPlayerMove(PlayerMove playerMove, int topValue, int downValue);

    void notifyPlayerHasBoughtADomino(PlayerInGame playerInGame);

}
