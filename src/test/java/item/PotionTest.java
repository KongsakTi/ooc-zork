package item;

import io.muic.ooc.zork.Player;
import io.muic.ooc.zork.Potion;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 1/30/17.
 */
public class PotionTest {
  private final String NAME = "Kogusaki";
  private final int MAX_HEALTH = 100;
  private final int ARMOR = 0;
  private final int DAMAGE = 5;

  private final int NUMBER_OF_USE = 10;

  @Test
  public void use() throws Exception {
    Potion potion = new Potion("Potion", NUMBER_OF_USE, 1);
    Player player = new Player(NAME, MAX_HEALTH, ARMOR, DAMAGE);
    player.takeDamage(20);
    int currentHealth = player.getHealth();

    potion.use(player);
    assertEquals(currentHealth + 1, player.getHealth());
    assertEquals(NUMBER_OF_USE - 1, potion.getNumberOfUse());
  }

}