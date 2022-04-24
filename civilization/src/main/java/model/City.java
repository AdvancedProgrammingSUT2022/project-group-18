package model;

import model.unit.Unit;

import java.util.ArrayList;

public class City {
    private String cityName;
    private int cityPopulation;
    private int cityFood;
    private int cityGold;
    private int cityProduction;
    private int cityScience;
    private int cityStrength;
    private User owner;
    private ArrayList<Unit> units = new ArrayList<>();
    private Unit unit;

    public City() {}



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
}
