package cz.mendelu.pjj.minecraft.domain;

public class Player {

    Weapon[] weapons;
    int hearts;
    Color color;



    Player(Color color) {
        this.weapons = new Weapon[]{new Weapon(WeaponType.WOODEN_SWORD), new Weapon(WeaponType.STONE_SWORD), new Weapon(WeaponType.POTATOE), new Weapon(WeaponType.POTATOE), new Weapon(WeaponType.POTATOE)};
        this.hearts = 0;
        this.color = color;
    }

    /**
     * Vrátí akce, které může hráč v daný moment provést
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public Action[] getAvailableActions(){
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Proveď akci
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public void makeAction(Card targetCard){
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Hráč si vezme 2 bloky z velké kostky a přidá je do svého inventáře
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public void takeTwoBlocks(){
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Zaútočí na příšeru
     * @param target příšera na kterou se útočí*
     * @throws CantFightException nesmíme útočit na příšery co mají více srdíček
     * @return Loot vrátí zkušenosti nebo body do hodnocení
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public Loot fight(Monster target){
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Get a sum of players hearts (attack), usually used when fighting a monster
     * @return Hearts vrátí počet srdcí
     *
     * @author xsvanda1
     * @version etapa 3
     */
    public int getHearts() {
        return this.hearts;
    }


}