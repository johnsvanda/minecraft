package cz.mendelu.pjj.minecraft.domain;

public class Monster extends Card {

    int hearts;

    Monster(int hearts){
        this.hearts = hearts;
    }

    public int getHearts() {
        return hearts;
    }
}
