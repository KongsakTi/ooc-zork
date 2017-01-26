package io.muic.ooc.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gigadot on 12-Jan-17.
 */
public class Room {
    private final static int MAX_ITEMS = 3;
    private List<Item> items = new ArrayList<>();
    private Monster monster = null;

    private Map<String , Room> exitMap = new HashMap<>();

    public boolean addItem(Item item) {
        if (items.size() < MAX_ITEMS) {
            items.add(item);
            return true;
        } else {
            return false;
        }
    }

    public String getInfo() {
        // print items
        // print monster
        // print exits
        return "TODO";
    }

    public void setMonster(Monster monster) {
        if (this.monster != null) {
            this.monster = monster;
        }
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

}
