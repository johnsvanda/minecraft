package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.*;

import java.util.Random;

public class Building extends Card {
    Building(int buildingTypeValue) {
        initBuilding(BuildingType.valueOf(buildingTypeValue), BiomType.valueOf(new Random().nextInt(BiomType.values().length)));
    }

    public int getXp() {
        return xp;
    }

    private int xp;

    public Block[] getBlocks() {
        return blocks;
    }

    private Block blocks[];

    public BuildingType getBuildingType() {
        return buildingType;
    }

    private BuildingType buildingType;
    private BiomType biomType;

    private void initBuilding(BuildingType buildingType, BiomType biomType) {
        switch (buildingType) {
            case BRIDGE:
                this.xp = 4;
                this.blocks = new Block[]{new Block(BlockType.OBSIDIAN), new Block((BlockType.SAND)), new Block(BlockType.WOOD), new Block(BlockType.WOOD), new Block(BlockType.WOOD)};
                super.setCardType(BuildingType.BRIDGE);
                this.biomType = biomType;
                break;

            case ANIMAL_ENCLOUSURE:
                this.xp = 3;
                this.blocks = new Block[]{new Block(BlockType.STONE), new Block(BlockType.WOOD), new Block(BlockType.WOOD)};
                super.setCardType(BuildingType.ANIMAL_ENCLOUSURE);
                break;

            case RESIDENTAL_HOUSE:
                this.xp = 2;
                this.blocks = new Block[]{new Block(BlockType.WOOD), new Block(BlockType.WOOD)};
                super.setCardType(BuildingType.RESIDENTAL_HOUSE);
                break;

            case DECORATION:
                this.xp = 1;
                this.blocks = new Block[]{new Block(BlockType.WOOD)};
                super.setCardType(BuildingType.DECORATION);
                break;
        }
    }
    @Override
    public String toString() {
        return "" + super.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
       Building building = (Building) o;
         if(building.getBuildingType() == super.getCardType()){
             return true;
         }
         return true;
    }
}
