package com.csf.oop.domino.model;

import java.io.Serializable;

public class GameRules implements Serializable {
    private boolean canClose;
    private boolean canBuy;

    public GameRules(boolean canClose, boolean canBuy) {
        this.canClose = canClose;
        this.canBuy = canBuy;
    }

    public boolean isCanClose() {
        return canClose;
    }

    public boolean isCanBuy() {
        return canBuy;
    }
}
