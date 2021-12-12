package cz.mendelu.pjj.minecraft.domain.types;

import java.util.HashMap;
import java.util.Map;

public enum BiomType {
    FOREST (0), DESERT(1), MOUNTAINS(2), TUNDRA(3);

    private int value;
    private static Map map = new HashMap<>();

    BiomType(int value) {
        this.value = value;
    }

    static {
        for (BiomType BiomType : BiomType.values()) {
            map.put(BiomType.value, BiomType);
        }
    }

    public static BiomType valueOf(int BiomType) {
        return (BiomType) map.get(BiomType);
    }

    public int getValue() {
        return value;
    }
}
