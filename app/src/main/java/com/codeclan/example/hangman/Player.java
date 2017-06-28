package com.codeclan.example.hangman;

public class Player {
    private int numLives = 6;

    public boolean isDead() {
        return numLives <= 0;
    }

    public void loseLife() {
        numLives--;
    }

    public int getNumLives() {
        return numLives;
    }
}