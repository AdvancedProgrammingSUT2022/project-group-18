package model;

import enums.Message;
import model.Resource.Resources;
import model.unit.Civilian;
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
    private int cityBeakers;
    private int cityStrength;
    private BaseCivilization owner;
    private ArrayList<Civilian> unemployedCitizen;
    private HashMap<Tile, Civilian> citizenWorkers;
    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<Building> buildings = new ArrayList<>();
    private Unit militaryUnit;
    private Unit civilianUnit;
    private CityView cityView = new CityView();
    private boolean isCapital;
    private BaseCivilization Creator;
    private static ArrayList<Resources> resources = new ArrayList<>();


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

    public void setCityBeakers(int cityScience) {
        this.cityBeakers = cityScience;
    }

    public void setCityStrength(int cityStrength) {
        this.cityStrength = cityStrength;
    }

    public void setOwner(BaseCivilization owner) {
        this.owner = owner;
    }

    public boolean setMilitaryUnit(Unit militaryUnit){
        if (militaryUnit!=null){
            this.militaryUnit = militaryUnit;
            return true;
        }
        else return false;//transport unit to out of city
    }
    public boolean setCivilianUnit (Unit militaryUnit){
        if (civilianUnit!=null){
            this.civilianUnit = militaryUnit;
            return true;
        }
        else return false;//transport unit to out of city
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

    public User getOwner() {
        return owner;
    }

    public Unit getMilitaryUnit() {
        return militaryUnit;
    }

    public Unit getCivilianUnit() {
        return civilianUnit;
    }

    public ArrayList<Civilian> getUnemployedCitizen() {
        return unemployedCitizen;
    }

    public void lockCitizen(Civilian citizen){
        Tile tile = this.originTile;
        citizenWorkers.put(tile, citizen);
        tile.isUnderWork = true;
    }
    public void unemployedMenu(String choice){
        //TODO specialist choice
        if (this.unemployedCitizen.size()!=0){
            Civilian citizen = cityView.showUnemployed(this);
            unemployedCitizen.remove(citizen);
            lockCitizen(citizen);
        }else return;
    }
    public void unlockCitizen(Civilian citizen){
        unemployedCitizen.add(citizen);
        citizenWorkers.remove(this.originTile);
        this.originTile.isUnderWork=false;
    }
    public void buyTile(Tile tile){
        cityView.showCostOfTile(tile);
        tile.incraerseCost(10);//TODO check the amount
        this.cityGold-=10;
    }

    public void returnToMap(){return;}
    public void setBuildings(Building buildings) {
        this.buildings.add(buildings);
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public Tile getOriginTile() {
        return originTile;
    }

    public void workOnTile(){
        this.cityFood++;
        this.cityGold++;
        this.cityProduction++;
        this.cityBeakers++;
        //TODO set the proper amount
    }
    public void setSpecialist(){
        //TODO complete after completing buldings
    }

    public static void setResources(Resources resources) {
        City.resources.add(resources);
    }

    public static ArrayList<Resources> getResources() {
        return resources;
    }

    public void destroy(){
        if (Creator!=owner&&!isCapital){
            buildings.clear();
            cityProduction=0;
            cityGold=0;
            cityFood=0;
            citizenWorkers.clear();
            cityPopulation=0;
            unemployedCitizen.clear();
            citizenWorkers.clear();
            units.clear();
        }
    }
    public void appendixCity(BaseCivilization owner){
        this.owner = owner;
        owner.decreaseHappiness();
    }
    public void puppetCity(BaseCivilization owner){
        this.owner = owner;
        owner.increaseHappiness();
    }
}
