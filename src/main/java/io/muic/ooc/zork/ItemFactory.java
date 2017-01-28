package io.muic.ooc.zork;

import java.util.Random;


public class ItemFactory {
  static int itemNumber = 0;
  static Random random = new Random();
  static String[] items = {"Potion", "Weapon"};

  public Item makeItem(int itemType) {
    // +1 to prevent 0 number of use
    int quantity = random.nextInt(10) + 1;
    int quality = random.nextInt(10);

    switch (itemType) {
      case 0: return new Potion("Potion-" + itemNumber++, quantity, quality);
      case 1: return new Weapon("Sword-" + itemNumber++, quantity, quality);
      default: return null;
    }
  }

  public Item makeItem() {
    int itemType = random.nextInt(items.length + 2);
    return makeItem(itemType);
  }
}
