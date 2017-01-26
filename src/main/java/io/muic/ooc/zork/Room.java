package io.muic.ooc.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class Room {
    private Monster monster = null;
    private Item item = null;

//    public Room(Monster monster, Item item) {
//        this.monster = monster;
//        this.item = item;
//    }

    private Map<String , Room> exitMap = new HashMap<>();

    public String getInfo() {
      // print items
      // print monster
      // print exits

      StringBuilder sb = new StringBuilder();

      if (item != null) {
        sb.append(item.getName()).append(" ");
      }

      if (monster != null) {
        sb.append(monster.getName()).append(" ");
      }

      sb.append(exitMap.keySet());


      return sb.toString();
    }

    public void setExit(String direction, Room exitingRoom) {
        switch(direction) {
            case "north":
            case "east":
            case "west":
            case "south":
                exitMap.put(direction, exitingRoom);
            default:;
        }
    }

    public Room getRoom(String direction) {
      if (exitMap.containsKey(direction)) {
        return exitMap.get(direction);
      } else {
        return null;
      }
    }


}
