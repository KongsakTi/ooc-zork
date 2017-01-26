package io.muic.ooc.zork;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class Monster extends Mortal{
  private int level;

  public Monster(String name, int maxHealth, int armor, int damage, int level) {
    super(name, maxHealth, armor, damage);
    this.level = level;
  }

  public int getLevel() {
    return level;
  }
}
