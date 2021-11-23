package com.csf.oop.domino.example;

import com.csf.oop.domino.api.impl.SimpleBotPlayer;
import com.csf.oop.domino.game.Game;
import com.csf.oop.domino.model.GameRules;
import com.csf.oop.domino.model.Player;

public class Main {

    public static void main(String[] args) {
        GameRules gameRules = new GameRules(false, true);

        Game game = new Game("Game-01", gameRules, createBotPlayer("Bot-01", 1));
        game.addPlayer(createBotPlayer("Bot-02", 1));
        game.addPlayer(createBotPlayer("Bot-03", 2));
        game.addPlayer(createBotPlayer("Bot-04", 1));

        game.startGame();
    }

    private static SimpleBotPlayer createBotPlayer(String nickName, Integer team) {
        return new SimpleBotPlayer(new Player(nickName, nickName), team);
    }

}
