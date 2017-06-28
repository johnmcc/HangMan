package com.codeclan.example.hangman;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by user on 28/06/2017.
 */

public class TestPlayer {
    Player player;

    @Before
    public void before(){
        player = new Player();
    }

    @Test
    public void testPlayerIsNotInitiallyDead() throws Exception {
        assertFalse(player.isDead());
    }

    @Test
    public void testPlayerInitialLives() throws Exception {
        assertEquals(6, player.getNumLives());
    }

    @Test
    public void testPlayerLoseLife() throws Exception {
        player.loseLife();
        assertEquals(5, player.getNumLives());
    }

    @Test
    public void testKillPlayer() throws Exception {
        for(int i=0; i<=5; i++){
            player.loseLife();
        }
        assertEquals(true, player.isDead());
    }
}
