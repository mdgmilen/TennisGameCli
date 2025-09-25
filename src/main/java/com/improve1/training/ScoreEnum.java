package com.improve1.training;

public enum ScoreEnum {
    LOVE(0), FIFTEEN(1), THIRTY(2), FORTY(3), ADVANTAGE(4), WIN(5);

    private final int score;

    ScoreEnum(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static ScoreEnum fromInt(int score) {
        for (ScoreEnum s : ScoreEnum.values()) {
            if (s.getScore() == score) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid score: " + score);
    }
}
