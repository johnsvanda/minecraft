package cz.mendelu.pjj.minecraft.greenfoot;

import cz.mendelu.pjj.minecraft.domain.Path;
import cz.mendelu.pjj.minecraft.domain.Player;
import cz.mendelu.pjj.minecraft.domain.Weapon;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class PathActor extends Actor {

    private MinecraftWorld world;
    public PathActor(MinecraftWorld world) {
        this.world = world;
        var imageName = MinecraftWorld.CARD_FOLDER + "path" + ".png";
        var image = new GreenfootImage(imageName);
        image.scale(80, 80);
        setImage(image);
    }

    /**
     *
     * Přemístí hráče, pokud je v dosahu PathActora
     *
     * @author xsvanda1
     * @version etapa 4
     */
    public void setPlayer(PlayerActor player) {
        player.setLocation(this.getX(), this.getY());
    }


    /**
     *
     * Otočí horní kartu z Tile, karta přestane být hidden a hráč na ni může reagovat
     *
     * @author xsvanda1
     * @version etapa 4
     */
    public void showNeighbours(){
        for (TileActor tileActor: this.getNeighbours(1, true, TileActor.class)
             ) {
            tileActor.turnCard();
        } for (WeaponActor weaponActor: this.getNeighbours(1, true, WeaponActor.class)
             ) {
            weaponActor.turnCard();
        }
    }

    /**
     *
     * Pokud je v povolené vzdálenosti od Path actora, provede přemístění, ukáže sousední karty a sníží počet akcí o 1
     *
     * @author xsvanda1
     * @version etapa 4
     */
    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            PlayerActor currentPlayer = MinecraftWorld.getCurrentPlayer();
            if(this.getNeighbours(3, false, PlayerActor.class).contains(currentPlayer) && currentPlayer.getPlayer().getNumberOfAvailabeActions() > 0){

                //Move player
                this.setPlayer(currentPlayer);
                //Show 4 cards
                this.showNeighbours();

                //Decrement number of actions
                currentPlayer.getPlayer().decrementNumberofAvailableActions();
                this.world.updateNumberOfAvailableActions();
            };

        }

    }
}
