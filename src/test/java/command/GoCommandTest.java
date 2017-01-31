package command;

import io.muic.ooc.zork.*;
import io.muic.ooc.zork.command.Command;
import io.muic.ooc.zork.command.GoCommand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 1/31/17.
 */
public class GoCommandTest {
  private String NAME = "Kogusaki";
  private int MAX_HEALTH = 100;
  private int ARMOR = 5;
  private int DAMAGE = 5;

  @Test
  public void execute() throws Exception {
    GameMap gameMap = new GameMap(1, new MonsterFactory(1), new ItemFactory());
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);

    Room room_1 = new Room(1,null, null);
    Room room_2 = new Room(2,null, null);
    room_1.setExit("south", room_2);
    gameMap.setCurrentRoom(room_1);

    String[] args = {"", "south"};

    Command command = GoCommand.get().setup(gameMap, player, args);
    command.execute();

    assertSame(room_2, gameMap.getCurrentRoom());

  }


}