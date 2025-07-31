package baseball.core;

public class Hint {

    private final int strikes;
    private final int balls;

    public Hint(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
