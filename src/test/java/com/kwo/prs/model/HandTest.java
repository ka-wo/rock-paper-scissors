package com.kwo.prs.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @ParameterizedTest
    @MethodSource("generator")
    void isBetterShouldReturnTrueWhenFirstHandWinsWithSecond(Hand hand, Hand otherHand, boolean expectedResult) {
        assertEquals(expectedResult, hand.isBetterThan(otherHand));
    }


    @Test
    void ofShouldReturnEmptyOptionalWhenIncorrectStringProvided() {
        assertFalse(Hand.of("q").isPresent());
    }

    @Test
    void ofShouldReturnCorrectHandWithNoCaseSensitivity() {
        assertEquals(Hand.PAPER, Hand.of("p").get());
        assertEquals(Hand.PAPER, Hand.of("P").get());
        assertEquals(Hand.SCISSORS, Hand.of("s").get());
        assertEquals(Hand.ROCK, Hand.of("r").get());
    }

    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(Hand.PAPER, Hand.PAPER, false),
                Arguments.of(Hand.PAPER, Hand.ROCK, true),
                Arguments.of(Hand.PAPER, Hand.SCISSORS, false),
                Arguments.of(Hand.ROCK, Hand.PAPER, false),
                Arguments.of(Hand.ROCK, Hand.ROCK, false),
                Arguments.of(Hand.ROCK, Hand.SCISSORS, true),
                Arguments.of(Hand.SCISSORS, Hand.PAPER, true),
                Arguments.of(Hand.SCISSORS, Hand.ROCK, false),
                Arguments.of(Hand.SCISSORS, Hand.SCISSORS, false));
    }
}