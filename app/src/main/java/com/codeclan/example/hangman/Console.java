package com.codeclan.example.hangman;

import java.util.Scanner;

public class Console {
    Scanner sc;
    String data;

    public void start() {
        System.out.println("Please enter the word: ");

        sc = new Scanner(System.in);
        data = sc.nextLine();

        // Works nicely in the real termimal, not so much in the AS terminal :(
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Word word = new Word(data);
        Player player = new Player();
        Game game = new Game(word, player);

        while (!player.isDead() && !game.getIsWon()) {
            System.out.println("Enter your guess:");

            data = sc.nextLine();

            char[] guessArray = data.toCharArray();
            Character guess = new Character(guessArray[0]);

            game.addGuess(guess);

            System.out.println(game.update());
        }

        if (game.getIsWon()) {
            System.out.println("A WINNER IS YOU!!!");
        } else {
            System.out.println("YOU FEEL THE AIR SLIPPING FROM YOUR LUNGS BEFORE EMBRACING THE SWEET DARKNESS.");
        }
    }
}