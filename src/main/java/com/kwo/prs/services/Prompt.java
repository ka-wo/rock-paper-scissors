package com.kwo.prs.services;

import com.kwo.prs.model.Hand;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Prompt {

    private final Scanner in = new Scanner(System.in);

    public int requestNumberOfGames() {
        System.out.print("How many times do you want to play? ");
        int numberOfGames = getNumberOfGames();

        if (numberOfGames <= 0) {
            System.out.println("The number of games to play should be higher than 0");
            return requestNumberOfGames();
        }

        return numberOfGames;
    }

    private int getNumberOfGames() {
        try {
            return in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Only number between 0 and " + Integer.MAX_VALUE + " is allowed");
            System.out.println();
            in.next();
            return requestNumberOfGames();
        }
    }

    public Hand requestHandSelection() {
        System.out.print("Please select your hand for this turn (r - Rock, p - Paper, s - Scissors): ");
        String playersHand = in.next();

        Optional<Hand> hand = Hand.of(playersHand);

        if (hand.isPresent())
            return hand.get();

        System.out.println("Invalid selection of hand, allowed values are: r, p, s");
        return requestHandSelection();
    }

}
