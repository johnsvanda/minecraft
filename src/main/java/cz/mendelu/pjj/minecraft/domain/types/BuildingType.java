package cz.mendelu.pjj.minecraft.domain.types;

import java.util.HashMap;
import java.util.Map;

public enum BuildingType {
    DECORATION(0),
    RESIDENTAL_HOUSE(1),
    ANIMAL_ENCLOUSURE(2),
    BRIDGE(3);
    
    private int value;
    private static Map map = new HashMap<>();

    BuildingType(int value){
        this.value =  value;
    }
    static {
        for (BuildingType BuildingType : BuildingType.values()) {
            map.put(BuildingType.value, BuildingType);
        }
    }

    public static BuildingType valueOf(int BuildingType) {
        return (BuildingType) map.get(BuildingType);
    }

    public int getValue() {
        return value;
    }
    
}
