package com.kwo.prs.services;

import com.kwo.prs.model.Hand;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class HandGenerator {

    private static List<Hand> allHands = Arrays.asList(Hand.values());

    public static Hand getRandomHand() {
        // Shuffle instead of using Random.nextInt() to get a random hand - for better performance
        Collections.shuffle(allHands);
        return allHands.get(0);
    }
}
