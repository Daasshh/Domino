package сom.csf.oop.java.domino.example;

import сom.csf.oop.java.domino.api.impl.SimpleBotPlayer;
import сom.csf.oop.java.domino.game.Game;
import сom.csf.oop.java.domino.model.GameRules;
import сom.csf.oop.java.domino.model.Player;

public class SimpleBotGame {

    public static void main(String[] args) {
        GameRules gameRules = new GameRules(false, true);

        Game game = new Game("Game-01", gameRules, createBotPlayer("Bot-01", 1));
        game.addPlayer(createBotPlayer("Bot-02", 2));
        game.addPlayer(createBotPlayer("Bot-03", 1));
        game.addPlayer(createBotPlayer("Bot-04", 2));

        game.startGame();
    }

    private static SimpleBotPlayer createBotPlayer(String nickName, Integer team) {
        return new SimpleBotPlayer(new Player(nickName, nickName), team);
    }

}
