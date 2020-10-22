package com.kwo.prs.rules;

import com.kwo.prs.model.Hand;

import java.util.function.Predicate;

public class PaperRules implements Predicate<Hand> {

    @Override
    public boolean test(Hand hand) {
        return hand == Hand.ROCK;
    }
}
