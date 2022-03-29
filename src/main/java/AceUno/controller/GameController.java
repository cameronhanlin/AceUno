package AceUno.controller;

import AceUno.data.DeckManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @Autowired
    DeckManager dealer = new DeckManager();

    private boolean isReversed = false;

    @RequestMapping("/")
    public String displayHomepage(){
        dealer.clearDeck();
        dealer.dealHands();
        return "home";
    }

    @RequestMapping("/player1/{cardID}")
    public String displayPlayer1(@PathVariable int cardID, ModelMap modelmap) {
        if (cardID == 98){
            dealer.drawCard(3);
        }
        if (cardID >=0 && cardID <=55){
            if (cardID == 12 || cardID == 25 || cardID == 38 || cardID == 51) {   //12, 25, 38, 51 are reverse cards
                isReversed = !isReversed;
            }
            dealer.discardCard(3, cardID);
        }
        if (dealer.checkWinner() !=0){
            modelmap.put("noWinner", false);
        } else {
            modelmap.put("noWinner", true);
        }
        if (!isReversed) {
            modelmap.put("nextPlayerTurn", "player2");
        } else {                                               //REVERSE CARD
            modelmap.put("nextPlayerTurn", "player3");
        }
        modelmap.put("player1Hand", dealer.getPlayerHand(1));
        modelmap.put("topDiscardCard", dealer.getTopDiscardCard());
        return "player1";
    }


    @RequestMapping("/player2/{cardID}")
    public String displayPlayer2(@PathVariable int cardID, ModelMap modelmap) {
        if (cardID == 98){
            dealer.drawCard(1);
        }
        if (cardID >=0 && cardID <=55){
            if (cardID == 12 || cardID == 25 || cardID == 38 || cardID == 51) {   //12, 25, 38, 51 are reverse cards
                isReversed = !isReversed;
            }
            dealer.discardCard(1, cardID);
        }
        if (dealer.checkWinner() !=0){
            modelmap.put("noWinner", false);
        } else {
            modelmap.put("noWinner", true);
        }
        if (!isReversed) {
            modelmap.put("nextPlayerTurn", "player3");
        }
        else {                                               //REVERSE CARD
            modelmap.put("nextPlayerTurn", "player1");
        }
        modelmap.put("player2Hand", dealer.getPlayerHand(2));
        modelmap.put("topDiscardCard", dealer.getTopDiscardCard());
        return "player2";
    }


    @RequestMapping("/player3/{cardID}")
    public String displayPlayer3(@PathVariable int cardID, ModelMap modelmap) {
        if (cardID == 98){
            dealer.drawCard(2);
        }
        if (cardID >=0 && cardID <=55){
            if (cardID == 12 || cardID == 25 || cardID == 38 || cardID == 51) {   //12, 25, 38, 51 are reverse cards
                isReversed = !isReversed;
            }
            dealer.discardCard(2, cardID);
        }
        if (dealer.checkWinner() !=0){
            modelmap.put("noWinner", false);
        } else {
            modelmap.put("noWinner", true);
        }
        if (!isReversed) {
            modelmap.put("nextPlayerTurn", "player1");
        }
        else {                                               //REVERSE CARD
            modelmap.put("nextPlayerTurn", "player2");
        }
        modelmap.put("player3Hand", dealer.getPlayerHand(3));
        modelmap.put("topDiscardCard", dealer.getTopDiscardCard());
        return "player3";
    }


    @RequestMapping("/rules")
    public String displayRules(ModelMap modelmap) {
        return "rules";
    }


    @RequestMapping("/winner")
    public String displayWinner(ModelMap modelmap) {
        int winner = dealer.checkWinner();
        if (winner == 1) {
            modelmap.put("winnerName", "Andrea");
        }
        else if (winner == 2) {
            modelmap.put("winnerName", "Cameron");
        }
        else if (winner == 3) {
            modelmap.put("winnerName", "Elissa");
        }
        else {
            modelmap.put("winnerName", "no winner, keep playing!");
        }
        return "winner";
    }
}
