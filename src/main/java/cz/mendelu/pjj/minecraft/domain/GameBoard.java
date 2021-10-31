package cz.mendelu.pjj.minecraft.domain;

public class GameBoard {


    public static GameBoard instance;
    private Card[][] grid;
    private Player[] players;

    /**
     * Just one instance can be created
     */
    GameBoard() {
        this.grid = new Card[11][11];
        fillGridWithCards(this.grid);

    }

    /**
     * Vytvoření nové hry
     * Umístí hráče do středu matice
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
     * Zavolá hodnocení a přičte body hráčům
     *
     * @param type, vyhodnotí jaká fáze hry se momentálně vyhodnocuje (3 hodnotící fáze)
     * @author xsvanda1
     * @version etapa 2
     */
    public static GameBoard callEvaluation(EvaluationType type) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Získá pole a tím i jeho obsah (karty)
     *
     * @param x, číslice v rozsahu 0-11
     * @param y, 0-11
     * @return Existující políčko
     * @throws IndexOutOfBoundsException je dotazováno mimo rozsah
     * @author xsvanda1
     * @version etapa 2
     */
    public static Tile getTile(int x, int y) {
        throw new UnsupportedOperationException("Not implemented yet.");
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
    private void fillGridWithCards(Card[][] grid) {


        //Fill grid with buildings and monsters
        for (int i = 2; i <= 8; i += 2) {
            for (int j = 2; j <= 8; j += 2) {
                if (i == 4 || i == 6) grid[i][j] = new Monster(10);
                else grid[i][j] = new Building();

            }
        }

        //Fill grid with weapons
        int add;
        for (int i = 0; i <= 10; i += 2) {
            if (i == 0 || i == 10) add = 2;
            else add = 10;

            for (int j = 0; j <= 10; j += add) {
                grid[i][j] = new Weapon(WeaponType.WOODEN_SWORD);
            }
        }

        //Fill grid with paths
        int begin;
        for (int i = 1; i <= 9; i += 2) {
            if (i == 1 || i == 9) begin  =  3;
            else begin = 1;

            for (int j = begin; j <= 10; j += 2) {
                grid[i][j] = new Path();
            }
        }
    }

    /**
     * Generate tile with containing 4 cards
     *
     * @return Generate tile
     * @author xsvanda1
     * @version etapa 2
     */
    private Tile generateTile() {
        Tile tile = new Tile();
        return tile;
    }

    public static void main(String[] args) {
        GameBoard game = GameBoard.createNewGame();
    }

}




