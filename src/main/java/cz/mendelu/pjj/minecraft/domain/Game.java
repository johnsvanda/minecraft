package cz.mendelu.pjj.minecraft.domain;

import cz.mendelu.pjj.minecraft.domain.types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {


    public static Game instance;

    public List<Player> getPlayers() {
        return players;
    }

    private final List<Player> players = new ArrayList();
    private int currentPlayerIndex = -1;


    /**
     * Init whole Game
     * Just one instance can be created
     */
    Game(Player... players) {

        for (Player player : players) {
            this.players.add(player);
        }
    }

    /**
     * Vytvo?en� nov� hry
     * Um�st� hr�?e do st?edu matice
     * Design pattern Singleton
     *
     * @return Hern� matice
     * @author xsvanda1
     * @version etapa 2
     */
    public static Game createNewGame(Player... players) {
        if (instance == null) {
            instance = new Game(players);
        }
        return instance;
    }


    /**
     * Generate tile with containing 4 cards
     *
     * @return Generate tile
     * @author xsvanda1
     * @version etapa 2
     */
    public static Tile createTileWithCards(CardType cardType) {
        Tile tile = new Tile(new Card[]{});

        for (int i = 0; i < 4; i++) {
            switch (cardType) {

                case WEAPON:
                    tile.cards.add(new Weapon(new Random().nextInt(4,WeaponType.values().length)));
                    break;

                case BUILDING_MONSTER:

                    //random to mix buildings 0 and monsters 1 in the same tile
                    int random = new Random().nextInt(2);
                    if (random == 1)
                        tile.cards.add(new Monster(new Random().nextInt(MonsterType.values().length)));
                    else tile.cards.add(new Building(new Random().nextInt(BuildingType.values().length)));
                    break;
            }
        }
        return tile;
    }


    /**
     * Zavol� hodnocen� a p?i?te body hr�??m
     *
     * @param type, vyhodnot� jak� f�ze hry se moment�ln? vyhodnocuje (3 hodnot�c� f�ze)
     * @author xsvanda1
     * @version etapa 2
     */
    public static Game callEvaluation(EvaluationType type) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }



}




