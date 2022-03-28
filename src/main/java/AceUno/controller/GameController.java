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
        modelmap.put("player1Hand", dealer.getPlayerHand(1));
        modelmap.put("topDiscardCard", dealer.getTopDiscardCard());
        return "player1";
    }


    @RequestMapping("/player2/{cardID}")
    public String displayPlayer2(@PathVariable int cardID, ModelMap modelmap) {
        return "player2";
    }


    @RequestMapping("/player3/{cardID}")
    public String displayPlayer3(@PathVariable int cardID, ModelMap modelmap) {
        return "player3";
    }


    @RequestMapping("/rules")
    public String displayRules(ModelMap modelMap) {
        return "rules";
    }


}
