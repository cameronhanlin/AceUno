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

    @RequestMapping("/")
    public String displayHomepage(){
        dealer.dealHands();
        return "home";
    }

    @RequestMapping("/player1/{cardID}")
    public String displayPlayer1(@PathVariable int cardID, ModelMap modelmap) {
        if (cardID == 98){
            dealer.drawCard(3);
        }
        if (cardID >=0 && cardID <=55){
            dealer.discardCard(3, cardID);
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
            dealer.discardCard(1, cardID);
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
            dealer.discardCard(2, cardID);
        }
        modelmap.put("player3Hand", dealer.getPlayerHand(3));
        modelmap.put("topDiscardCard", dealer.getTopDiscardCard());
        return "player3";
    }


    @RequestMapping("/rules")
    public String displayRules(ModelMap modelMap) {
        return "rules";
    }


}
