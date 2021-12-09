package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.BlockType;

public class Block {
    BlockType blockType;

    Block(BlockType blockType) {
        this.blockType = blockType;

    }
    @Override
    public String toString(){
        return String.valueOf(this.blockType);
    }
}
