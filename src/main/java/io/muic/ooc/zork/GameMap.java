package io.muic.ooc.zork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameMap {

  private static final int MAX_ROOM = 10;
  private static final Random RANDOM = new Random();
  private static final String[] DIRECTIONS = {"north", "east", "west", "south"};

  private final int level;
  private final ItemFactory itemFactory;
  private final MonsterFactory monsterFactory;

  private List<Room> rooms = new ArrayList<>();

  private Room currentRoom;
  private int numberOfMonster;
  private int roomNumber;

  public GameMap(int level, MonsterFactory monsterFactory, ItemFactory itemFactory) {
    this.level = level;
    this.monsterFactory = monsterFactory;
    this.itemFactory = itemFactory;

    numberOfMonster = 0;

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

  private Room makeRoom() {
    Monster monster = monsterFactory.makeMonster();
    Item item = itemFactory.makeItem();
    Room room = new Room(roomNumber++, monster, item);
    rooms.add(room);
    numberOfMonster += (null != monster) ? 1 : 0;
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

  public void reduceNumberOfMonster(int numberOfMonsterDie) {
    numberOfMonster -= numberOfMonsterDie;
  }
  public int getNumberOfMonster() {
    return numberOfMonster;
  }
  public int getLevel() {return  level;}

  public String getInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Map: ")
                .append(level)
                .append(" \n")
                .append("[Number of Monster left in this map: ")
                .append(numberOfMonster)
                .append("]\n");
    return stringBuilder.toString();
  }
}
