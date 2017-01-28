package io.muic.ooc.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Player extends Mortal{
  private int exp;
  private Backpack backpack = new Backpack();


  public Player(String name, int maxHealth, int armor, int damage) {
    super(name, maxHealth, armor, damage);
    this.exp = 0;
  }

  public int getExp() {
    return this.exp;
  }

  public void addExp(int exp) {
    int totalExp = this.getExp() + exp;
    int maxExp = getLevel() * 100;
    this.exp = totalExp;

    if (totalExp > maxExp) {
      this.exp = totalExp - maxExp;
      levelUp();
    }
  }

  public void levelUp() {
    setHealth(getHealth() + 5);
    setArmor(getArmor() + 2);
    setDamage(getDamage() + 3);

    setLevel(getLevel() + 1);
  }

  @Override
  public String getInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    String info = super.getInfo();

    stringBuilder.append(info);
    stringBuilder.append("[exp: ")
            .append(this.exp)
            .append("/")
            .append(getLevel())
            .append("] \n");
    stringBuilder.append("[Backpack: ")
            .append(backpack.getItemsList())
            .append("] \n");

    return stringBuilder.toString();
  }

  public Backpack getBackpack() {
    return backpack;
  }

  public final class Backpack {
    HashMap<String, Item> items = new HashMap<>();
    public final static int MAX_ITEMS = 3;

    public boolean addItem(Item item) {
      if (items.size() < MAX_ITEMS) {
        items.put(item.getName(), item);
        return true;
      }
      return false;
    }

    public boolean removeItem(String itemName) {
      if (items.containsKey(itemName)) {
        items.remove(itemName);
        return true;
      }
      return false;
    }

    public boolean useItem(String itemName) {
      if (items.containsKey(itemName)) {
        Item item = items.get(itemName);

        // TODO: Using item, reduce #use, only allow potions

        return true;
      }
      return false;
    }

    public String getItemsList() {
      return items.keySet().toString();
    }
  }

}
