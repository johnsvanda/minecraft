package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.BiomType;
import cz.mendelu.pjj.minecraft.domain.types.BlockType;
import cz.mendelu.pjj.minecraft.domain.types.BuildingType;
import cz.mendelu.pjj.minecraft.domain.types.CardType;

public class Building extends Card {
    Building(int buildingTypeValue) {
        super(CardType.BUILDING);
        BuildingType buildingType = BuildingType.valueOf(buildingTypeValue);
        initBuilding(buildingType, BiomType.DESERT);
    }


    private int xp;
    private Block blocks[];
    private BuildingType buildingType;
    private BiomType biomType;

    private void initBuilding(BuildingType buildingType, BiomType biomType) {
        switch (buildingType) {
            case BRIDGE:
                this.xp = 4;
                this.blocks = new Block[]{new Block(BlockType.OBSIDIAN), new Block((BlockType.SAND)), new Block(BlockType.WOOD), new Block(BlockType.WOOD), new Block(BlockType.WOOD)};
                this.buildingType = BuildingType.BRIDGE;
                this.biomType = biomType;
                break;

            case ANIMAL_ENCLOUSURE:
                this.xp = 3;
                this.blocks = new Block[]{new Block(BlockType.STONE), new Block(BlockType.WOOD), new Block(BlockType.WOOD)};
                this.buildingType = BuildingType.ANIMAL_ENCLOUSURE;
                break;

            case RESIDENTAL_HOUSE:
                this.xp = 2;
                this.blocks = new Block[]{new Block(BlockType.WOOD), new Block(BlockType.WOOD)};
                this.buildingType = BuildingType.RESIDENTAL_HOUSE;
                break;

            case DECORATION:
                this.xp = 1;
                this.blocks = new Block[]{new Block(BlockType.STONE)};
                this.buildingType = BuildingType.DECORATION;
                break;
        }
    }
}
