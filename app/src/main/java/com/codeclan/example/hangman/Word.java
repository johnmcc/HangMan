package com.codeclan.example.hangman;

import java.util.ArrayList;

public class Word {
    private String word;
    private StringBuilder hiddenWord;

    public Word(String word) {
        this.word = word.toLowerCase();
        update(new ArrayList<Character>());
    }

    public String update(ArrayList<Character> guesses) {
        hiddenWord = new StringBuilder();

        for (char character : this.word.toCharArray()) {
            if (guesses.contains(character)) {
                hiddenWord.append(character);
            } else {
                hiddenWord.append("*");
            }
        }

        return hiddenWord.toString();
    }

    public String getWord() {
        return word;
    }

    public String getHiddenWord() {
        return hiddenWord.toString();
    }
}