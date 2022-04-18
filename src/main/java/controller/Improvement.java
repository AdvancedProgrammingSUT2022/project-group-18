package controller;


import model.techs.Technologies;
import model.techs.Technology;

public class Improvement {
  private int food;
  private int production;
  private int gold;
  private Technology technologieRequired;
  public Improvement(int food, int production, int gold , Technology technologieRequired) {
    this.food = food;
    this.production = production;
    this.gold = gold;
    this.technologieRequired = technologieRequired;
  }
  public void newCamp(){new Improvement(0,0,0 , Technologies.trapping);}
  public void newFarm(){new Improvement(1, 0, 0 , Technologies.Farming);}
  public void newLumberMill(){new Improvement(0, 1, 0, Technologies.SakhtOSaz);}
  public void newMine(){new Improvement(0, 1,  0, Technologies.Mining);}
  public void newPasture(){new Improvement(0, 0 , 0 , Technologies.DamParvari);}
  public void newWorkandFarm(){new Improvement(0,0,0, Technologies.Calender);}
  public void newStoneMine(){new Improvement(0,0,0, Technologies.SangTarashi);}
  public void newTradingPost(){new Improvement(0, 0, 1, Technologies.trapping);}
  public void newFactory(){new Improvement(0 , 2 , 0, Technologies.Mohandesi);}


  public int getFood() {return this.food;}

  public int getProduction() {return this.production;}

  public int getGold() {return this.gold;}
}
