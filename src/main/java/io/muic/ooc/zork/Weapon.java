package io.muic.ooc.zork;

/**
 * Created by Sam on 1/26/17.
 */
public class Weapon extends Item{
  private int damage;

  public Weapon(int numberOfUse, int damage) {
    super(numberOfUse);
    this.damage = damage;
  }

  public int getDamage() {
    return damage;
  }
}
