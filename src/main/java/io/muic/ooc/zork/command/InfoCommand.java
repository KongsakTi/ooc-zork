package io.muic.ooc.zork.command;


/**
 * Created by Sam on 1/30/17.
 */
public class InfoCommand extends Command{

  static private InfoCommand command = null;

  public static InfoCommand get() {
    command = (null == command) ? new InfoCommand() : command;
    return command;
  }

  public String execute() {
    if (!isValidArgument(1)) {
      return "Invalid Argument";
    }

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("--------------------\n")
            .append(player.getInfo())
            .append("--------------------\n")
            .append(gameMap.getCurrentRoom().getInfo())
            .append("--------------------\n")
            .append(gameMap.getInfo())
            .append("--------------------\n");
    return stringBuilder.toString();
  }
}
