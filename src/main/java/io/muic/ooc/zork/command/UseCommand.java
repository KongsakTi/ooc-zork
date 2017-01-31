package io.muic.ooc.zork.command;

/**
 * Created by Sam on 1/30/17.
 */
public class UseCommand extends Command {
  static private UseCommand command = null;

  public static UseCommand get() {
    command = (null == command) ? new UseCommand() : command;
    return command;
  }

  public String execute() {
    if (!isValidArgument(2)) {
      return "Invalid Argument";
    }

    String itemName = args[1];
    if (player.getBackpack().usePotion(itemName, player)) {
      return "Wow this shit is good";
    }
    return "You aint got that in your backpack bro";
  }
}
