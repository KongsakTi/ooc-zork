package io.muic.ooc.zork.command;

import io.muic.ooc.zork.Room;

/**
 * Created by Sam on 1/30/17.
 */
public class GoCommand extends Command {
  static private GoCommand command = null;


  public static GoCommand get() {
    command = (null == command) ? new GoCommand() : command;
    return command;
  }

  public String execute() {
    if (!isValidArgument(2)) {
      return "Invalid Argument";
    }

    String direction = args[1];
    Room room = gameMap.getCurrentRoom();
    Room nextRoom = room.getNextRoom(direction);

    if (null != nextRoom) {
      gameMap.setCurrentRoom(nextRoom);
      return "Going " + direction + " to Room: " + nextRoom.getRoomNumber();
    }
    return "Running into a wall isn't a good idea you know ~";
  }

}
