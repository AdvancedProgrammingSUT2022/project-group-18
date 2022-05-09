package model;
import model.unit.UnitEnum;
import model.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class BaseCivilization {
  private final String name;
  private Integer numberOfCities = 0;
  private Integer sciencePT = 0;
  private Integer scienceTotal = 0;
  private Integer goldTotal = 0;
  private Integer goldPT = 0;
  private Integer cultureTotal = 0;
  private Integer cultureRequired = 0;
  private Integer culturePT = 0;
  private static Integer happiness = 0;
  private ArrayList<Unit> units;
  private String[] cityNames;
  private ArrayList<City> cities;



  public BaseCivilization(String name, String[] cityNames) {
    this.units = new ArrayList<>();
    this.cityNames = cityNames;
    this.name = name;
    this.cities = new ArrayList<>();
  }

  public boolean sameCivilization() {

    return false; //just for no errors
  }

  private String getNextCityName() {

    return null;//just for no errors

  }

  public static void setHappiness(Integer happiness) {BaseCivilization.happiness = happiness;}
  public Integer getHappiness() {
    return happiness;
  }
  public Integer getNumberOfCities() {
    return numberOfCities;
  }
  public void decreaseHappinessByAmount() {

  }



  private boolean canCreateCity() {

    return false;//just for no errors
  }



  private void updateResourceYields() {

  }

  public List<Unit> getUnits() {
    return units;
  }

  public List<City> getCities() {
    return cities;
  }



  public String getName() {
    return this.name;
  }

  public Integer getSciencePT() {
    return sciencePT;
  }

  public Integer getGoldTotal() {
    return goldTotal;
  }

  public Integer getGoldPT() {
    return goldPT;
  }

  public Integer getCultureTotal() {
    return cultureTotal;
  }

  public Integer getCultureRequired() {
    return cultureRequired;
  }

  public Integer getCulturePT() {
    return culturePT;
  }

  public void addUnit() {

  }

  public void replaceUnit() {

  }

  public void deleteUnit() {

  }
  



  public ArrayList<UnitEnum> getAvailableUnits() {
      //WE DONT KNOW
    return new ArrayList<UnitEnum>(); // just for no errors
  }

  public void nextTurn() {

  }
}
