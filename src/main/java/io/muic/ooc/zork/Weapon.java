package io.muic.ooc.zork;

/**
 * Created by Sam on 1/26/17.
 */
public class Weapon extends Item{
  private int damage;

  public Weapon(String name, int numberOfUse, int damage) {
    super(name, numberOfUse);
    this.damage = damage;
  }

  public int getDamage() {
    return damage;
  }

  public int use(Mortal target) {
    target.setHealth(target.getHealth() - damage);
    setNumberOfUse(getNumberOfUse() - 1);
    return damage;
  }

  @Override
  public String getInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.getInfo().trim());
    stringBuilder.append("[Damage: ")
                .append(damage)
                .append("] \n");

    return stringBuilder.toString();
  }
}
