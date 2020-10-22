package com.kwo.prs;

import com.kwo.prs.model.Hand;
import com.kwo.prs.services.Prompt;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PromptTest {

    @AfterEach
    void cleanup( ){
        try {
            System.in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void normalResponseToPromptShouldReturnProvidedNumberOfGames() {
        prepareInputStream("5");

        assertEquals(5, new Prompt().requestNumberOfGames());
    }

    @Test
    void incorrectResponseToPromptShouldPromptAgainAndReturnFirstNormalAnswerReceived() {
        prepareInputStream("dasdsad\n3");

        assertEquals(3, new Prompt().requestNumberOfGames());
    }

    @Test
    void incorrectResponseToPromptShouldPromptAgainAndReturnFirstCorrectlySelectedHand() {
        prepareInputStream("dasdsad\nr");

        assertEquals(Hand.ROCK, new Prompt().requestHandSelection());
    }

    @Test
    void correctHandSelectionShouldReturnSelectedHand() {
        prepareInputStream("s");

        assertEquals(Hand.SCISSORS, new Prompt().requestHandSelection());
    }

    private void prepareInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}