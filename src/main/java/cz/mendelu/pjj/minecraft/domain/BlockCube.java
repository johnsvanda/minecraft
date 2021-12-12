package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.BlockType;
import cz.mendelu.pjj.minecraft.greenfoot.MinecraftWorld;

import java.util.*;

public class BlockCube {
    private static BlockCube instance;
    private static ArrayList<Block> blocks;


    BlockCube() {
        instance = null;
        blocks = new ArrayList();
        fillTheCube();
    }

    /**
     * Vygeneruje kostku složenou z náhodně uspořádaných 64 bloků
     * (16x dřevo, 14x písek, 12x kámen, 10x obsidián, 12x smaragd)
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public static BlockCube initBlockCube() {
        if (instance == null) {
            return new BlockCube();
        } else return instance;

    }

    private static void fillTheCube() {

        addMultipleBlocks(blocks, 22, BlockType.WOOD);
        addMultipleBlocks(blocks, 14, BlockType.STONE);
        addMultipleBlocks(blocks, 14, BlockType.SAND);
        addMultipleBlocks(blocks, 4, BlockType.OBSIDIAN);
        addMultipleBlocks(blocks, 10, BlockType.EMERALD);
        Collections.shuffle(blocks);
    }


    private static void addMultipleBlocks(ArrayList<Block> blocks, int howMany, BlockType blockType) {
        for (int i = 0; i < howMany; i++) {
            blocks.add(new Block(blockType));
        }
    }

    public int numberOfBlocks() {
        return instance.blocks.size();
    }

    public ArrayList<Block> removeTwoBlocks() {
        System.out.println(this.numberOfBlocks());
        ArrayList<Block> removedBlocks = new ArrayList();

        //We will be always removing two block at once
        for (int i = 0; i < 2; i++) {
            Block deletedBlock = this.blocks.remove(instance.blocks.size()-1);
            removedBlocks.add(deletedBlock);
        }

        return removedBlocks;
    }

    public void checkIfEvaluation(Game game) {
        if (this.numberOfBlocks() == 48) {
            //Call first evaluation
            System.out.println("First evaluation");
        }
        if (this.numberOfBlocks() == 32) {
            //Call second evaluation
        }
        if (this.numberOfBlocks() == 16) {
            System.out.println("Third evaluation");

            int maxXp = 0;
            Player maxXpPlayer = null;
            for (Player player :
                    game.getPlayers()) {
                if(player.getXp() > maxXp) {
                    maxXp = player.getXp();
                    maxXpPlayer = player;
                }
            }

            System.out.println("Winner is:" + maxXpPlayer.getPlayerType());
        }
    }

    public static void main(String[] args) {
        BlockCube cube = initBlockCube();
        fillTheCube();

        for (Block block : cube.blocks
        ) {
            System.out.println(block);
        }
    }

}
