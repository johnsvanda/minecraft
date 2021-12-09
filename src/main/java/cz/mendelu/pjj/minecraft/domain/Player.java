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
     * Vrátí akce, které m??e hrá? v daný moment provést
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public Action[] getAvailableActions() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Vrátí karty, které se nachází v okolí hrá?e
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
     * Hrá? si vezme 2 bloky z velké kostky a p?idá je do svého inventá?e
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public void takeTwoBlocks() {
        BlockCube cube = BlockCube.initBlockCube();
        this.blocks.addAll(cube.removeTwoBlocks());
    }

    /**
     * Zaúto?í na p?í?eru
     *
     * @param target p?í?era na kterou se úto?í*
     * @return Loot vrátí zku?enosti nebo body do hodnocení
     * @throws CantFightException nesmíme úto?it na p?í?ery co mají více srdí?ek
     * @author xsvanda1
     * @version etapa 2
     */
    public Loot fight(Monster target) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Get a sum of players hearts (attack), usually used when fighting a monster
     *
     * @return Hearts vrátí po?et srdcí
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