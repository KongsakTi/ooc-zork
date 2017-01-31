package io.muic.ooc.zork.command;


/**
 * Created by Sam on 1/30/17.
 */
public class DropCommand extends Command{
  static private DropCommand command = null;

  public static DropCommand get() {
    command = (null == command) ? new DropCommand() : command;
    return command;
  }
  public String execute() {
    if (!isValidArgument(2)) {
      return "Invalid Argument";
    }

    String itemName = args[1];
    if (player.getBackpack().removeItem(itemName)) {
      return itemName + " has been droped";
    }
    return "Are you shitting me? trying to throw away something you don't have";
  }
}
