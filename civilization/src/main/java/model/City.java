package model;

import client.controller.CombatController;
import client.controller.GameController;
import enums.UnitEnum;
import model.Resource.Resources;

import model.unit.Unit;
import model.unit.Worker;
import client.view.CityView;
import client.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

public class City {
    private Tile originTile;
    private String cityName;
    private int cityPopulation;
    private int cityFood;
    private int cityGold;
    private int cityProduction;
    private int cityBeakers;
    private int cityStrength;
    private int happiness;
    private BaseCivilization owner;
    private Unit militaryUnit;
    private Unit civilianUnit;
    private CityView cityView = new CityView();
    private boolean isCapital;
    private BaseCivilization Creator;
    double x, y;
    public int hitPoints = 20;
    private HashMap<Tile, Worker> citizenWorkers;
    private ArrayList<Worker> unemployedCitizen;
    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<Building> buildings = new ArrayList<>();
    private ArrayList<Resources> resources = new ArrayList<>();
    public static ArrayList<City> allCities = new ArrayList<>();
    private ArrayList<Tile> cityTiles = new ArrayList<>();
    private String[] nameOfCities = {"Tehran" , "Mashhad" , "Qom" , "Tabriz"};
    private int cityNum = 0;


    public City(double x, double y) {
        this.cityName = nameOfCities[cityNum];
        cityNum++;
        this.x = x;
        this.y = y;
        this.unemployedCitizen = new ArrayList<>();
        this.citizenWorkers = new HashMap<>();
        allCities.add(this);
        View.setInCity(this);
        View.getCivilization().decreaseGold();
        View.getCivilization().decreaseHappiness();
    }

    public void addTileToCity(Tile tile) {
        cityTiles.add(tile);
    }

    public ArrayList<Tile> getCityTiles() {
        return cityTiles;
    }

