package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.PlayerType;
import cz.mendelu.pjj.minecraft.domain.types.WeaponType;

import java.util.ArrayList;
import java.util.Objects;

public class Player {

    Path position;
    Weapon[] weapons;
    int hearts;
    PlayerType playerType;
    int xp;
    final GamePlan gamePlan;
    int points;
    ArrayList<Block> blocks;
    ArrayList<Action> actions;

    public Path getPosition() {
        return position;
    }

    public void setPosition(Path position) {
        this.position = position;
    }

    Player(PlayerType playerType) {
        this.position = null;
        this.weapons = this.initWeapons();
        this.hearts = 0;
        this.playerType = playerType;
        this.xp = 0;
        this.gamePlan = new GamePlan();
        this.points = 0;
        this.blocks = new ArrayList();
    }

    public PlayerType getColor() {
        return playerType;
    }

    private Weapon[] initWeapons() {
        return new Weapon[]{new Weapon(WeaponType.WOODEN_SWORD), new Weapon(WeaponType.STONE_SWORD), new Weapon(WeaponType.POTATOE), new Weapon(WeaponType.POTATOE), new Weapon(WeaponType.POTATOE)};
    }

    /**
     * Vr�t� akce, kter� m??e hr�? v dan� moment prov�st
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public Action[] getAvailableActions() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Vr�t� karty, kter� se nach�z� v okol� hr�?e
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public Action[] getNeighbourCards() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Prove? akci
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public void makeAction(Card targetCard) {
        throw new UnsupportedOperationException("Not implemented yet.");

    }

    /**
     * Hr�? si vezme 2 bloky z velk� kostky a p?id� je do sv�ho invent�?e
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public void takeTwoBlocks() {
        BlockCube cube = BlockCube.initBlockCube();
        this.blocks.addAll(cube.removeTwoBlocks());
    }

    /**
     * Za�to?� na p?�?eru
     *
     * @param target p?�?era na kterou se �to?�*
     * @return Loot vr�t� zku?enosti nebo body do hodnocen�
     * @throws CantFightException nesm�me �to?it na p?�?ery co maj� v�ce srd�?ek
     * @author xsvanda1
     * @version etapa 2
     */
    public Loot fight(Monster target) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Get a sum of players hearts (attack), usually used when fighting a monster
     *
     * @return Hearts vr�t� po?et srdc�
     * @author xsvanda1
     * @version etapa 3
     */
    public int getHearts() {
        return this.hearts;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player b = (Player) obj;
            return (this.playerType == b.playerType);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getColor());
    }

    @Override
    public String toString() {
        return "Player " + this.getColor();
    }

}