package io.muic.ooc.zork;

/**
 * Created by Sam on 1/26/17.
 */
public class Potion extends Item {
  private int heal;

  public Potion(int numberOfUse, int heal) {
    super(numberOfUse);
    this.heal = heal;
  }

  public int getHeal() {
    return heal;
  }
}
