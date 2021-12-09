package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.*;

import java.util.Random;

public class GameBoard {


    public static GameBoard instance;
    private static Object[][] grid;
    private Player[] players;
    private BlockCube cube;

    /**
     * Init whole Game
     * Just one instance can be created
     */
    GameBoard() {
        this.grid = initGrid();
        this.cube = BlockCube.initBlockCube();
        this.players = initPlayers();
    }

    /**
     * Vytvo?ení nové hry
     * Umístí hrá?e do st?edu matice
     * Design pattern Singleton
     *
     * @return Herní matice
     * @author xsvanda1
     * @version etapa 2
     */
    public static GameBoard createNewGame() {
        if (instance == null) {
            instance = new GameBoard();
        }
        return instance;
    }

    /**
     * Zavolá hodnocení a p?i?te body hrá??m
     *
     * @param type, vyhodnotí jaká fáze hry se momentáln? vyhodnocuje (3 hodnotící fáze)
     * @author xsvanda1
     * @version etapa 2
     */
    public static GameBoard callEvaluation(EvaluationType type) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Získá pole a tím i jeho obsah (karty)
     *
     * @param x, ?íslice v rozsahu 0-11
     * @param y, 0-11
     * @return Existující polí?ko
     * @throws IndexOutOfBoundsException
     * fBoundsException je dotazováno mimo rozsah
     * @author xsvanda1
     * @version etapa 2
     */
    public static Object getTile(int x, int y) {
        return grid[x][y];
    }

    /**
     * Fill the board with predefined card set
     * 64 cards = 32 buildings and 32 monsters (16 tiles) - in the middle
     * 16 cards = weapons - around (border)
     * 21 cards = paths = players can step on it
     *
     * @author xsvanda1
     * @version etapa 2
     */
    private Object[][] initGrid() {
        grid = new Object[11][11];

        //Fill grid with weapons
        Tile tile = this.createTileWithCards(CardType.WEAPON);
        int add;
        int stop;
        for (int i = 0; i <= 10; i += 2) {
            if (i == 0 || i == 10) {
                add = 2;
                stop = 8;
            }
            else {
                add = 2;
                stop = 10;
            }
            for (int j = add; j <= stop; j += add) {
                if(add == 2 && stop == 10) add = 8;
                grid[i][j] = tile;
            }
        }

        //Fill grid with buildings and monsters
        tile = this.createTileWithCards(CardType.BUILDING_MONSTER);
        for (int i = 2; i <= 8; i += 2) {
            for (int j = 2; j <= 8; j += 2) {
                grid[i][j] = tile;
            }
        }

        //Fill grid with paths
        Path path = new Path();
        for (int i = 1; i <= 9; i += 2) {
            if (i == 1 || i == 9) add = 3;
            else add = 1;

            for (int j = add; j <= 7; j += 2) {
                grid[i][j] = path;
                //System.out.println("[" + i + "]" + "[" + j + "]");
            }
        }


        return grid;
    }

    /**
     * Generate tile with containing 4 cards
     *
     * @return Generate tile
     * @author xsvanda1
     * @version etapa 2
     */
    private Tile createTileWithCards(CardType cardType) {
        Card randomCard = null;
        switch (cardType) {

            case WEAPON:
                randomCard = new Weapon(new Random().nextInt(WeaponType.values().length));
                break;

            case BUILDING_MONSTER:

                //random to mix buildings 0 and monsters 1 in the same tile
                int random = new Random().nextInt(2);
                if (random == 1)
                    randomCard = new Monster(new Random().nextInt(MonsterType.values().length));
                else randomCard = new Building(new Random().nextInt(BuildingType.values().length));
                break;
        }

        return new Tile(returnFourCards(randomCard));
    }

    private Card[] returnFourCards(Card card) {
        return new Card[]{card, card, card, card};
    }

    private Player[] initPlayers() {

        // Game is for 2-4 players
        Player[] players = new Player[4];


        // Get starting field
        Path path = (Path) getTile(5,5);

        // Create players
        for (int i = 0; i < players.length; i++) {
            Player player = new Player(PlayerType.RED);
            path.setPlayer(player);
        }
        return players;
    }

    public static void main(String[] args) {
        GameBoard game = createNewGame();


    }

}




