package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.PlayerType;
import cz.mendelu.pjj.minecraft.domain.types.WeaponType;

import java.util.*;

public class Player {

    Path position;
    ArrayList<Weapon> weapons;
    int hearts;
    PlayerType playerType;
    int xp;
    final GamePlan gamePlan;
    int points;
    ArrayList<Action> availableActions = new ArrayList<>();
    private int numberOfAvailabeActions;
    private List inHand = new ArrayList();

    public void setXp(int xp) {
        this.xp += xp;
    }
    public void setPoints(int points) {
        this.points += points;
    }


    public List getInHand() {
        return inHand;
    }

    public void setInHand(Card... inHand) {
        this.inHand.addAll(Arrays.asList(inHand));
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public PlayerType getPlayerType() {
        return playerType;
    }


    public int getNumberOfAvailabeActions() {
        return numberOfAvailabeActions;
    }

    public int getXp() {
        return xp;
    }

    public int getPoints() {
        return points;
    }

    public void setNumberOfAvailabeActions(int numberOfAvailabeActions) {
        this.numberOfAvailabeActions += numberOfAvailabeActions;
    }



    public Player(PlayerType playerType) {
        this.weapons = new ArrayList<>(Arrays.asList(new Weapon(WeaponType.WOODEN_SWORD), new Weapon(WeaponType.STONE_SWORD), new Weapon(WeaponType.POTATOE), new Weapon(WeaponType.POTATOE), new Weapon(WeaponType.POTATOE)));
        this.hearts = 0;
        this.playerType = playerType;
        this.xp = 0;
        this.gamePlan = new GamePlan();
        this.points = 0;
        this.availableActions.addAll(List.of(new Action[]{new TakeTwoBlocks()}));
        this.inHand.addAll(this.weapons);
        this.numberOfAvailabeActions = 0;
    }

    public void decrementNumberofAvailableActions() {
        this.numberOfAvailabeActions--;
    }

    public List inHand() {
        return inHand;
    }

    public PlayerType getColor() {
        return playerType;
    }


    public boolean build(Building buildingToBuild) {
        Block[] recipe = buildingToBuild.getBlocks();
        boolean eligibleForBuild = this.inHand.containsAll(List.of(recipe));

        System.out.println(eligibleForBuild);


        if(eligibleForBuild) {
            this.inHand.removeAll(List.of(recipe));
            this.setXp(buildingToBuild.getXp());
        };

        return eligibleForBuild;
    }
    /**
     * Vr�t� akce, kter� m??e hr�? v dan� moment prov�st
     *
     * @return
     * @author xsvanda1
     * @version etapa 2
     */
    public ArrayList<Action> getAvailableActions() {
        //TODO definovat podm�nky kdy m??e a kdy nem??e vykon�vat kter� akce
        return this.availableActions;
    }



    /**
     * Hr�? si vezme 2 bloky z velk� kostky a p?id� je do sv�ho invent�?e
     *
     * @author xsvanda1
     * @version etapa 2
     */
    public void takeTwoBlocks() {
        BlockCube cube = BlockCube.initBlockCube();
        this.inHand.addAll(cube.removeTwoBlocks());
    }

    /**
     * Za�to?� na p?�?eru
     *
     * @param target p?�?era na kterou se �to?�*
     * @return Player's hearts (damage) in the fight
     * @throws CantFightException nesm�me �to?it na p?�?ery co maj� v�ce srd�?ek
     * @author xsvanda1
     * @version etapa 2
     */
    public int fight(Monster target) {
        int playerHearts = this.getHearts();
        int monsterHearts = target.getHearts();

        // Case kill monster
        if (playerHearts >= monsterHearts) {
            this.setXp(target.getXp());
            if (target.isAddAction()) {
                this.setNumberOfAvailabeActions(1);
                System.out.println("Add actions");
                //TODO remove top card

            }
            if (target.isAddPoints()) {
                this.setPoints(2);
            }

        } else {
            // Case didn't kill monster
            // Just loose one action
            System.out.println("Player can't fight");
        }
        this.decrementNumberofAvailableActions();
        return playerHearts;
    }

    /**
     * Get a sum of players hearts (attack), usually used when fighting a monster
     *
     * @return Hearts vr�t� po?et srdc�
     * @author xsvanda1
     * @version etapa 3
     */
    public int getHearts() {

        int sumHearts = 0;
        Collections.shuffle(this.weapons);
        for (int i = 0; i < 3; i++) {
            sumHearts += this.weapons.get(i).getHearts();
        }

        return sumHearts;
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
        return "" + this.getColor();
    }

}