package cz.mendelu.pjj.minecraft.greenfoot;

import cz.mendelu.pjj.minecraft.domain.Action;
import cz.mendelu.pjj.minecraft.domain.BlockCube;
import cz.mendelu.pjj.minecraft.domain.Game;
import cz.mendelu.pjj.minecraft.domain.Player;
import cz.mendelu.pjj.minecraft.domain.types.BlockType;
import cz.mendelu.pjj.minecraft.domain.types.CardType;
import cz.mendelu.pjj.minecraft.domain.types.PlayerType;
import greenfoot.World;

import java.util.ArrayList;
import java.util.List;

public class MinecraftWorld extends World {

    private static final int SCALE = 2;

    public static final int CARD_WIDTH = 250 / SCALE;
    public static final int CARD_HEIGHT = 250 / SCALE;
    public static final String CARD_FOLDER = "images/";
    public static final int CARD_SPACE = CARD_WIDTH / 10;
    public static final int WEAPON_SIZE = 70;
    private static final int WORLD_WIDTH = CARD_WIDTH * 10;
    private static final int WORLD_HEIGHT = CARD_HEIGHT * 4;


    public static PlayerActor getCurrentPlayer() {
        return currentPlayer;
    }

    private static PlayerActor currentPlayer;
    private List<PlayerActor> playerActors;
    private PlayerActor playerActor;
    private TileActor tileActor;
    private WeaponActor weaponActor;
    private PathActor pathActor;
    private LabelActor labelActor;
    public LabelActor heartsLabel;
    public LabelActor pointsLabel;
    public LabelActor xpLabel;
    public LabelActor availableActionsLabel;
    public LabelActor numberOfBlocksInCubeLabel;
    public InHand inHand;
    public static BlockCube blockCube;

    // Create new players
    private Game game = Game.createNewGame(new Player(PlayerType.RED), new Player(PlayerType.BLUE), new Player(PlayerType.YELLOW), new Player(PlayerType.GREEN));

    /**
     *
     *
     * Vytvoření hry
     * Umístí hráče do středu matice, nastaví countery, vygeneruje náhodné hrací pole
     *
     * @author xsvanda1
     * @version etapa 4
     */
    public MinecraftWorld() {
        super(11, 15, 90, true);
        this.initWorld();
        this.playerActors = new ArrayList<>();
        this.inHand = new InHand(this);
        this.pathActor = new PathActor(this);
        blockCube = BlockCube.initBlockCube();

        //Set players to middle
        for (Player player : this.game.getPlayers()) {
            this.playerActor = new PlayerActor(player);
            this.addObject(playerActor, 5, 5);
            this.playerActors.add(playerActor);
        }
        currentPlayer = this.playerActors.get(this.playerActors.size() - 1);
        currentPlayer.select();

        //Set current players cards in his hand
        this.inHand.setPlayer(currentPlayer.getPlayer());
        this.initLabels();


        for (Action action : this.currentPlayer.getPlayer().getAvailableActions()
        ) {
            this.labelActor = new LabelActor(this ,action.getName(), () -> {
                PlayerActor currentPlayer = getCurrentPlayer();
                action.makeAction(game, currentPlayer.getPlayer());
                this.inHand.setPlayer(currentPlayer.getPlayer());
                this.updateNumberOfAvailableActions();
                this.updatenumberOfBlocksInCubeLabel();
                return null;
            });
            this.addObject(labelActor, 3, 12 + this.currentPlayer.getPlayer().getAvailableActions().indexOf(action));

        }


    }

    /**
     *
     * Metoda, která přepne aktivního hráče na dalšího v pořadí
     *
     * @author xsvanda1
     * @version etapa 4
     */
    public void nextPlayer() {
        int indexOfCurrentActor = this.playerActors.indexOf(currentPlayer);
        int indexOfNextActor;
        if (indexOfCurrentActor == 0) {
            indexOfNextActor = this.playerActors.size() - 1;
        } else {
            indexOfNextActor = indexOfCurrentActor - 1;
        }

        //Round start
        currentPlayer = this.playerActors.get(indexOfNextActor);
        currentPlayer.select();
        currentPlayer.getPlayer().setNumberOfAvailabeActions(2);
        this.updateNumberOfAvailableActions();
        this.inHand.setPlayer(currentPlayer.getPlayer());
    }

