package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.WeaponType;

public class Weapon extends Card {

    private int power;

    public Weapon(WeaponType weapon_type) {
        switch (weapon_type){
            case STONE_SWORD:
                this.power = 20;
                break;
            case WOODEN_SWORD:
                this.power = 10;
        }

    }

    public int getPower() {
        return power;
    }

}
