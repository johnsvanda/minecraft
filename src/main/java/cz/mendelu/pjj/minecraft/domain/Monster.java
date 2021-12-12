package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.MonsterType;

public class Monster extends Card {

    public Monster(int monsterTypeValue) {
        initMonster(MonsterType.valueOf(monsterTypeValue));
    }

    private int hearts;
    private int xp;

    public int getXp() {
        return xp;
    }

    public boolean isAddAction() {
        return addAction;
    }

    public boolean isAddPoints() {
        return addPoints;
    }

    private boolean addAction;
    private boolean addPoints;


    public Monster(MonsterType MonsterType) {
        initMonster(MonsterType);
    }

    private void initMonster(MonsterType monsterType) {
        switch (monsterType) {
            case ZOMBIE:
                this.hearts = 2;
                this.xp = 3;
                this.addAction = true;
                this.addPoints = false;
                super.setCardType(MonsterType.ZOMBIE);
                break;
            case SKELETON:
                this.hearts = 3;
                this.xp = 4;
                this.addAction = true;
                this.addPoints = false;
                super.setCardType(MonsterType.SKELETON);
                break;

            case CREEPER:
                this.hearts = 4;
                this.xp = 5;
                this.addAction = true;
                this.addPoints = false;
                super.setCardType(MonsterType.CREEPER);
                break;

            case WITCH:
                this.hearts = 5;
                this.xp = 5;
                this.addAction = false;
                this.addPoints = true;
                super.setCardType(MonsterType.WITCH);
                break;
        }
    }

    public int getHearts() {
        return hearts;
    }

}
