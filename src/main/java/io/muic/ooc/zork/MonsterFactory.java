package io.muic.ooc.zork;

import java.util.Random;


public class MonsterFactory {
  static Random random = new Random();
  static int level;

  public MonsterFactory(int level) {
    this.level = level;
  }

  public Monster makeMonster() {
    //  +1 to prevent 0 health
    int maxHealth = random.nextInt(5) * level + 1;
    int armor = random.nextInt(2) * level;
    int damage = random.nextInt(3) * level;

    return new Monster("Monster", maxHealth, armor, damage, level);
  }
}
