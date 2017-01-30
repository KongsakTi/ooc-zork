package java.Mortal;

import io.muic.ooc.zork.Monster;
import io.muic.ooc.zork.Player;
import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by Sam on 1/30/17.
 */
public class MonsterTest extends TestCase {
  private final int EXP_RATE = 50;
  private final String NAME = "Kogusaki";
  private final int MAX_HEALTH = 100;
  private final int ARMOR = 10;
  private final int DAMAGE = 5;

  @Test
  public void testDropLoop() throws Exception {
    int level = 2;
    Monster monster = new Monster("Monster", 100, 1, 10, level);
    assertEquals(level * EXP_RATE, monster.dropLoop());
  }

  @Test
  public void testAttack() throws Exception {
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);
    Monster monster = new Monster("Monster", 100, 1, 10, 1);

    int currentHealth = player.getHealth();
    int raw_damage = ARMOR - monster.getDamage();
    int damage = (raw_damage > 0) ? 0 : raw_damage;
    monster.attack(player);
    assertEquals(currentHealth - damage, player.getHealth());
  }

}