    public void addBuilding(Building building) {
        this.buildings.add(building);
    }


    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setHappiness(int amount) {
        this.happiness = amount;
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public void setCityFood(int cityFood) {
        this.cityFood = cityFood;
    }

    public void setCityGold(int cityGold) {
        this.cityGold = cityGold;
    }

    public void increaseTurn(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        GameController.turn += amount;
    }

    public void increaseGold(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setCityGold(View.getInCity().getCityGold() + amount);
    }

    public void increaseHappiness(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setHappiness(View.getInCity().getHappiness() + amount);
    }

    public void increaseCityHP(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setCityHitPoint(View.getInCity().getCityHitPoint() + amount);
    }

    public void increaseFood(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setCityFood(View.getInCity().getCityFood() + amount);
    }

    public void increaseCityStrength(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setcityStrength(View.getInCity().getCityStrength() + amount);
    }
    public void increaseBeakers(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        View.getInCity().setCityBeakers(View.getInCity().getCityBeakers() + amount);
    }

    public void setCityProduction(int cityProduction) {
        this.cityProduction = cityProduction;
    }

    public void setCityBeakers(int cityScience) {
        this.cityBeakers = cityScience;
    }


    public void setCityStrength(int cityStrength) {
        this.cityStrength = cityStrength;
    }

    public void setOwner(BaseCivilization owner) {
        this.owner = owner;
    }

    public boolean setMilitaryUnit(Unit militaryUnit) {
        if (militaryUnit != null) {
            this.militaryUnit = militaryUnit;
            return true;
        } else return false;//transport unit to out of city
    }

    public boolean setCivilianUnit(Unit militaryUnit) {
        if (civilianUnit != null) {
            this.civilianUnit = militaryUnit;
            return true;
        } else return false;//transport unit to out of city
    }

    public void setcityStrength(int amount) {
        cityStrength = amount;
    }

    public void setCityHitPoint(int amount) {
        hitPoints = amount;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public int getCityFood() {
        return cityFood;
    }

    public int getCityGold() {
        return cityGold;
    }

    public int getCityProduction() {
        return cityProduction;
    }

    public int getCityBeakers() {
        return cityBeakers;
    }

    public int getCityStrength() {
        return cityStrength;
    }

    public BaseCivilization getOwner() {
        return owner;
    }

    public Unit getMilitaryUnit() {
        return militaryUnit;
    }

    public Unit getCivilianUnit() {
        return civilianUnit;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getcityStrength() {
        return cityStrength;
    }

    public int getCityHitPoint() {
        return hitPoints;
    }

    public ArrayList<Worker> getUnemployedCitizen() {
        return unemployedCitizen;
    }

    public void decreaseCityGold() {
        cityGold -= 10;
    }

    public void increasPopulation(BaseCivilization civilization) {
        cityPopulation += 10;
        civilization.decreaseHappiness();
    }

    public void lockCitizen(Worker citizen) {
        Tile tile = this.originTile;
        citizenWorkers.put(tile, citizen);
        tile.isUnderWork = true;
        cityFood += 5;
    }

    public void unemployedMenu(String choice) {
        //TODO specialist choice
        if (this.unemployedCitizen.size() != 0) {
            Worker citizen = cityView.showUnemployed(this);
            unemployedCitizen.remove(citizen);
            lockCitizen(citizen);
        } else return;
    }

    public void unlockCitizen(Worker citizen) {
        unemployedCitizen.add(citizen);
        citizenWorkers.remove(this.originTile);
        this.originTile.isUnderWork = false;
    }

    public void buyTile(Tile tile) {
        owner.decreaseGold();
        cityView.showCostOfTile(tile);
        tile.increaseCost(10);//TODO check the amount
        this.cityGold--;
    }

    public void returnToMap() {
        return;
    }


    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public Tile getOriginTile() {
        return originTile;
    }

    public void workOnTile() {
        this.cityFood++;
        this.cityGold++;
        this.cityProduction++;
        this.cityBeakers++;
        //TODO set the proper amount
    }

    public void setSpecialist() {
        //TODO complete after completing buldings
    }

    public void setResources(Resources resources) {
        this.resources.add(resources);
    }

    public ArrayList<Resources> getResources() {
        return resources;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void removeUnit(int index) {
        units.remove(index);
    }

    public void destroy() {
        if (Creator != owner && !isCapital) {
            buildings.clear();
            cityProduction = 0;
            cityGold = 0;
            cityFood = 0;
            citizenWorkers.clear();
            cityPopulation = 0;
            unemployedCitizen.clear();
            citizenWorkers.clear();
            units.clear();
        }
    }

    public void winCombat(BaseCivilization owner) {
        switch (cityView.afterWinInCombat()) {
            case 1:
                destroy();
            case 2:
                owner.increaseGold();
                appendixCity(owner);
            case 3:
                owner.increaseGold();
                puppetCity(owner);
        }
    }

    public void appendixCity(BaseCivilization owner) {
        this.owner = owner;
        owner.decreaseHappiness();
    }

    public void puppetCity(BaseCivilization owner) {
        this.owner = owner;
        owner.increaseHappiness();
    }

    public void addCityPopulation(int amount) {
        this.cityPopulation += amount;
    }

    public void addCityFood(int amount) {
        this.cityFood += amount;
    }

    public boolean haveEnoughFood() {
        if (this.cityFood < this.cityPopulation * 2) {
            return false;
        }
        return true;
    }

    public boolean canMakeANewCitizen() {
        if (cityFood > cityPopulation * 2 + 25)
            return true;
        return false;
    }

    public void nextTurn() {
        CombatController controller = new CombatController();
        if (!haveEnoughFood()) {
            int food = cityFood / 2;
            for (int i = 0; i < food; i++) {
                units.remove(units.size() - 1); // is it true?
            }
        } else {
            cityFood -= 2 * cityPopulation;
        }
        if (owner.getHappiness() < 0)
            View.getInCity().setCityFood((int) (cityFood * (0.33)));
        if (canMakeANewCitizen())
            UnitEnum.getUnits(UnitEnum.WORKER);
        controller.safeDeleteCity();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void decreaseHealth(int amount) {
        hitPoints -= amount;
    }

    public void unitPurchase(Unit unit) {
        units.add(unit);
        cityGold--;
    }


}
