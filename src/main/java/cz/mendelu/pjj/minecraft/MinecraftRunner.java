package cz.mendelu.pjj.minecraft;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.minecraft.greenfoot.MinecraftWorld;

/**
 * A sample runner for a greenfoot project.
 */
public class MinecraftRunner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(MinecraftRunner.class,
                // 3. Prepare the configuration for the runner based on the world class
                Configuration.forWorld(MinecraftWorld.class)
                        // Set the project name as you wish
                        .projectName("Minecraft")
                        .hideControls(true)
        );
    }

    public static void main(String[] args) {
        GreenfootRunner.main(args);
    }
}