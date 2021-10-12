package сom.csf.oop.java.domino.game;

import сom.csf.oop.java.domino.domain.GameSide;
import сom.csf.oop.java.domino.model.Domino;

public class DominoWithExposedSide {
    private Domino domino;
    private GameSide exposedSide;

    public DominoWithExposedSide(Domino domino, GameSide exposedSide) {
        this.domino = domino;
        this.exposedSide = exposedSide;
    }

    public Domino getDomino() {
        return domino;
    }

    public GameSide getExposedSide() {
        return exposedSide;
    }

    public void setExposedSide(GameSide exposedSide) {
        this.exposedSide = exposedSide;
    }

}
