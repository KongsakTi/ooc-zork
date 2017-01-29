package io.muic.ooc.zork;

import java.util.HashMap;
import java.util.Map;


public class Room {
    private Monster monster = null;
    private Item item = null;
    private int roomNumber;

    public Room(int roomNumber, Monster monster, Item item) {
        this.monster = monster;
        this.item = item;
        this.roomNumber = roomNumber;
    }

    private Map<String , Room> exitMap = new HashMap<>();

    public String getInfo() {
      StringBuilder sb = new StringBuilder();

      sb.append("Room: ")
        .append(roomNumber)
        .append("\n");

      if (item != null) {
        sb.append(item.getInfo());
      }
      if (monster != null) {
        sb.append(monster.getInfo());
      }
      sb.append("Connected Room: \n")
        .append(exitMap.keySet())
        .append("\n");

      return sb.toString();
    }

    public boolean hasExit(String direction) {
      return exitMap.containsKey(direction);
    }
    public void setExit(String direction, Room exitingRoom) {
        switch(direction) {
            case "north":
            case "east":
            case "west":
            case "south":
                exitMap.put(direction, exitingRoom);
            default:
        }
    }


    public Room getNextRoom(String direction) {
      if (exitMap.containsKey(direction)) {
        return exitMap.get(direction);
      } else {
        return null;
      }
    }

    public Monster getMonster() {
      return monster;
    }

    public void removeMonster() {monster = null;}

    public Item getItem() {
      return item;
    }

    public void setItem(Item item) {
      this.item = item;
    }

    public int getRoomNumber() {
      return roomNumber;
    }


}
