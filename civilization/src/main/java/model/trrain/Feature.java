package model.trrain;


import javax.swing.*;

public enum Feature {

  FLOODPLAINS(new Terrain(2, 0, -0.33, 0,1,true), "Floodplains"),
  ICE(new Terrain(0, 0, 0, 0,0, false), "Ice"),
  MARSH(new Terrain(-1, 0, -0.33, 0,2,true), "Marsh"),
  OASIS(new Terrain(3, 0, -0.33, 1,1,true), "Oasis"),
  FOREST(new Terrain(1, 1, 0.25, 0,2,true), "forest"),
  JUNGLE(new Terrain(1,1,0.25,0,2,true),"Jungle"),
  RIVER(new Terrain(0, 0, 0, 1,0,true), "River");



  private final Terrain y;
  private final String name;

  Feature(Terrain y, String name) {
    this.y = y;
    this.name = name;
  }

  public int getFoodMod() {
    return this.y.getFood();
  }

  public int getProductionMod() {
    return this.y.getProduction();
  }



  public int getGoldMod() {
    return this.y.getGold();
  }

  public String getName() {
    return this.name;
  }

  public int getMovementcost() {
    return this.y.getMovementCost();
  }


}
