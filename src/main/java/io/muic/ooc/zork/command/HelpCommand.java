package io.muic.ooc.zork.command;

/**
 * Created by Sam on 1/31/17.
 */
public class HelpCommand extends Command {
  static private HelpCommand command = null;

  public static HelpCommand get() {
    command = (null == command) ? new HelpCommand() : command;
    return command;
  }

  public String execute() {
    if (!isValidArgument(1)) {
      return "Invalid Argument";
    }

    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder
      .append("info - display information about play, current room, map, etc.\n")
      .append("take {item name} - take {item name} from current room\n")
      .append("drop {item name} - drop {item name} from player backpack\n")
      .append("use {potion name} - use {potion name} on player\n")
      .append("go {direction} - go to {direction} of the current room\n")
      .append("attack with {weapon name} - attack monster in current room with {weapon name}\n")
      .append("quit - give up on this and be a loser forever\n");


    return stringBuilder.toString();
  }
}
