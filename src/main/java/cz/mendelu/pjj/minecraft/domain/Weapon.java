package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.WeaponType;

public class Weapon extends Card {

    private int hearts;

    public Weapon(int weaponTypeValue) {
        initWeapon(WeaponType.valueOf(weaponTypeValue));
    }

    public Weapon(WeaponType weaponType) {
        initWeapon(weaponType);
    }

    private void initWeapon(WeaponType weaponType) {
        switch (weaponType) {
            case IRON_SWORD:
                this.hearts = 4;
                super.setCardType(WeaponType.IRON_SWORD);
                break;

            case STONE_SWORD:
                this.hearts = 2;
                super.setCardType(WeaponType.STONE_SWORD);
                break;

            case WOODEN_SWORD:
                this.hearts = 1;
                super.setCardType(WeaponType.WOODEN_SWORD);
                break;

            case POTATOE:
                this.hearts = 0;
                super.setCardType(WeaponType.POTATOE);
                break;

            case BOW:
                this.hearts = 2;
                super.setCardType(WeaponType.BOW);
                break;

            case HOE:
                this.hearts = 2;
                super.setCardType(WeaponType.HOE);
                break;

            case PICKAXE:
                this.hearts = 2;
                super.setCardType(WeaponType.PICKAXE);
                break;


        }
    }

    @Override
    public String toString() {
        return "" + super.toString();
    }

    public int getHearts() {
        return hearts;
    }

}
