package cz.mendelu.pjj.minecraft.domain;

public class Card {

    //Every card can exist in two states either hidden or shown
    //A set of sixty-four cards which are divided into sixteen stacks of four cards each. Half contain buildings, and the other half contain hostile mobs.
    boolean hidden;

    Card(){
        this.hidden  = true;
    }

    public void showCard(){
        this.hidden = false;
    }
}
