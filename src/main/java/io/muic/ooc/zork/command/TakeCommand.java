package io.muic.ooc.zork.command;

import io.muic.ooc.zork.Item;
import io.muic.ooc.zork.Room;

/**
 * Created by Sam on 1/30/17.
 */
public class TakeCommand extends Command {
  static private TakeCommand command = null;

  public static TakeCommand get() {
    command = (null == command) ? new TakeCommand() : command;
    return command;
  }
  public String execute() {
    if (!isValidArgument(2)) {
      return "Invalid Argument";
    }

    String itemName = args[1];
    Room room = gameMap.getCurrentRoom();
    Item item = room.getItem();
    if (item != null && item.getName().equals(itemName)) {
      if (player.getBackpack().addItem(item)) {
        room.removeItem();
        return player.getName() + " aquire : " + itemName;
      }
      return "No room left in your backpack";
    }
    return "This room has no " + itemName;
  }
}
