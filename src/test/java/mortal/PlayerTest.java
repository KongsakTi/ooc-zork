package mortal;

import io.muic.ooc.zork.Monster;
import io.muic.ooc.zork.Player;
import io.muic.ooc.zork.Potion;
import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by Sam on 1/30/17.
 */
public class PlayerTest extends TestCase {
  private final String NAME = "Kogusaki";
  private final int MAX_HEALTH = 100;
  private final int ARMOR = 10;
  private final int DAMAGE = 5;


  @Test
  public void testAddExp() throws Exception {
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);
    int currentExp = player.getExp();
    player.addExp(5);
    assertEquals( player.getExp(), currentExp + 5);
  }

  @Test
  public void testLevelUp() throws Exception {
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);
    int currentLevel = player.getLevel();
    player.addExp(0);
    assertEquals(currentLevel, player.getLevel());

    player.addExp(currentLevel * 15);
    assertEquals(currentLevel + 1, player.getLevel());
  }

  @Test
  public void testXiaolinPunch() throws Exception {
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);
    Monster monster = new Monster("Monster", 100, 0, 0, 1);
    int monsterHealth = monster.getHealth();
    player.xiaolinPunch(monster);
    assertEquals(monsterHealth - player.getDamage(), monster.getHealth());
  }

  @Test
  public void testGetBackpack() throws Exception {
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);
    Player.Backpack backpack = player.getBackpack();

    Potion potion = new Potion("Potion", 1, 1);
    backpack.addItem(potion);
    assertTrue(backpack.removeItem("Potion"));
  }

}