package AceUno.model;

public class Card {

    private int number;
    private int cardID;
    private String color;


    public Card(int number, int cardID, String color){
        this.number = number;
        this.cardID = cardID;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
