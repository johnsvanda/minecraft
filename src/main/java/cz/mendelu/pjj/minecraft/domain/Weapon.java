package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.CardType;
import cz.mendelu.pjj.minecraft.domain.types.WeaponType;

public class Weapon extends Card {

    private int hearts;

    public Weapon(int weaponTypeValue) {

        super(CardType.WEAPON);
        WeaponType weaponType = WeaponType.valueOf(weaponTypeValue);
        initWeapon(weaponType);
    }

    public Weapon(WeaponType weaponType) {
        super(CardType.WEAPON);
        initWeapon(weaponType);
    }

    private void initWeapon(WeaponType weaponType) {
        switch (weaponType) {
            case IRON_SWORD:_SWORD:
                this.hearts = 4;
                break;

            case STONE_SWORD:
                this.hearts = 2;
                break;

            case WOODEN_SWORD:
                this.hearts = 1;
                break;

            case POTATOE:
                this.hearts = 0;
                break;
        }
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "hearts=" + hearts +
                '}';
    }

    public int getHearts() {
        return hearts;
    }

}
