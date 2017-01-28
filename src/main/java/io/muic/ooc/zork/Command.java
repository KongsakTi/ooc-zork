package io.muic.ooc.zork;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class Command {

  private GameMap gameMap;
  private Room room;
  private Player player;

  public Command(GameMap gameMap, Player player) {
    this.gameMap = gameMap;
    this.player = player;
    room = gameMap.getCurrentRoom();

  }

  public String getInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("--------------------\n");
    stringBuilder.append(player.getInfo());
    stringBuilder.append("--------------------\n");
    stringBuilder.append(room.getInfo());
    return stringBuilder.toString();
  }

  public String takeItem(String itemName) {
    Item item = room.getItem();
    if (item != null && item.getName().equals(itemName)) {
      if (player.getBackpack().addItem(item)) {
        room.setItem(null);
        return player.getName() + " aquire : " + itemName;
      }
      return "No room left in your backpack";
    }
    return "This room has no " + itemName;
  }

  public String dropItem(String itemName) {
    if (player.getBackpack().removeItem(itemName)) {
      return itemName + " has been droped";
    }
    return "Are you shitting me? trying to throw away something you don't have";
  }

  public String useItem(String itemName) {
    if (player.getBackpack().useItem(itemName)) {
      return "Wow this shit is good";
    }
    return "You aint got that in your backpack bro";
  }

  public String goTo(String direction) {
    Room nextRoom = room.getNextRoom(direction);

    if (null != nextRoom) {
      gameMap.setCurrentRoom(nextRoom);
      return "Going " + direction + " to Room: " + nextRoom.getRoomNumber();
    }
    return "Running into a wall isn't a good idea you know ~";
  }


}
