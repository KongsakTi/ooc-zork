package io.muic.ooc.zork;

import java.util.HashMap;


public class Player extends Mortal{
  private int exp;
  private int maxExp;
  private Backpack backpack;


  public Player(String name, int maxHealth, int armor, int damage) {
    super(name, maxHealth, armor, damage);
    this.exp = 0;
    maxExp = 15;
    backpack = new Backpack();
  }

  public int getExp() {
    return this.exp;
  }

  public void addExp(int exp) {
    this.exp += exp;

    while (this.exp >= maxExp) {
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

  public boolean xiaolinPunch(Mortal target) {
    target.takeDamage(this.getDamage());
    return true;
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

    private boolean useItem(String itemName, String type, Mortal target) {
      if (items.containsKey(itemName)) {
        Item item = items.get(itemName);
        boolean used = false;

        if (item instanceof Potion && type.equals("Potion")) {
          used =  ((Potion) item).use(target);
        } else if (item instanceof Weapon && type.equals("Weapon")) {
          used =  ((Weapon) item).use(target);
        }

        if (item.isUseUpped()) {
          removeItem(itemName);
        }

        return used;
      }
      return false;
    }

    public boolean usePotion(String potionName, Mortal target) {
      return useItem(potionName, "Potion", target);
    }

    public boolean useWeapon(String weaponName, Mortal target) {
      if (weaponName.equals("fist")) {
        return xiaolinPunch(target);
      }
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
