package model.improvements;


import enums.ImprovementsEnum;
import model.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Improvement extends ImageView {
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
        this.setImage(new Image(Improvement.class.getResource("/ImprovementIcons/" + name + ".png").toExternalForm()));
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
        if (improvement.name.equals(ImprovementsEnum.FARM.toString()))
            if (tile.getTileType().equals("ice"))
                    return false;
            else return true;
        if (improvement.name.equals(ImprovementsEnum.MINE.toString()))
                if (tile.getTileType().equals("Hills")||tile.getTileType().equals("Resource"))
                    return false;
                else return true;
                return false;
    }
    public void farmImprovement(Tile tile){
        tile.goldOutput++;
        tile.foodOutput++;
    }
    public void miningImprovement(Tile tile){
        //TODO open accessibility of coal & al & ...
    }
    public void oo(){}
}
