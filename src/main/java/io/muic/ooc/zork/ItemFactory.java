package io.muic.ooc.zork;

import java.util.Random;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class ItemFactory {
  static Random random = new Random();
  public Item ItemFactory(String itemType) {
    switch (itemType) {
      case "Potion": return new Potion(random.nextInt(10), 10 * random.nextInt(10));
      case "Weapon": return new Weapon(random.nextInt(10), 10 * random.nextInt(10));
      default: return null;
    }
  }
}
