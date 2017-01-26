package io.muic.ooc.zork;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class Monster extends Mortal{
  private int level;

  public Monster(int maxHealth, int armor, int damage, int level) {
    super(maxHealth, armor, damage);
    this.level = level;
  }

  public int getLevel() {
    return level;
  }
}
