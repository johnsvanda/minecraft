package cz.mendelu.pjj.minecraft.domain;


import jdk.jshell.spi.ExecutionControl;

import java.util.Stack;

//A set of sixty-four cards which are divided into sixteen stacks of four cards each. Half contain buildings, and the other half contain hostile mobs.
public class Tile {
    Stack<Card> cards;

    Tile(Card [] cards) {
        this.cards = new Stack<>();
        for (Card card: cards
             ) {
            //System.out.println(card.getClass());
            addCardToTile(card);
        }
    }

    private void addCardToTile(Card card) {
        if (this.cards.size() < 5) this.cards.push(card);
    }

    private Card removeCardFromTile() {
         return this.cards.pop();
    }

    public Card showCard(Card hiddenCard) {
        hiddenCard.showCard();
        return hiddenCard;
    }


}
