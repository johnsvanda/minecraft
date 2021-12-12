package cz.mendelu.pjj.minecraft.greenfoot;

import cz.mendelu.pjj.minecraft.domain.Card;
import cz.mendelu.pjj.minecraft.domain.Monster;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class CardActor extends Actor {

    public Card getCard() {
        return card;
    }

    private Card card;

    CardActor(Card card) {
        this.card = card;
        this.setCard(card);
    }

    public void setCard(Card card) {
        this.card = card;

        var image = new GreenfootImage(MinecraftWorld.CARD_FOLDER + card.toString().toLowerCase() + ".png");
        image.scale(80, 80);

        this.setImage(image);
    }


}
