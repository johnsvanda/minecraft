package cz.mendelu.pjj.minecraft.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @org.junit.jupiter.api.Test
    void createNewGame() {
    }

    @org.junit.jupiter.api.Test
    void callEvaluation() {
    }

    @Test
    void testCreateNewGame() {
        // setup
        var grid = GameBoard.createNewGame();
        var blockCube = BlockCube.generateBlockCube();
        // then
        assertNotNull(grid);
        assertNotNull(blockCube);
    }

    @Test
    void getTile() {
        //setup
        var grid =  GameBoard.createNewGame();
        //when
        var tile = GameBoard.getTile(0,0);
        //then
        assertNotNull(tile);
    }
}