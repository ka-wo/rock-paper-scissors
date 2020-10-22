package com.kwo.prs;

import com.kwo.prs.model.Hand;
import com.kwo.prs.services.Prompt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @Mock
    private Prompt prompt;

    private Game game;

    @BeforeEach
    void setup() {
        game = new Game(prompt);
        when(prompt.requestNumberOfGames()).thenReturn(3);
        when(prompt.requestHandSelection()).thenReturn(Hand.PAPER);
    }

    @Test
    void numberOfGamesShouldBeCalledJustOnceInAGame() {
        game.startGame();

        verify(prompt, times(1)).requestNumberOfGames();
    }

    @Test
    void numberOfHandsSelectionShouldBeTheSameAsSelectedByNumberOfGames() {
        game.startGame();

        verify(prompt, times(3)).requestHandSelection();
    }

}