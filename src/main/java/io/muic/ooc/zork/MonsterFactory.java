package io.muic.ooc.zork;

import java.util.Random;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class MonsterFactory {
  static Random random = new Random();
  static int level;

  public MonsterFactory(int level) {
    this.level = level;
  }

  public Monster makeMonster(String itemType) {
    switch (itemType) {
      case "Monster": return new Monster("Monster", random.nextInt(5) * level, random.nextInt(2) * level, random.nextInt(3) * level, level);
      default: return null;
    }
  }
}
