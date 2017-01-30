package io.muic.ooc.zork;

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
    this.health = health;
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

  public void takeDamage(int damage) {
    setHealth(health - reduceDamage(damage));
  }

  private int reduceDamage(int damage) {
    int recudedDamage = damage - armor;
    return (recudedDamage <= 0) ? 0 : recudedDamage;
  }

  public void heal(int healAmount) {
    int healedHealth = health + healAmount;
    health = (healedHealth > maxHealth) ? maxHealth : healedHealth;
  }

  public String getInfo() {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(this.name)
            .append(" \n");
    stringBuilder.append("[health: ")
            .append(this.health)
            .append("] \n");
    stringBuilder.append("[armor: ")
            .append(this.armor)
            .append("] \n");
    stringBuilder.append("[damage: ")
            .append(this.damage)
            .append("] \n");
    stringBuilder.append("[level: ")
            .append(this.level)
            .append("] \n");

    return stringBuilder.toString();
  }
}
