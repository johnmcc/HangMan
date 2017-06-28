package com.codeclan.example.hangman;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 28/06/2017.
 */

public class TestWord {
    Word word;

    @Before
    public void setUp() throws Exception {
        word = new Word("HelloWorld");
    }

    @Test
    public void testGetWord() throws Exception {
        assertEquals("helloworld", word.getWord());
    }

    @Test
    public void testGetHiddenWord() throws Exception {
        assertEquals("**********", word.getHiddenWord());
    }

    @Test
    public void testGuessRevealsLetter() throws Exception {
        ArrayList<Character> guesses = new ArrayList<Character>();
        guesses.add('h');
        word.update(guesses);
        assertEquals("h*********", word.getHiddenWord());
    }

    @Test
    public void testAllGuessesRevealsWord() throws Exception {
        ArrayList<Character> guesses = new ArrayList<Character>(Arrays.asList('h', 'e', 'l', 'o', 'w', 'r', 'd'));
        word.update(guesses);
        assertEquals("helloworld", word.getHiddenWord());
    }
}
