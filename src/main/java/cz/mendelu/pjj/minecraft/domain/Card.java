package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.CardType;

public class Card {

    //Every card can exist in two states either hidden or shown
    boolean hidden;
    CardType cardType;
    Card(CardType cardType){
        this.hidden  = true;
        this.cardType = cardType;
    }

    public void showCard(){
        this.hidden = false;
    }

    @Override
    public String toString() {
        return "Card{" +
                "hidden=" + hidden +
                '}';
    }
}
