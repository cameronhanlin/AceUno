package AceUno.data;

import AceUno.model.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
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

        cardToPull = rand.nextInt(drawPile.size());
        discardPile.add(drawPile.get(cardToPull));
        drawPile.remove(cardToPull);

    }

    //pick up 1 from draw pile
    public void drawCard(int playerNum){
        int cardToPull;

        cardToPull = rand.nextInt(drawPile.size()); //randomly selecting card
        if (playerNum == 1){
            player1.add(drawPile.get(cardToPull)); //add to player hand
        }
        if (playerNum == 2){
            player2.add(drawPile.get(cardToPull)); //add to player hand
        }
        if (playerNum == 3){
            player3.add(drawPile.get(cardToPull)); //add to player hand
        }
        drawPile.remove(cardToPull);
    }

    public void drawTwo(int playerNum){
        drawCard(playerNum);
        drawCard(playerNum);
    }


    //remove from player hand and add to discard

    public void discardCard(int playerNum, int cardID){
        int handPlace = 0;

        if(playerNum == 1){
            while(!(player1.get(handPlace).getCardID() == cardID)){
                handPlace++;
            }
            discardPile.add(player1.get(handPlace));
            player1.remove(handPlace);
        }
        if(playerNum == 2){
            while(!(player2.get(handPlace).getCardID() == cardID)){
                handPlace++;
            }
            discardPile.add(player1.get(handPlace));
            player2.remove(handPlace);
        }
        if(playerNum == 3){
            while(!(player3.get(handPlace).getCardID() == cardID)){
                handPlace++;
            }
            discardPile.add(player1.get(handPlace));
            player3.remove(handPlace);
        }


    }
    //refresh draw deck
    public void resetDeck () {
        drawPile.addAll(discardPile);
        discardPile.clear();
    }


}
