package command;

import io.muic.ooc.zork.*;
import io.muic.ooc.zork.command.Command;
import io.muic.ooc.zork.command.DropCommand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 1/31/17.
 */
public class DropCommandTest {
  private String NAME = "Kogusaki";
  private int MAX_HEALTH = 100;
  private int ARMOR = 5;
  private int DAMAGE = 5;

  @Test
  public void execute() throws Exception {
    GameMap gameMap = new GameMap(1, new MonsterFactory(1), new ItemFactory());
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);
    player.getBackpack().addItem(new Potion("Potion-101", 1, 1));
    String[] args = {"", "Potion-101"};

    Command command = DropCommand.get().setup(gameMap, player, args);
    assertEquals("Potion-101 has been droped", command.execute());

  }


}