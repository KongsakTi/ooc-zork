package java.Room;

import io.muic.ooc.zork.Monster;
import io.muic.ooc.zork.Potion;
import io.muic.ooc.zork.Room;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 1/30/17.
 */
public class RoomTest {
  private static final int ROOM_NUMBER = 1;
  private static final Monster MONSTER = new Monster("Monster", 10, 1, 1, 1);
  private static final Potion POTION = new Potion("Potion", 1, 1);
  private static final Room ROOM_TWO = new Room(2, null, null);

  @Test
  public void hasExit() throws Exception {
    Room room = new Room(ROOM_NUMBER, MONSTER, POTION);

    assertFalse(room.hasExit("north"));

    room.setExit("north", ROOM_TWO);
    assertTrue(room.hasExit("north"));
  }

  @Test
  public void getNextRoom() throws Exception {
    Room room = new Room(ROOM_NUMBER, MONSTER, POTION);
    room.setExit("north", ROOM_TWO);

    assertSame(ROOM_TWO, room.getNextRoom("north"));
  }

  @Test
  public void getMonster() throws Exception {
    Room room = new Room(ROOM_NUMBER, MONSTER, POTION);
    assertSame(MONSTER, room.getMonster());
  }

  @Test
  public void removeMonster() throws Exception {
    Room room = new Room(ROOM_NUMBER, MONSTER, POTION);
    room.removeMonster();
    assertSame(null, room.getMonster());
  }

  @Test
  public void getItem() throws Exception {
    Room room = new Room(ROOM_NUMBER, MONSTER, POTION);
    assertSame(POTION, room.getItem());
  }

  @Test
  public void getRoomNumber() throws Exception {

  }

}