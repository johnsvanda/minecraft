package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.CardType;

abstract public class Card<C> {

    private C cardType;

     //Every card can exist in two states either hidden or shown
    private boolean hidden;

    Card(){
        this.hidden  = true;
    }

    public boolean isHidden() {
        return hidden;
    }

    public C getCardType() {
        return this.cardType;
    }

    public void setCardType(C cardType) {
        this.cardType = cardType;
    }

    public void showCard(){
        this.hidden = false;
    }

    @Override
    public String toString() {
        return "" + this.cardType;
    }

}
