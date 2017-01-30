package io.muic.ooc.zork;


public class Monster extends Mortal{

  private static final int EXP_RATE = 50;


  public Monster(String name, int maxHealth, int armor, int damage, int level) {
    super(name, maxHealth, armor, damage, level);
  }

  public int dropLoop() {
    return this.getLevel() * EXP_RATE;
  }

  public void attack(Mortal target) {
    target.takeDamage(this.getDamage());
  }

}
