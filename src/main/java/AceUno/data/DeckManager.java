package AceUno.data;

import AceUno.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckManager {

    List<Card> drawPile = new ArrayList<>();
    List<Card> discardPile = new ArrayList<>();
    List<Card> player1 = new ArrayList<>();
    List<Card> player2 = new ArrayList<>();
    List<Card> player3 = new ArrayList<>();
    String[] colors = {"Red","Yellow","Green","Blue"};
    Random rand = new Random();

    int cardCount = 1;

    public DeckManager(){
        for(int j=0; j<colors.length; j++){
            for(int i=-3; i<10; i++){
                drawPile.add(new Card(i, cardCount, colors[j]));
                drawPile.add(new Card(i, cardCount, colors[j]));
                cardCount++;
            }
        }

        ///add in wild here??
        Collections.shuffle(drawPile);

    }

    public void dealHands(){
        int cardToPull;

        for(int i =0; i<7; i++){
            cardToPull = rand.nextInt(drawPile.size()); //randomly selecting card
            player1.add(drawPile.get(cardToPull)); //add to player hand
            drawPile.remove(cardToPull); //remove from the drawpile
        }
        for(int i =0; i<7; i++){
            cardToPull = rand.nextInt(drawPile.size());
            player2.add(drawPile.get(cardToPull));
            drawPile.remove(cardToPull);
        }
        for(int i =0; i<7; i++){
            cardToPull = rand.nextInt(drawPile.size());
            player3.add(drawPile.get(cardToPull));
            drawPile.remove(cardToPull);
        }
    }


}
