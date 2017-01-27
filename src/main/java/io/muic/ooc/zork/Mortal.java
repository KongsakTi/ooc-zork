package io.muic.ooc.zork;

/**
 * Created by Sam on 1/26/17.
 */
public abstract class Mortal {
  private String name;

  private int maxHealth;
  private int health;
  private int armor;
  private int damage;
  private int level;


  public Mortal(String name, int maxHealth, int armor, int damage) {
    this.name = name;
    this.maxHealth = maxHealth;
    this.health = maxHealth;
    this.armor = armor;
    this.damage = damage;
    this.level = 1;
  }

  public Mortal(String name, int maxHealth, int armor, int damage, int level) {
    this.name = name;
    this.maxHealth = maxHealth;
    this.health = maxHealth;
    this.armor = armor;
    this.damage = damage;
    this.level = level;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = (health < 0) ? 0 : (health > maxHealth) ? maxHealth : health;
  }

  public boolean isDeath() {
    return 0 <= this.health;
  }

  public int getArmor() {
    return armor;
  }

  public void setArmor(int armor) {
    this.armor = armor;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
}
