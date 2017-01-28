package io.muic.ooc.zork;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class CommandParser {
  private static Command command;
  private static String displayText;

  public void parseCommand(String input, GameMap gameMap, Player player) {
    String[] words = input.split(" ");
    command = new Command(gameMap, player);

    switch (words.length) {
      case 1:
        oneWord(words);
        break;
      case 2:
        twoWords(words);
        break;
      case 3:
        threeWords(words);
        break;
    }

    System.out.println(displayText);
    displayText = null;
  }

  private void oneWord(String[] words) {
    String word = words[0];
    switch (word) {
      case "info":
        displayText = command.getInfo();
        break;
    }
  }

  private void twoWords(String[] words) {
    switch (words[0]) {
      case "take":
        displayText = command.takeItem(words[1]);
        break;
      case "drop":
        displayText = command.dropItem(words[1]);
        break;
      case "use":
        displayText = command.useItem(words[1]);
        break;
      case "go":
        displayText = command.goTo(words[1]);
    }
  }

  private void threeWords(String[] words) {
    if ("attack".equals(words[0]) && "with".equals(words[1])) {
      displayText = command.attackWith(words[2]);
    }
  }
}