    /**
     *
     * Update counteru pro počet možných akcí během jednoho kola
     *
     * @author xsvanda1
     * @version etapa 4
     */
    public void updateNumberOfAvailableActions() {
        removeObject(this.availableActionsLabel);
        this.availableActionsLabel = new LabelActor("Available actions: " + currentPlayer.getPlayer().getNumberOfAvailabeActions());
        this.addObject(this.availableActionsLabel, 1, 11);

        //Call next round
        if(currentPlayer.getPlayer().getNumberOfAvailabeActions() == 0){
            currentPlayer.setImage();
            this.nextPlayer();
        }
    }

    public void updateNumberOfHearts(int hearts) {
        removeObject(this.heartsLabel);
        this.heartsLabel = new LabelActor("Hearts: " + hearts);
        this.addObject(this.heartsLabel, 1, 12);
    }

    public void updateNumberOfXp() {
        removeObject(this.xpLabel);
        this.xpLabel = new LabelActor("Xp: " + this.currentPlayer.getPlayer().getXp());
        this.addObject(this.xpLabel, 1, 13);
    }

    public void updateNumberOfPoints() {
        removeObject(this.pointsLabel);
        this.pointsLabel = new LabelActor("Points: " + this.currentPlayer.getPlayer().getPoints());
        this.addObject(this.pointsLabel, 1, 14);
    }

    public void updatenumberOfBlocksInCubeLabel() {
        removeObject(this.numberOfBlocksInCubeLabel);
        this.numberOfBlocksInCubeLabel = new LabelActor("Number of blocks in cube: " + blockCube.numberOfBlocks());
        this.addObject(this.numberOfBlocksInCubeLabel, 4, 13);
    }



    private void initLabels() {
        this.updateNumberOfHearts(0);
        this.updateNumberOfAvailableActions();
        this.updateNumberOfXp();
        this.updateNumberOfPoints();
        this.updatenumberOfBlocksInCubeLabel();
    }


    /**
     * Fill the board with predefined card set
     * 64 cards = 32 buildings and 32 monsters (16 tiles) - in the middle
     * 16 cards = weapons - around (border)
     * 21 cards = paths = players can step on it
     *
     * Metoda nastavuje komplexní grid, kde se má co na hracím poli vyskytovat a nastavuje na jednotlivé pole randomizované karty
     * @author xsvanda1
     * @version etapa 5
     */
    private void initWorld() {

        //Fill grid with paths
        int add;
        int stop;
        for (int y = 1; y <= 9; y += 2) {
            if (y == 1 || y == 9) {
                add = 3;
                stop = 7;
            } else {
                stop = 9;
                add = 1;
            }
            for (int x = add; x <= stop; x += 2) {
                this.pathActor = new PathActor(this);
                this.addObject(pathActor, x, y);
            }
        }


        //Fill grid with weapons
        for (int y = 0; y <= 10; y += 2) {
            if (y == 0 || y == 10) {
                add = 2;
                stop = 8;
            } else {
                add = 0;
                stop = 10;
            }
            for (int x = add; x <= stop; x += add) {
                if (add == 0 && stop == 10 || add == 10 && stop == 10) add = 10;
                this.tileActor = new TileActor(this, CardType.WEAPON);
                this.addObject(this.tileActor, x, y);
            }
        }

        //Fill grid with buildings and monsters
        for (int y = 2; y <= 8; y += 2) {
            for (int x = 2; x <= 8; x += 2) {
                this.tileActor = new TileActor(this, CardType.BUILDING_MONSTER);
                this.addObject(tileActor, x, y);
            }
        }
    }
}

