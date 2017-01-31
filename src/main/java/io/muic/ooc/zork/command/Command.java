package io.muic.ooc.zork.command;

import io.muic.ooc.zork.GameMap;
import io.muic.ooc.zork.Player;

/**
 * Created by Sam on 1/30/17.
 */
public abstract class Command {
  GameMap gameMap;
  Player player;
  String[] args;
  int argsLength;

  public Command setup(GameMap gameMap, Player player, String[] args) {
    this.gameMap = gameMap;
    this.player = player;
    this.args = args;

    return this;
  }

  public abstract String execute();

  boolean isValidArgument(int expectedLength) {
    return args.length == expectedLength;
  }

}
