package AceUno.controller;

import AceUno.data.DeckManager;
import org.springframework.web.bind.annotation.RequestMapping;

public class GameController {

    DeckManager dealer = new DeckManager();

    @RequestMapping("/")
    public String displayHomepage(){

        dealer.dealHands();
        return "home";
    }


}
