package io.muic.ooc.zork;

import java.util.Random;


public class ItemFactory {
  private static int ITEM_DROP_RATE = 0; // 0 => Every room will have 1 item
  private static int ITEM_NUMBER = 0;

  private static String[] ITEMS = {"Potion", "Weapon"};
  private static String[] WEAPON_NAMES = {"Fish", "Sword", "Mace", "Pot"};
  private static String[] POTION_NAMES = {"Milk", "Soda", "Tea", "Coffee"};

  static Random RANDOM = new Random();

  public Item makeItem(int itemType) {
    // +1 to prevent 0 number of use
    int quantity = RANDOM.nextInt(10) + 1;
    int quality = RANDOM.nextInt(10);

    switch (itemType) {
      case 0: return new Potion(
              POTION_NAMES[RANDOM.nextInt(POTION_NAMES.length)] + "-" + ITEM_NUMBER++,
              quantity, quality);
      case 1: return new Weapon(
              WEAPON_NAMES[RANDOM.nextInt(WEAPON_NAMES.length)] + "-" + ITEM_NUMBER++,
              quantity, quality);
      default: return null;
    }
  }

  public Item makeItem() {
    int itemType = RANDOM.nextInt(ITEMS.length + ITEM_DROP_RATE);
    return makeItem(itemType);
  }
}
