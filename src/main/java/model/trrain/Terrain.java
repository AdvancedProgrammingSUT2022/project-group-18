package model.trrain;
public class Terrain {

  private int food;
  private int production;
  private double combatModifires;
  private int gold;
  private int movementCost;
  private boolean passable;

  public Terrain(int food, int production, double combatModifires, int gold, int movmentCost, boolean passable) {
    this.food = food;
    this.production = production;
    this.combatModifires = combatModifires;
    this.gold = gold;
    this.movementCost =movmentCost;
    this.passable=passable;
  }

  public int getFood() {
    return this.food;
  }

  public int getProduction() {
    return this.production;
  }

  public double getCombatModifiers() {
    return this.combatModifires;
  }

  public int getGold() {
    return this.gold;
  }
  public int getMovementCost() {
    return this.movementCost;
  }
}
