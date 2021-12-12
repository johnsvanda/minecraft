package cz.mendelu.pjj.minecraft.domain;


import java.util.Stack;

//A set of sixty-four cards which are divided into sixteen stacks of four cards each. Half contain buildings, and the other half contain hostile mobs.
public class Tile {
    Stack<Card> cards;

    Tile(Card[] cards) {
        this.cards = new Stack<>();
        for (Card card : cards
        ) {
            this.cards.push(card);
        }
    }

    public Stack<Card> getCards() {
        return this.cards;
    }

    public Card removeTopCard() {
        return this.cards.pop();
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }
}
