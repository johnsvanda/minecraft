package cz.mendelu.pjj.minecraft.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockCubeTest {

    @Test
    void generateBlockCube() {
        // setup
        var blockCube = BlockCube.generateBlockCube();
        int wood = 16;
        int sand = 14;
        int stone = 12;
        int obsidian = 10;
        int emerald = 12;

        // then
        assertNotNull(blockCube);
        assertEquals(64, blockCube.length);


        for (Block block: blockCube) {
            if(block.blockType.equals(BlockType.WOOD)) wood--;
            if(block.blockType.equals(BlockType.SAND)) sand--;
            if(block.blockType.equals(BlockType.STONE)) stone--;
            if(block.blockType.equals(BlockType.OBSIDIAN)) obsidian--;
            if(block.blockType.equals(BlockType.EMERALD)) emerald--;
        }
            assertEquals(wood,0);
            assertEquals(sand,0);
            assertEquals(stone,0);
            assertEquals(obsidian,0);
            assertEquals(emerald,0);
    }
}