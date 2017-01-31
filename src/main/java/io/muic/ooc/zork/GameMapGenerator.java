package io.muic.ooc.zork;


public class GameMapGenerator {
  private static int level = 1;
  public GameMap makeMap() {
    ItemFactory itemFactory = new ItemFactory();
    MonsterFactory monsterFactory = new MonsterFactory(level);

    GameMap gameMap = new GameMap(level, monsterFactory, itemFactory);
    level++;
    return gameMap;
  }

}
