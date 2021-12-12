package cz.mendelu.pjj.minecraft.greenfoot;

import cz.mendelu.pjj.minecraft.domain.*;
import cz.mendelu.pjj.minecraft.domain.types.BuildingType;
import cz.mendelu.pjj.minecraft.domain.types.CardType;
import cz.mendelu.pjj.minecraft.domain.types.MonsterType;
import cz.mendelu.pjj.minecraft.domain.types.WeaponType;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.Arrays;


public class TileActor extends Actor {

    private Tile tile;
    private MinecraftWorld world;
    private CardType cardType;

    TileActor(MinecraftWorld world, CardType cardType) {
        this.tile = Game.createTileWithCards(cardType);
        this.cardType = cardType;
        this.world = world;
        this.init();
    }

    /**
     *
     * Metoda slouží pro zavolání akcí, které se mají stát při kliku na určitý typ karty
     *
     * @author xsvanda1
     * @version etapa 5
     */
    @Override
    public void act() {
        //Get current player
        PlayerActor currentPlayer = MinecraftWorld.getCurrentPlayer();

        if (currentPlayer.getPlayer().getNumberOfAvailabeActions() > 0 && !this.tile.isEmpty()) {
            //Get clicked card
            Card clickedCard = this.tile.getCards().peek();

            //If card is clicked and is not hidden
            if (Greenfoot.mouseClicked(this) && clickedCard.isHidden() == false) {


                //If clicked card is a MonsterType
                if (Arrays.asList(MonsterType.getValues()).contains(clickedCard.getCardType())) {
                    Monster monster = (Monster) clickedCard;
                    int hearts = currentPlayer.getPlayer().fight(monster);

                    //Monster killed
                    if (hearts >= monster.getHearts()) {
                        this.world.updateNumberOfHearts(hearts);
                        this.world.updateNumberOfPoints();
                        this.world.updateNumberOfXp();
                        this.tile.removeTopCard();
                        this.turnCard();

                    } else {
                        this.world.updateNumberOfHearts(hearts);
                    }

                }

                if (Arrays.asList(BuildingType.getValues()).contains(clickedCard.getCardType())) {
                    Building building = (Building) clickedCard;
                    if (currentPlayer.getPlayer().build(building)) {
                        currentPlayer.getPlayer().decrementNumberofAvailableActions();
                        this.world.inHand.setPlayer(currentPlayer.getPlayer());
                        this.world.updateNumberOfXp();
                        this.tile.removeTopCard();
                        this.turnCard();
                    }

                }

                if (Arrays.asList(WeaponType.getValues()).contains(clickedCard.getCardType())) {
                    Weapon weapon = (Weapon) clickedCard;
                    currentPlayer.getPlayer().addWeapon(weapon);
                    currentPlayer.getPlayer().setInHand(weapon);
                    this.tile.removeTopCard();
                    this.turnCard();
                    this.world.inHand.update();
                    currentPlayer.getPlayer().decrementNumberofAvailableActions();

                }

                this.world.updateNumberOfAvailableActions();
                if (this.tile.isEmpty()) {
                    GreenfootImage image;
                    image = new GreenfootImage(MinecraftWorld.CARD_FOLDER + "no_card" + ".png");
                    image.scale(MinecraftWorld.CARD_WIDTH, MinecraftWorld.CARD_HEIGHT);
                    this.setImage(image);
                }
            }
        }
        ;


    }

    /**
     *
     * Metoda slouží k otočení vrchní karty, pokud ještě existují, nastavuje velikost podle toho jestli je karta Weapon nebo Monster, Building
     *
     * @author xsvanda1
     * @version etapa 5
     */
    public Card turnCard() {
        if (!this.tile.isEmpty()) {
            CardActor cardActor = new CardActor(this.tile.getCards().peek());
            Card card = cardActor.getCard();
            if (card.isHidden()) {
                card.showCard();
                var imageName = MinecraftWorld.CARD_FOLDER + ((this.tile.isEmpty()) ? "no_card.png" : card.getCardType().toString().toLowerCase() + ".png");
                var image = new GreenfootImage(imageName);
                if (this.cardType == CardType.BUILDING_MONSTER)
                    image.scale(MinecraftWorld.CARD_WIDTH, MinecraftWorld.CARD_HEIGHT);
                else image.scale(MinecraftWorld.WEAPON_SIZE, MinecraftWorld.WEAPON_SIZE);
                setImage(image);
            }
            return card;
        }
        return null;
    }

    /**
     *
     * Metoda slouží k inicializaci karet na hracím poli, karty jsou defaultně skryté
     *
     * @author xsvanda1
     * @version etapa 5
     */
    public void init() {
        GreenfootImage image;
        if (this.cardType == CardType.BUILDING_MONSTER) {
            image = new GreenfootImage(MinecraftWorld.CARD_FOLDER + "grass" + ".jpg");
            image.scale(MinecraftWorld.CARD_WIDTH, MinecraftWorld.CARD_HEIGHT);
        } else {
            image = new GreenfootImage(MinecraftWorld.CARD_FOLDER + "weapon" + ".png");
            image.scale(MinecraftWorld.WEAPON_SIZE, MinecraftWorld.WEAPON_SIZE);
        }
        this.setImage(image);

    }
}