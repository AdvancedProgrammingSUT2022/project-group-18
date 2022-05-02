package model;

import enums.TechsEnum;

public class Improvement {
    private int food;
    private int production;
    private int gold;


    public Improvement(int food, int production, int gold) {
        this.food = food;
        this.production = production;
        this.gold = gold;
        Tile.setImprovements(this);
    }

    public Improvement newCamp() {
        if (TechsEnum.technologyCheck(TechsEnum.TRAPPING))
            return new Improvement(0, 0, 0);
        return null;
    }

    public Improvement newFarm() {
        if (TechsEnum.technologyCheck(TechsEnum.AGRI_CULTURE))
            return new Improvement(1, 0, 0);
        return null;
    }

    public Improvement newLumberMill() {
        if (TechsEnum.technologyCheck(TechsEnum.CONSTRUCTION))
            return new Improvement(0, 1, 0);
        return null;
    }

    public Improvement newMine() {
        if (TechsEnum.technologyCheck(TechsEnum.MINING))
            new Improvement(0, 1, 0);
        return null;
    }

    public Improvement newPasture() {
        if (TechsEnum.technologyCheck(TechsEnum.ANIMAL_HUSBANDRY))
            new Improvement(0, 0, 0);
        return null;
    }

    public Improvement newWorkandFarm() {
        if (TechsEnum.technologyCheck(TechsEnum.CALENDAR))
            new Improvement(0, 0, 0);
        return null;
    }

    public Improvement newStoneMine() {
        if (TechsEnum.technologyCheck(TechsEnum.MASONRY))
            new Improvement(0, 0, 0);
        return null;
    }

    public Improvement newTradingPost() {
        if (TechsEnum.technologyCheck(TechsEnum.TRAPPING))
            new Improvement(0, 0, 1);
        return null;
    }

    public Improvement newFactory() {
        if (TechsEnum.technologyCheck(TechsEnum.ENGINEERING))
            new Improvement(0, 2, 0);
        return null;
    }


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
