package command;

import io.muic.ooc.zork.*;
import io.muic.ooc.zork.command.AttackWithCommand;
import io.muic.ooc.zork.command.Command;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 1/30/17.
 */
public class AttackWithCommandTest {
  private String NAME = "Kogusaki";
  private int MAX_HEALTH = 100;
  private int ARMOR = 5;
  private int DAMAGE = 5;

  @Test
  public void execute() throws Exception {
    GameMap gameMap = new GameMap(1, new MonsterFactory(1), new ItemFactory());
    gameMap.setCurrentRoom(new Room(1 ,
            new Monster("Monster", 100, 0, 0, 1),
            new Potion("Potion", 1, 1)));

    Monster monster = gameMap.getCurrentRoom().getMonster();

    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);
    String[] args = {"", "", "fist"};

    Command command =
            AttackWithCommand.get().setup(gameMap, player, args);
    command.execute();

    assertEquals(100 - DAMAGE, monster.getHealth());
  }

}