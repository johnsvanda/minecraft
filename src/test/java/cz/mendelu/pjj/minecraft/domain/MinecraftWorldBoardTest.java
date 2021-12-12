package cz.mendelu.pjj.minecraft.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinecraftWorldBoardTest {

    @org.junit.jupiter.api.Test
    void createNewGame() {
    }

    @org.junit.jupiter.api.Test
    void callEvaluation() {
    }

    @Test
    void testCreateNewGame() {
        // setup
        var grid = Game.createNewGame();
        var blockCube = BlockCube.initBlockCube();
        // then
        assertNotNull(grid);
        assertNotNull(blockCube);
    }


}