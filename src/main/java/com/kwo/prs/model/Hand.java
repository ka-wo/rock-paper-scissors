package com.kwo.prs.model;

import com.kwo.prs.rules.PaperRules;
import com.kwo.prs.rules.RockRules;
import com.kwo.prs.rules.ScissorsRules;

import java.util.Optional;
import java.util.function.Predicate;

public enum Hand {
    PAPER("p", "open hand (Paper)", new PaperRules()),
    ROCK("r", "fist (Rock)", new RockRules()),
    SCISSORS("s", "index and middle finger (Scissors)", new ScissorsRules());

    private String selector, gesture;
    private Predicate<Hand> isBetter;

    Hand(String selector, String gesture, Predicate<Hand> isBetter) {
        this.selector = selector;
        this.gesture = gesture;
        this.isBetter = isBetter;
    }

    public static Optional<Hand> of(String s) {
        for(Hand hand: Hand.values()) {
            if(hand.selector.equalsIgnoreCase(s))
                return Optional.of(hand);
        }
        return Optional.empty();
    }

    public String getGesture() {
        return gesture;
    }

    /**
     * @return true when the hand invoking the method wins with the other hand, false otherwise
     */
    public boolean isBetterThan(Hand otherHand) {
        return this.isBetter.test(otherHand);
    }
}
