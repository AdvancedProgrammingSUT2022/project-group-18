package model;

import model.unit.Unit;
import view.CityView;

import java.util.ArrayList;
import java.util.HashMap;

public class City {
    private Tile originTile;
    private String cityName;
    private int cityPopulation;
    private int cityFood;
    private int cityGold;
    private int cityProduction;
    private int cityScience;
    private int cityStrength;
    private User owner;
    private ArrayList<Citizen> unemployedCitizen;
    private HashMap<Tile, Citizen> citizenWorkers;
    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<Building> buildings = new ArrayList<>();
    private Unit unit;
    private CityView cityView = new CityView();

    public City() {
        this.unemployedCitizen = new ArrayList<>();
        this.citizenWorkers = new HashMap<>();
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

    public void setCityProduction(int cityProduction) {
        this.cityProduction = cityProduction;
    }

    public void setCityScience(int cityScience) {
        this.cityScience = cityScience;
    }

    public void setCityStrength(int cityStrength) {
        this.cityStrength = cityStrength;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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

    public int getCityScience() {
        return cityScience;
    }

    public int getCityStrength() {
        return cityStrength;
    }

    public User getOwner() {
        return owner;
    }

    public Unit getUnit() {
        return unit;
    }

    public ArrayList<Citizen> getUnemployedCitizen() {
        return unemployedCitizen;
    }

    public void lockCitizen(Citizen citizen){
        Tile tile = this.originTile;
        citizenWorkers.put(tile, citizen);
        tile.isUnderWork = true;
    }
    public void unemployedMenu(String choice){
        //TODO specialist choice
        if (this.unemployedCitizen.size()!=0){
            Citizen citizen = cityView.showUnemployed(this);
            unemployedCitizen.remove(citizen);
            lockCitizen(citizen);
        }else return;
    }
    public void unlockCitizen(Citizen citizen){
        unemployedCitizen.add(citizen);
        citizenWorkers.remove(this.originTile);
        this.originTile.isUnderWork=false;
    }
    public void buyTile(Tile tile){
        cityView.showCostOfTile(tile);
        tile.incraerseCost(10);//TODO check the amount
        this.cityGold-=10;
    }
    public void returnToMap(){
        return;
    }
    public void setBuildings(Building buildings) {
        this.buildings.add(buildings);
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }
}
