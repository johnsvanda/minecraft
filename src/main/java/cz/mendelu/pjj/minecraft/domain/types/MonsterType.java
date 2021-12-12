package cz.mendelu.pjj.minecraft.domain.types;

import java.util.HashMap;
import java.util.Map;

public enum MonsterType {
    ZOMBIE(0),
    SKELETON(1),
    CREEPER(2),
    WITCH(3);

    private int value;
    private static Map map = new HashMap<>();

    MonsterType(int value) {
        this.value = value;
    }

    static {
        for (MonsterType MonsterType : MonsterType.values()) {
            map.put(MonsterType.value, MonsterType);
        }
    }

    public static MonsterType valueOf(int MonsterType) {
        return (MonsterType) map.get(MonsterType);
    }

    public int getValue() {
        return value;
    }

    public static MonsterType[] getValues() {
        return MonsterType.values();
    }

    public static boolean isMonster(MonsterType cardType){
        boolean result = false;
        for(MonsterType monsterType: MonsterType.values()){
            if(monsterType == cardType) result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        for(MonsterType MonsterType: MonsterType.values()){
            System.out.println(MonsterType.getValue());
        }
    }
}

