package io.muic.ooc.zork;

import io.muic.ooc.zork.command.*;


/**
 * Created by gigadot on 12-Jan-17.
 */
public class CommandParser {

  public void parseCommand(String input, GameMap gameMap, Player player) {
    String[] words = input.split(" ");
    String displayText = "There exists no such command";
    String inputCommand = words[0];
    if (CommandFactory.hasCommand(inputCommand)) {
      Command command = CommandFactory.getCommand(inputCommand)
              .setup(gameMap, player, words);
      displayText = command.execute();
    }
    System.out.println(displayText);
  }
}
