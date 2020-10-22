package com.kwo.prs.model;

import lombok.Data;

@Data
public class Player {
    private String name;
    private Hand selectedHand;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public void win() {
        System.out.println(name + " wins this round!");
        this.score++;
    }

    public void setSelectedHand(Hand selectedHand) {
        System.out.println(name + " shows " + selectedHand.getGesture());
        this.selectedHand = selectedHand;
    }
}
