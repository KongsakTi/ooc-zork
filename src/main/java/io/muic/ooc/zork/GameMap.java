package io.muic.ooc.zork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameMap {

  static int MAX_ROOM = 10;
  static Random RANDOM = new Random();
  static String[] DIRECTIONS = {"north", "east", "west", "south"};

  int roomNumber;
  ItemFactory itemFactory;
  MonsterFactory monsterFactory;

  List<Room> rooms = new ArrayList<>();

  Room currentRoom;

  public GameMap(MonsterFactory monsterFactory, ItemFactory itemFactory) {
    this.monsterFactory = monsterFactory;
    this.itemFactory = itemFactory;

    roomNumber = 1;
    currentRoom = makeRoom();
  }

  private Room getNextRoom(Room currentRoom, Room newRoom) {
    return (RANDOM.nextInt(2) == 0) ? currentRoom : newRoom;
  }

  private String getDirection() {
    int directionIdx = RANDOM.nextInt(4);
    String direction = DIRECTIONS[directionIdx];
    return direction;
  }

  private String getReverseDirection(String direction) {
    switch (direction) {
      case "north":
        return "south";
      case "south":
        return "north";
      case "east":
        return "west";
      case "west":
        return "east";
      default: return "Error";
    }
  }

  public Room makeRoom() {
    Monster monster = monsterFactory.makeMonster();
    Item item = itemFactory.makeItem();
    Room room = new Room(roomNumber++, monster, item);
    rooms.add(room);
    return room;
  }

  public Room makeRooms() {

    for (int numberOfRoom = 1; numberOfRoom < MAX_ROOM; numberOfRoom++) {

      Room newRoom = makeRoom();
      boolean success = false;

      while (!success) {
        success = tryPlaceNewRoom(newRoom);
        currentRoom = rooms.get(RANDOM.nextInt(rooms.size()));
      }

      currentRoom = getNextRoom(currentRoom, newRoom);
    }
    return this.currentRoom;
  }

  public void setCurrentRoom(Room room) {
    currentRoom = room;
  }
  public Room getCurrentRoom() {
    return currentRoom;
  }

  public boolean tryPlaceNewRoom(Room newRoom) {
    int numberOfTrial = 0;

    // Random for 4 times instead of loop to avoid make room pattern
    while (numberOfTrial < 4) {
      String direction = getDirection();
      if (!currentRoom.hasExit(direction)) {
        currentRoom.setExit(direction, newRoom);
        newRoom.setExit(getReverseDirection(direction), currentRoom);
        return true;
      }
      numberOfTrial++;
    }
    return false;
  }
}
