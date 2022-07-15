package model;

import com.google.gson.Gson;
import controller.DataBase;
import enums.UnitEnum;
import model.Resource.Resources;
import model.graphicModel.User;
import model.techs.Technology;
import model.unit.Melee;
import model.unit.Ranged;
import model.unit.Unit;
import view.View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BaseCivilization {
    private String name;
    private Integer numberOfCities = 0;
    private Integer sciencePT = 0;
    private Integer scienceTotal = 0;
    private Integer goldTotal = 0;
    private Integer goldPT = 0;
    private Integer cultureTotal = 0;
    private Integer cultureRequired = 0;
    private Integer culturePT = 0;
    private static Integer happiness = 0;
    private ArrayList<Unit> units = new ArrayList<>();
    private String[] cityNames;
    private ArrayList<City> cities = new ArrayList<>();
    public static ArrayList<City> allCities  = new ArrayList<>();//It's a list of all cities without considering their civilization
    public static ArrayList<Unit> allUnits = new ArrayList<>();// the same as previous
    private static ArrayList<Resources> resources = new ArrayList<>();
    public ArrayList<Technology> technologies = new ArrayList<>();
    public static ArrayList<String> notifications = new ArrayList<>();

    public BaseCivilization () {
        View.setCivilization(this);
    }

    public static City findCityByName(String cityName) {
        for (City city1 : allCities) {
            if (cityName.equals(city1.getCityName()))
                return city1;
        }
        return null;
    }

    public static Unit findUnitByName(String name) {
        for (Unit unit : allUnits) {
            if(unit.getName().equals(name))
                return unit;
        }
        return null;
    }

    public int findIndexOfUnit (Unit myUnit) {
        for (Unit unit : units) {
            if(myUnit.equals(unit))
                return units.indexOf(unit);
        }
        return units.size();//there isn't any unit in units that matches with myUnit;
    }

    public BaseCivilization(String name, String[] cityNames) {
        this.units = new ArrayList<>();
        this.cityNames = cityNames;
        this.name = name;
        this.cities = new ArrayList<>();
    }

    public void addTechnology(Technology technology) {
        this.technologies.add(technology);
    }

    public ArrayList<Technology> getTechnologies() {
        return technologies;
    }

    public boolean sameCivilization() {

        return false; //just for no errors
    }

    private String getNextCityName() {

        return null;//just for no errors

    }

    public static void setHappiness(Integer happiness) {
        BaseCivilization.happiness = happiness;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public Integer getNumberOfCities() {
        return numberOfCities;
    }

    public void decreaseHappinessByAmount() {

    }

    public Integer getScienceTotal() {
        return scienceTotal;
    }

    private boolean canCreateCity() {

        return false;//just for no errors
    }


    private void updateResourceYields() {

    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public ArrayList<City> getCities() {
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

    public void nextTurn() {
        View.getInCity().addCityFood(View.getInCity().getCityPopulation() * 2);
    }

    public void addNotifications(String notification) {
        notifications.add(notification);
    }

    public static ArrayList<String> getNotifications() {
        return notifications;
    }

    public static void addResource(Resources resources) {
        BaseCivilization.resources.add(resources);
        if (resources.getType().equals("LuxuryResources") && !resourceExist(resources)) happiness+=10;
    }
    public static ArrayList<Resources> getResources() {
        return resources;
    }

    public static boolean resourceExist(Resources resource){
        for (Resources resources1 : resources){
            if (resource == resources1) return true;
        }
        return false;
    }
  public void deleteUnit(Unit unit) {
    units.remove(unit);
  }
  

  public ArrayList<UnitEnum> getAvailableUnits() {
      //WE DONT KNOW
    return new ArrayList<UnitEnum>(); // just for no errors
  }

    public void setCities(City cities) {
        this.cities.add(cities);
    }

    public void decreaseHappiness(){
    happiness -= 10;
  }

  public void increaseHappiness(){
    happiness+=10;
  }

  public void increaseGold(){
    goldTotal+=10;
  }
  public void decreaseGold(){
        if (goldTotal==0) scienceTotal-=10;
        else goldTotal-=10;
  }

  public void losingCity(City city){
        cities.remove(city);
        goldTotal--;
  }

    public void unHappy(){
        for (Unit unit : units){
            if (unit instanceof Ranged || unit instanceof Melee)
                unit.combatStrength -= unit.combatStrength*0.25;
        }
    }
    public void save(BaseCivilization civilization , User user) throws IOException {
        int n = 0;
        n = DataBase.numberOfUsers();
        String fileName = "user" + n + ".json";
        FileWriter writer = new FileWriter(fileName);
        writer.write(new Gson().toJson(civilization));
        writer.close();
        DataBase.setNumOfUsers();
    }
}
