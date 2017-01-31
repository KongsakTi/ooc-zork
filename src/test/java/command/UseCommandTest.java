package command;

import io.muic.ooc.zork.*;
import io.muic.ooc.zork.command.Command;
import io.muic.ooc.zork.command.UseCommand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 1/31/17.
 */
public class UseCommandTest {
  private String NAME = "Kogusaki";
  private int MAX_HEALTH = 100;
  private int ARMOR = 5;
  private int DAMAGE = 5;

  @Test
  public void execute() throws Exception {
    GameMap gameMap = new GameMap(1, new MonsterFactory(1), new ItemFactory());
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);
    player.setHealth(10);

    Potion potion = new Potion("Potion-101", 1, 1);
    player.getBackpack().addItem(potion);

    String[] args = {"", "Potion-101"};

    Command command = UseCommand.get().setup(gameMap, player, args);
    command.execute();

    assertEquals(11, player.getHealth());
    assertFalse(player.getBackpack().getItemsList().contains("Potion-101"));
  }

}