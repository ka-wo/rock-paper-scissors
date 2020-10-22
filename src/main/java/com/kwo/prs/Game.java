package com.kwo.prs;

import com.kwo.prs.model.Player;
import com.kwo.prs.services.HandGenerator;
import com.kwo.prs.services.Prompt;

import java.util.Optional;

public class Game {
    private final Prompt prompt;

    public Game(Prompt prompt) {
        this.prompt = prompt;
    }

    public void startGame() {
        int numberOfGames = prompt.requestNumberOfGames();

        Player humanPlayer = new Player("Human");
        Player computerPlayer = new Player("Computer");

        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("Game: " + (i + 1));

            chooseHands(humanPlayer, computerPlayer);

            determineWinner(humanPlayer, computerPlayer)
                    .ifPresent(Player::win);
        }

        announceWinner(humanPlayer, computerPlayer);
    }

    private void announceWinner(Player player1, Player player2) {
        if (player1.getScore() == player2.getScore())
            System.out.println("It's a tie! You both won " + player1.getScore() + " times.");

        Player winner = player1.getScore() > player2.getScore()
                ? player1
                : player2;
        System.out.println(winner.getName() + " won the match with " + winner.getScore() + " wins!");
    }

    private Optional<Player> determineWinner(Player p1, Player p2) {
        if (p1.getSelectedHand() == p2.getSelectedHand()) {
            System.out.println("It's a tie!");
            return Optional.empty();
        }

        return p1.getSelectedHand().isBetterThan(p2.getSelectedHand())
                ? Optional.of(p1)
                : Optional.of(p2);
    }

    private void chooseHands(Player human, Player computer) {
        human.setSelectedHand(prompt.requestHandSelection());
        computer.setSelectedHand(HandGenerator.getRandomHand());
    }
}
