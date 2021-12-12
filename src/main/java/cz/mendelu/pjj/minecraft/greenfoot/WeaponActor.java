package cz.mendelu.pjj.minecraft.greenfoot;

import cz.mendelu.pjj.minecraft.domain.Card;
import cz.mendelu.pjj.minecraft.domain.Game;
import cz.mendelu.pjj.minecraft.domain.Tile;
import cz.mendelu.pjj.minecraft.domain.types.CardType;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class WeaponActor extends Actor {

    private Tile weapon;

    public WeaponActor() {
        this.weapon = Game.createTileWithCards(CardType.WEAPON);

        var image = new GreenfootImage(MinecraftWorld.CARD_FOLDER + "weapon" + ".png");
        image.scale(70, 70);

        this.setImage(image);
    }

    public void turnCard(){
        CardActor cardActor = new CardActor(this.weapon.getCards().peek());
        Card card = cardActor.getCard();
        if(card.isHidden()) {
            card.showCard();
            var imageName = MinecraftWorld.CARD_FOLDER + ((this.weapon.isEmpty()) ? "no_card.png" : card.getCardType().toString().toLowerCase() + ".png");
            var image = new GreenfootImage(imageName);
            image.scale(70, 70);
            setImage(image);
        }

    }

    private void move(){

    }


}
