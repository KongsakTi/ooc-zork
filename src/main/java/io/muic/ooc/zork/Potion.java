package io.muic.ooc.zork;

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
