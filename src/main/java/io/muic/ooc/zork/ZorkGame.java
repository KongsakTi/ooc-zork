package io.muic.ooc.zork;

import java.util.Scanner;


public class ZorkGame {

  private Player player;
  private CommandParser commandParser;
  private GameMapGenerator gameMapGenerator;
  private GameMap gameMap;

  public void start() {
    Scanner scanner = new Scanner(System.in);
    commandParser = new CommandParser();
    gameMapGenerator = new GameMapGenerator();
    gameMap = gameMapGenerator.makeMap();


    boolean quit = false;

    player = new Player("Kogusaki",100, 10, 3);
    gameMap.makeRooms();

    System.out.println("Zork: Hello, Welcome to my world.");

    while (!quit) {
      System.out.print("You: ");
      String input = scanner.nextLine();

      quit = input.equals("quit");
      if (!quit) {
        commandParser.parseCommand(input, gameMap, player);
      } else {
        return;
      }
    }
  }

//  public void walk() {
//
//  }

}
