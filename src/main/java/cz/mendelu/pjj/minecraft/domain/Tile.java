package cz.mendelu.pjj.minecraft.domain;


//A set of sixty-four cards which are divided into sixteen stacks of four cards each. Half contain buildings, and the other half contain hostile mobs.
public class Tile {
    Card[] cards;

    Tile() {
        this.cards = new Card[4];
        boolean even = true;
        for (Card card : this.cards) {
            card = even ? new Monster(0) : new Building();
            even = !even;
        }
    }

    public Card showCard(Card hiddenCard) {
        hiddenCard.showCard();
        return  hiddenCard;
    }

    public Card removeCard(Card targetCard) {
        Card removedCard = this.cards[cards.length];
        this.cards[cards.length] = null;
        return removedCard;
    }
}
