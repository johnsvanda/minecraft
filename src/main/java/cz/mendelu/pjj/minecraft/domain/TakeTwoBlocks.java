package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.Action;
import cz.mendelu.pjj.minecraft.domain.BlockCube;
import cz.mendelu.pjj.minecraft.domain.Player;
import cz.mendelu.pjj.minecraft.greenfoot.MinecraftWorld;

import static cz.mendelu.pjj.minecraft.greenfoot.MinecraftWorld.blockCube;

public class TakeTwoBlocks implements Action {
    private String name;

    TakeTwoBlocks(){
        setName("Take two blocks");
    }

    @Override
    public void makeAction(Game game, Player player) {
        player.getInHand().addAll(blockCube.removeTwoBlocks());
        player.decrementNumberofAvailableActions();
        blockCube.checkIfEvaluation(game);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
