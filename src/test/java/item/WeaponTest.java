package item;

import io.muic.ooc.zork.Monster;
import io.muic.ooc.zork.Weapon;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sam on 1/30/17.
 */
public class WeaponTest {

  private final String NAME = "Monster";
  private final int MAX_HEALTH = 100;
  private final int ARMOR = 0;
  private final int DAMAGE = 5;

  private final int NUMBER_OF_USE = 10;
  private final int WEAPON_DAMAGE = 10;

  @Test
  public void use() throws Exception {
    Weapon weapon = new Weapon("Sword", NUMBER_OF_USE, WEAPON_DAMAGE);
    Monster monster = new Monster(NAME, MAX_HEALTH, ARMOR, DAMAGE, 1);

    int currentHealth = monster.getHealth();

    weapon.use(monster);
    assertEquals(currentHealth - WEAPON_DAMAGE, monster.getHealth());
    assertEquals(NUMBER_OF_USE - 1, weapon.getNumberOfUse());
  }

}