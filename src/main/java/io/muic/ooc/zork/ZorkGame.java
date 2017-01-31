package io.muic.ooc.zork;

import java.util.Scanner;


public class ZorkGame {

  private Player player;
  private CommandParser commandParser;
  private GameMapGenerator gameMapGenerator;
  private GameMap gameMap;
  private int MAX_LEVEL = 3;

  public void start() {
    Scanner scanner = new Scanner(System.in);
    commandParser = new CommandParser();
    gameMapGenerator = new GameMapGenerator();
    gameMap = gameMapGenerator.makeMap();


    boolean quit = false;

    player = new Player("Kogusaki",100, 0, 3);
    gameMap.makeRooms();

    try {
      Runtime.getRuntime().exec("cls");
    } catch (Exception e) {}

    System.out.println("\033\143");
    System.out.println("Zork: Hello, Welcome to my world.");

    while (!quit) {
      System.out.print(">>> ");
      String input = scanner.nextLine();

      quit = input.equals("quit");
      if (!quit) {
        commandParser.parseCommand(input, gameMap, player);
        gameMap = (0 == gameMap.getNumberOfMonster()) ? getNextLevelMap() : gameMap;
        if (hasCompletedGame()) {
          System.out.println("You have complete this game, Congratulations !");
          return;
        }
      } else {
        return;
      }
    }
  }

  private GameMap getNextLevelMap() {
    System.out.println("Proceed to the next level !");
    gameMap = gameMapGenerator.makeMap();
    gameMap.makeRooms();
    return gameMap;
  }

  private boolean hasCompletedGame() {
    return gameMap.getLevel() > MAX_LEVEL;
  }
}
