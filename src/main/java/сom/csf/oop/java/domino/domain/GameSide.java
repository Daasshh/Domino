package сom.csf.oop.java.domino.domain;

public enum GameSide {
    UP,
    DOWN,
    BOTH;

    public GameSide getOpposite() {
        switch (this) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
        }
        return null;
    }
}
