package com.csf.oop.domino.game;

import com.csf.oop.domino.domain.GameSide;
import com.csf.oop.domino.model.Domino;

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
