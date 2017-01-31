package io.muic.ooc.zork.command;

import io.muic.ooc.zork.Monster;
import io.muic.ooc.zork.Room;

/**
 * Created by Sam on 1/30/17.
 */
public class AttackWithCommand extends Command {
  private Room room;
  private Monster monster;
  static private AttackWithCommand command = null;

  public static AttackWithCommand get() {
    command = (null == command) ? new AttackWithCommand() : command;
    return command;
  }

  public String execute() {
    if (!isValidArgument(3)) {
      return "Invalid Argument";
    }

    String weaponName = args[2];
    room = gameMap.getCurrentRoom();
    monster = room.getMonster();
    if (null == monster) {
      return "Are you nut? there is no one else here";
    }

    if (player.getBackpack().useWeapon(weaponName, monster)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Take this f*cker\n")
                  .append(room.getMonster().getName());

      if (monster.isDeath()) {
        stringBuilder.append(": Gaaaaaahh *die!!\n");
        killMonster();
      } else {
        stringBuilder.append(": Waaaaahh !!");
        monster.attack(player);
      }

      return stringBuilder.toString();
    }
    return "Imaginary weapon aint gonna do shit";
  }

  public void killMonster() {
    room.removeMonster();
    player.addExp(monster.dropLoop());
    gameMap.reduceNumberOfMonster(1);
  }
}
