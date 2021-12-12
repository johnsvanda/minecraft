package cz.mendelu.pjj.minecraft.domain.types;

import java.util.HashMap;
import java.util.Map;

public enum WeaponType {
    POTATOE(0),
    WOODEN_SWORD(1),
    STONE_SWORD(2),
    IRON_SWORD(3),
    BOW(4),
    PICKAXE(5),
    HOE(6);


    private int value;
    private static Map map = new HashMap<>();

    WeaponType(int value) {
        this.value = value;
    }

    static {
        for (WeaponType WeaponType : WeaponType.values()) {
            map.put(WeaponType.value, WeaponType);
        }
    }
    public static WeaponType[] getValues() {
        return WeaponType.values();
    }

    public static WeaponType valueOf(int WeaponType) {
        return (WeaponType) map.get(WeaponType);
    }

    public int getValue() {
        return value;
    }
}
