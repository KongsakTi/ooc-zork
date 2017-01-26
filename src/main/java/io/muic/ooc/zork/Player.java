package io.muic.ooc.zork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class Player extends Mortal{
  private int level;
  private int exp;
  private List<Item> items = new ArrayList<>();
  private final static int MAX_ITEMS = 3;

  public Player(String name, int maxHealth, int armor, int damage) {
    super(name, maxHealth, armor, damage);
    this.exp = 0;
    this.level = 1;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getExp() {
    return this.exp;
  }

  public void addExp(int exp) {
    int totalExp = this.getExp() + exp;
    this.exp = totalExp;

    if (totalExp > level * 100) {
      this.exp = totalExp - (level * 100);
      levelUp();
    }
  }

  public boolean addItem(Item item) {
    if (items.size() < MAX_ITEMS) {
      items.add(item);
      return true;
    } else {
      return false;
    }
  }

  public void levelUp() {
    setHealth(getHealth() + 5);
    setArmor(getArmor() + 2);
    setDamange(getDamange() + 3);

    setLevel(getLevel() + 1);
  }

}
