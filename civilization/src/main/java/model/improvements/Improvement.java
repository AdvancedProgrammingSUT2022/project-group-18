package model;


public class Improvement {
    private String name;
    private int food;
    private int production;
    private int gold;


    public Improvement(String name, int food, int production, int gold) {
        this.name = name;
        this.food = food;
        this.production = production;
        this.gold = gold;
        Tile.setImprovements(this);
    }

    public String getName() {return name;}

    public int getFood() {
        return this.food;
    }

    public int getProduction() {
        return this.production;
    }

    public int getGold() {
        return this.gold;
    }
}
