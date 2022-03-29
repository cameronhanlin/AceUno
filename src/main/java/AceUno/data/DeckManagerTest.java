package AceUno.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckManagerTest {

//    @Test
//    void drawCard() {
//    }
//
//    @Test
//    void getPlayerHand() {
//    }
//
//    @Test
//    void getTopDiscardCard() {
//    }

    @Test
    void checkIs0ForNoWinner() {
        //Arrange
        DeckManager deckManager = new DeckManager();
        deckManager.dealHands();
        //Act
        int result = deckManager.checkWinner();

        //Assert
        assertEquals(result, 0);
    }
}