package io.muic.ooc.zork;

/**
 * Created by Sam on 1/26/17.
 */
public class Potion extends Item {
  private int heal;

  public Potion(String name, int numberOfUse, int heal) {
    super(name, numberOfUse);
    this.heal = heal;
  }

  public int getHeal() {
    return heal;
  }

  public int use() {
    setNumberOfUse(getNumberOfUse() - 1);
    return heal;
  }
}
