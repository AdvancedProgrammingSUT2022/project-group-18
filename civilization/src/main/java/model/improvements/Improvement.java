package model.improvements;


import model.Tile;
import model.unit.Civilian;

public class Improvement {
    private String name;
    private int food;
    private int production;
    private int gold;
    private int turnRequired;


    public Improvement(String name, int food, int production, int gold) {
        this.name = name;
        this.food = food;
        this.production = production;
        this.gold = gold;
        
        Tile.setImprovements(this);
    }

    public String getName() {return name;}

    public int getFood() {
        return food;
    }

    public int getProduction() {
        return production;
    }

    public int getGold() {
        return gold;
    }

    public boolean canMakeImprovementHere(Tile tile){
        if(tile.getResources()!=null) return false;
        return true;
    }

    public int getTurnRequired(Tile tile){
      int turn;  //TODO after turns tileType to farm should disappear
        switch (tile.getTileType()){
            case "Forest":
                turn = 10;
                return turn;
            case "Jungle":
                turn = 13;
                return turn;
            case "Marsh":
                turn = 12;
                return turn;
            default: return 0;
        }
    }

    public boolean canMakeImprovementHere(Improvement improvement , Tile tile){
        switch (improvement.name){
            case ImprovementsEnum.FARM:
                if (tile.getTileType().equals("ice"))
                    return false;
                else return true;
            case ImprovementsEnum.MINE:
                if (tile.getTileType().equals("Hills")||tile.getTileType().equals("Resource"))
                    return false;
                else return true;
            default: return false;
        }
    }
    public void farmImprovement(Tile tile){
        tile.goldOutput++;
        tile.foodOutput++;
    }
    public void miningImprovement(Tile tile){
        //TODO open accesibelity of coal & al & ...
    }
    public void 
}
