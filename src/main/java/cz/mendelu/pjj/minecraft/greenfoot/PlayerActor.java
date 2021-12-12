package cz.mendelu.pjj.minecraft.greenfoot;

import cz.mendelu.pjj.minecraft.domain.Player;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class PlayerActor extends Actor {

    public Player getPlayer() {
        return player;
    }

    private Player player;
    private int numberOfAllowedActions = 2;

    PlayerActor(Player player) {
        this.player = player;
        this.setImage();
    }

    @Override
    public void act() {

    }

    /**
     *
     * Metoda slouží pro indikaci aktivního hráče
     *
     * @author xsvanda1
     * @version etapa 4
     */
    public void select(){
        var image = new GreenfootImage(MinecraftWorld.CARD_FOLDER + this.player.toString().toLowerCase() + "-selected.png");
        image.scale(70, 80);
        this.setImage(image);

    }


    /**
     *
     * Metoda nastaví obrázek hráči, dle jeho barvy
     *
     * @author xsvanda1
     * @version etapa 4
     */
    public void setImage(){
        var image = new GreenfootImage(MinecraftWorld.CARD_FOLDER + this.player.toString().toLowerCase() + ".png");
        image.scale(70, 80);
        this.setImage(image);
    }
}
