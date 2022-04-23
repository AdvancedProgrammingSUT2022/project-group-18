package civilization;
import controller.CityController;
import model.unit.Unit;

import java.util.List;

public class BaseCivilization {
  private final String name;
  private int numberOfCities = 0;
  private int sciencePT = 0;
  private int scienceTotal = 0;
  private int goldTotal = 0;
  private int goldPT = 0;
  private int cultureTotal = 0;
  private int cultureRequired = 0;
  private int culturePT = 0;
  private int happiness = 0;
  private List<Unit> units;
  private String[] cityNames;
  private List<CityController> cities;

  private List<Unit> units;
  private String[] cityNames;

  private List<CityController> cities;



  public BaseCivilization(String name, String[] cityNames) {
    this.units = new ArrayList<>();
    this.cityNames = cityNames;
    this.name = name;
    this.cities = new ArrayList<>();
  }

  public boolean sameCivilization() {


  }

  private String getNextCityName() {


  }

  public int getHappiness() {
    return happiness;
  }
  public int getNumberOfCities() {
    return numberOfCities;
  }
  public void decreaseHappinessByAmount() {

  }



  private boolean canCreateCity() {

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

  public int getSciencePT() {
    return sciencePT;
  }

  public int getGoldTotal() {
    return goldTotal;
  }

  public int getGoldPT() {
    return goldPT;
  }

  public int getCultureTotal() {
    return cultureTotal;
  }

  public int getCultureRequired() {
    return cultureRequired;
  }

  public int getCulturePT() {
    return culturePT;
  }

  public void addUnit() {

  }

  public void replaceUnit() {

  }

  public void deleteUnit() {

  }
  



  public List<UnitEnum> getAvailableUnits() {

  }

  public void nextTurn() {

  }
}
