package cz.mendelu.pjj.minecraft.greenfoot;


import cz.mendelu.pjj.minecraft.domain.Card;
import cz.mendelu.pjj.minecraft.domain.Player;
import greenfoot.World;

import java.util.LinkedList;
import java.util.List;

public class InHand {
    private final World world;
    private final List<CardActor> cardActors = new LinkedList<>();

    private Player player;

    public InHand(World world) {
        this.world = world;
    }

    public void setPlayer(Player player) {
        this.player = player;
        update();
    }

    /**
     * Metoda slouží k zobrazení aktuálního stavu hráčovy "ruky"
     *
     * @author xsvanda1
     * @version etapa 5
     */
    public void update() {
        for (CardActor aca : cardActors) {
            world.removeObject(aca);
        }
        cardActors.clear();

        List inHand = this.player.inHand();
        for (int i = 0, inHandSize = inHand.size(); i < inHandSize; i++) {
            var ac = (Card) inHand.get(i);
            var aca = new CardActor(ac);
            world.addObject(aca, MinecraftWorld.CARD_WIDTH/100 * i, MinecraftWorld.CARD_HEIGHT * 3 );
            cardActors.add(aca);
        }
    }
}
