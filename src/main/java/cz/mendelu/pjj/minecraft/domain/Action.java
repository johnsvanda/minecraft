package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.greenfoot.MinecraftWorld;

public interface Action<C> {

    public void makeAction(Game game, Player player);
    public void setName(String name);
    public String getName();
}
