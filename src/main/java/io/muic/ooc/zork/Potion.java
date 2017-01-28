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

  public int use(Mortal target) {
    target.setHealth(target.getHealth() + heal);
    setNumberOfUse(getNumberOfUse() - 1);
    return heal;
  }

  @Override
  public String getInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.getInfo().trim());
    stringBuilder.append("[Heal: ")
            .append(heal)
            .append("] \n");

    return stringBuilder.toString();
  }
}
