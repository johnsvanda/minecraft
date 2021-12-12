package cz.mendelu.pjj.minecraft.greenfoot;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;
import java.util.function.Supplier;

public class LabelActor extends Actor {

    private Supplier action;
    private MinecraftWorld world;
    public LabelActor(String label) {
        setLabel(label);
    }

    public LabelActor(MinecraftWorld world, String label, Supplier action) {
        this.world = world;
        setLabel(label);
        setAction(action);
    }

    public void setLabel(String label) {
        var image = new GreenfootImage(label, 32, Color.BLACK, null);
        this.setImage(image);
    }

    public void setAction(Supplier action) {
        this.action = action;
    }

    /**
     * Metoda příjmá action, která se má po nastavení provolat při kliknutí na LabelActor
     *
     * @author xsvanda1
     * @version etapa 5
     */
    @Override
    public void act() {
        if (action != null && MinecraftWorld.getCurrentPlayer().getPlayer().getNumberOfAvailabeActions() > 0 && Greenfoot.mouseClicked(this)) {
            this.world.updatenumberOfBlocksInCubeLabel();
            var result = action.get();
            if (result != null) {
                setLabel(result.toString());
            }
        }
    }
}
