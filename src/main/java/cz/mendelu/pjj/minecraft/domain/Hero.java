package cz.mendelu.pjj.minecraft.domain;

public class Hero {


    private int power;
    private int health;
    private Weapon weapon;


    public Hero(int power, int health) {
        this.power = power;
        this.health = health;
        this.weapon = null;
    }

    public void attack(Hero targetHero) {
        if (targetHero.getPower() > this.getPower()) {
            this.setHealth(this.getHealth() - targetHero.getPower());
        }
        else if (targetHero.getPower() < this.getPower()) {
            targetHero.setHealth(targetHero.getHealth() - this.getPower());
        }

    }

    public int getPower() {
        int weaponPower = (this.weapon != null) ? this.weapon.getPower() : 0;
        return power + weaponPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public static void main(String[] args) {
        Hero h1 = new Hero(5, 100);
        Hero h2 = new Hero(10, 100);
        Weapon sword = new Weapon(WeaponType.WOODEN_SWORD);

        h2.setWeapon(sword);
        h2.attack(h1);

        System.out.println(h1.getHealth());
    }
}
