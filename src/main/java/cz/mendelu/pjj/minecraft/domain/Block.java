package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.BlockType;
import cz.mendelu.pjj.minecraft.domain.types.WeaponType;

public class Block extends Card {
    BlockType blockType;

    public BlockType getBlockType() {
        return blockType;
    }

    Block(BlockType blockType) {
        this.blockType = blockType;
        super.setCardType(blockType);
    }

    @Override
    public String toString() {
        return "" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o.getClass() == Block.class) {
            Block block = (Block) o;
            if (block.getBlockType() == super.getCardType() || super.getCardType() == BlockType.EMERALD) {
                return true;
            }
        }

        return false;
    }
}
