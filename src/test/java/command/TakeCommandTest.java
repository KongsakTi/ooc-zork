package command;

import io.muic.ooc.zork.*;
import io.muic.ooc.zork.command.Command;
import io.muic.ooc.zork.command.TakeCommand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 1/31/17.
 */
public class TakeCommandTest {
  private String NAME = "Kogusaki";
  private int MAX_HEALTH = 100;
  private int ARMOR = 5;
  private int DAMAGE = 5;

  @Test
  public void execute() throws Exception {
    GameMap gameMap = new GameMap(1, new MonsterFactory(1), new ItemFactory());
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);

    Weapon weapon = new Weapon("Weapon-101", 1, 1);
    Room room_1 = new Room(1,null, weapon);
    gameMap.setCurrentRoom(room_1);

    String[] args = {"", "Weapon-101"};

    Command command = TakeCommand.get().setup(gameMap, player, args);
    command.execute();

    assertEquals(null, room_1.getItem());
    assertTrue(player.getBackpack().getItemsList().contains("Weapon-101"));
  }

}