package io.muic.ooc.zork;

import java.util.Random;


public class ItemFactory {
  static int ITEM_DROP_RATE = 0; // 0 => Every room will have 1 item
  static int ITEM_NUMBER = 0;
  static String[] ITEMS = {"Potion", "Weapon"};

  static Random RAMDOM = new Random();

  public Item makeItem(int itemType) {
    // +1 to prevent 0 number of use
    int quantity = RAMDOM.nextInt(10) + 1;
    int quality = RAMDOM.nextInt(10);

    switch (itemType) {
      case 0: return new Potion("Potion-" + ITEM_NUMBER++, quantity, quality);
      case 1: return new Weapon("Sword-" + ITEM_NUMBER++, quantity, quality);
      default: return null;
    }
  }

  public Item makeItem() {
    int itemType = RAMDOM.nextInt(ITEMS.length + ITEM_DROP_RATE);
    return makeItem(itemType);
  }
}
