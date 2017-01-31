package io.muic.ooc.zork.command;

import java.util.HashMap;

/**
 * Created by Sam on 1/30/17.
 */
public class CommandFactory {

  private static CommandFactory commandFactory;

  private static HashMap<String, Command> registeredCommands = new HashMap<String, Command>(){
    {
      put("take",  TakeCommand.get());
      put("drop", DropCommand.get());
      put("go", GoCommand.get());
      put("info", InfoCommand.get());
      put("use", UseCommand.get());
      put("attack", AttackWithCommand.get());
      put("help", HelpCommand.get());
    }
  };

  public static Command getCommand(String command) {
    commandFactory = (null == commandFactory) ? new CommandFactory() : commandFactory;
    return commandFactory.registeredCommands.get(command);
  }

  public static boolean hasCommand(String command) {
    return registeredCommands.containsKey(command);
  }
}
