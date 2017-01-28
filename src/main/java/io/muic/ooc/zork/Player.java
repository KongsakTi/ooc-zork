package io.muic.ooc.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Player extends Mortal{
  private int exp;
  private int maxExp;
  private Backpack backpack = new Backpack();


  public Player(String name, int maxHealth, int armor, int damage) {
    super(name, maxHealth, armor, damage);
    this.exp = 0;
    maxExp = 10;
  }

  public int getExp() {
    return this.exp;
  }

  public void addExp(int exp) {
    this.exp += exp;

    while (this.exp > maxExp) {
      this.exp -= maxExp;
      levelUp();
    }
  }

  public void levelUp() {
    setHealth(getHealth() + 5);
    setArmor(getArmor() + 2);
    setDamage(getDamage() + 3);
    setLevel(getLevel() + 1);

    maxExp = getLevel() * 15;
  }

  @Override
  public String getInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    String info = super.getInfo();

    stringBuilder.append(info);
    stringBuilder.append("[exp: ")
            .append(exp)
            .append("/")
            .append(maxExp)
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

    private int useItem(String itemName, String type, Mortal target) {
      if (items.containsKey(itemName)) {
        // TODO: Using item, reduce #use, only allow potions

        Item item = items.get(itemName);
        if (item instanceof Potion && type.equals("Potion")) {
          return ((Potion) item).use(target);
        } else if (item instanceof Weapon && type.equals("Weapon")) {
          return ((Weapon) item).use(target);
        }
      }
      return -1;
    }

    public int usePotion(String potionName, Mortal target) {
      return useItem(potionName, "Potion", target);
    }

    public int useWeapon(String weaponName, Mortal target) {
      return useItem(weaponName, "Weapon", target);
    }

    public String getItemsList() {
      StringBuilder stringBuilder = new StringBuilder();

      for (Item item: items.values()) {
        stringBuilder.append(item.getInfo());
        // For beautiful UI
        stringBuilder.append("          ");
      }
      return stringBuilder.toString().trim();
    }
  }

}
