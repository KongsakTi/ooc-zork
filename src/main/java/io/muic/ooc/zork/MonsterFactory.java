package io.muic.ooc.zork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MonsterFactory {
  private static Random random = new Random();
  private static int level;
  private static List<String> NAMES; {
    NAMES = new ArrayList<>();
    NAMES.add("Aamon");
    NAMES.add("Chemosh");
    NAMES.add("Maricha ");
    NAMES.add("Semyaza");
  }


  public MonsterFactory(int level) {
    this.level = level;
  }

  public Monster makeMonster() {
    //  +1 to prevent 0 health
    int maxHealth = (random.nextInt(5) + 10) * level;
    int armor = random.nextInt(2) * level;
    int damage = (random.nextInt(3) + 3) * level;
    String name = NAMES.get(random.nextInt(NAMES.size()));

    return new Monster(name, maxHealth, armor, damage, level);
  }
}
