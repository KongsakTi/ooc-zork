package io.muic.ooc.zork;


public abstract class Item extends ItemFactory {
  private int numberOfUse;
  private String name;

  public Item(String name, int numberOfUse) {
    this.name = name;
    this.numberOfUse = numberOfUse;
  }

  public String getName() {
    return name;
  }

  public int getNumberOfUse() {
    return numberOfUse;
  }

  public void setNumberOfUse(int numberOfUse) {
    this.numberOfUse = numberOfUse;
  }

  public String getInfo() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(name)
            .append(": ");
    stringBuilder.append("[number of use: ")
            .append(numberOfUse)
            .append("] \n");

    return stringBuilder.toString();
  }
}
