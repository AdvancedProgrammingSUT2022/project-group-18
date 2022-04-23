package model.Resource;

import java.util.ArrayList;

public class Resources {
    private String name;
    private Integer food;
    private Integer production;
    private Integer gold;
    private ArrayList<String> canBeFound = new ArrayList<>();
    private String improvementNeeded;
    private String type;

    public Resources(String name, Integer food, Integer production, Integer gold, String canBeFound, String improvementNeeded, String type) {
        this.name = name;
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.canBeFound.add(canBeFound);
        this.improvementNeeded = improvementNeeded;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getFood() {
        return food;
    }

    public void setProduction(Integer production) {
        this.production = production;
    }

    public Integer getProduction() {
        return production;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getGold() {
        return gold;
    }

    public void setCanBeFound(ArrayList<String> canBeFound) {
        this.canBeFound = canBeFound;
    }

    public ArrayList<String> getCanBeFound() {
        return canBeFound;
    }

    public void setImprovementNeeded(String improvementNeeded) {
        this.improvementNeeded = improvementNeeded;
    }

    public String getImprovementNeeded() {
        return improvementNeeded;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
