package cz.mendelu.pjj.minecraft.domain;


public class Path  {

    Player player;

    public Path() {
        this.player = null;
    }

    public void setPlayer(Player player) {
        //player.setPosition(this);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
