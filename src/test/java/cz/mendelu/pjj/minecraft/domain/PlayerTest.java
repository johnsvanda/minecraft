package cz.mendelu.pjj.minecraft.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getAvailableActions() {
        // setup
        var player = new Player(Color.RED);
        var actions = player.getAvailableActions();

        //then
        assertNotEquals(
                actions.length,
                0
        );

    }

    @Test
    void takeTwoBlocks() {
        //setup
        var cube = BlockCube.generateBlockCube();
        var player = new Player(Color.RED);
        var originalLength = cube.length;

        //when
        player.takeTwoBlocks();

        //then
        assertEquals(cube.length, originalLength - 2);
    }

    @Test
    void fight() {
        //setup
        var player = new Player(Color.RED);
        var monster = new Monster(10);

        //when
        int playerHearts = player.getHearts();
        int monsterHearts =monster.getHearts();

        if(playerHearts <  monsterHearts){
            assertThrows(CantFightException.class, (Executable) player.fight(monster));
        }
    }

}