package com.codeclan.example.hangman;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 28/06/2017.
 */

public class TestGame {
    Player player;
    Word word;
    Game game;

    @Before
    public void setUp() throws Exception {
        player = new Player();
        word = new Word("HelloWorld");
        game = new Game(word, player);
    }

    @Test
    public void testGameIsNotWon() throws Exception {
        assertEquals(false, game.getIsWon());
    }

    @Test
    public void testInitialGuessesSize() throws Exception {
        assertEquals(0, game.getGuesses().size());
    }

    @Test
    public void testAddGuess() throws Exception {
        game.addGuess('h');
        assertEquals(1, game.getGuesses().size());
    }

    @Test
    public void testUpdate() throws Exception {
        game.addGuess('h');
        String expected = "h*********\nYou have 6 lives remaining.";
        assertEquals(expected, game.update());
    }

    @Test
    public void testWinGame() throws Exception {
        for(Character c: word.getWord().toCharArray()){
            game.addGuess(c);
        }
        game.update();
        assertEquals(true, game.getIsWon());
    }
}