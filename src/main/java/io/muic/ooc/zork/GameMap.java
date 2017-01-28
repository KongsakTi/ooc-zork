package io.muic.ooc.zork;

import java.util.Random;


public class GameMap {

  static ItemFactory itemFactory;
  static MonsterFactory monsterFactory;
  static int roomNumber;

  static int MAX_ROOM = 10;
  static Random RANDOM = new Random();
  static String[] DIRECTIONS = {"north", "east", "west", "south"};

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
    return room;
  }

  public Room makeRooms() {
    Room currentRoom = this.currentRoom;

    for (int numberOfRoom = 1; numberOfRoom < MAX_ROOM; numberOfRoom++) {

      Room newRoom = makeRoom();
      String direction = getDirection();
      newRoom.setExit(getReverseDirection(direction), currentRoom);

      currentRoom.setExit(direction, newRoom);
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
}
