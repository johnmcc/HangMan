package com.codeclan.example.hangman;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private boolean isWon = false;
    private Word word;
    private ArrayList<Character> guesses;

    public Game(Word word, Player player1) {
        this.word = word;
        this.guesses = new ArrayList<Character>();
        this.player1 = player1;
    }

    public boolean getIsWon() {
        return isWon;
    }

    public void setIsWon(boolean isWon) {
        this.isWon = isWon;
    }

    public void addGuess(Character c) {
        c = Character.toLowerCase(c);
        if (!guesses.contains(c)) {
            guesses.add(c);
        }
    }

    public ArrayList<Character> getGuesses() {
        return new ArrayList<>(guesses);
    }

    public String update() {
        StringBuilder sb = new StringBuilder();

        // check if the letter is in the word
        Character lastGuess = guesses.get(guesses.size() - 1);

        if (!word.getWord().contains(lastGuess.toString().toLowerCase())) {
            player1.loseLife();
            sb.append("Oh no! You slip closer to death...\n");
        }

        // Pass guesses to our word, get new word
        sb.append(this.word.update(guesses));
        sb.append("\n");
        sb.append("You have " + player1.getNumLives() + " lives remaining.");

        // check if the game is won
        if (word.getWord().equals(word.getHiddenWord())) {
            isWon = true;
        }

        return sb.toString();
    }
}