package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.CardType;
import cz.mendelu.pjj.minecraft.domain.types.MonsterType;

public class Monster extends Card {
    public Monster(int monsterTypeValue) {
        super(CardType.MONSTER);
        MonsterType monsterType = MonsterType.valueOf(monsterTypeValue);
        initMonster(monsterType);
    }
    int hearts;
    int xp;
    boolean addCards;
    boolean addPoints;



    public Monster(MonsterType MonsterType) {
        super(CardType.MONSTER);
        initMonster(MonsterType);
    }

    private void initMonster(MonsterType monsterType) {
        switch (monsterType) {
            case ZOMBIE:
                this.hearts = 2;
                this.xp = 3;
                this.addCards = true;
                this.addPoints = false;

                break;
            case SKELETON:
                this.hearts = 3;
                this.xp = 4;
                this.addCards = true;
                this.addPoints = false;
                break;

            case CREEPER:
                this.hearts = 4;
                this.xp = 5;
                this.addCards = true;
                this.addPoints = false;
                break;

            case WITCH:
                this.hearts = 5;
                this.xp = 5;
                this.addCards = false;
                this.addPoints = true;
                break;
        }
    }

    public int getHearts() {
        return hearts;
    }

    public int getXp() {
        return xp;
    }

    public boolean isAddCards() {
        return addCards;
    }

    public boolean isAddPoints() {
        return addPoints;
    }
}
