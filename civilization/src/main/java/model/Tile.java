package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import model.Resource.Resources;
import model.improvements.Improvement;
import model.unit.Unit;

import java.util.ArrayList;
import java.util.Objects;

public class Tile extends Polygon {

    public int prodution;
    private String tileType;
    public boolean isUnderWork = false;
    private float x, y;
    private City city;
    private ArrayList<Unit> units;
    public int cost , cm;
    private Resources resources = null;
    public int goldOutput;
    public int foodOutput;
    private static ArrayList<Tile> tiles = new ArrayList<>();
    private static ArrayList<Improvement> improvements = new ArrayList<>();

    public Tile(int x, int y, String tileType) {
        this.x = x;
        this.y = y;
        this.tileType = tileType;
        tiles.add(this);
//        String[] name = {"dasht", "grass", "grass", "grass", "grass", "grass", "grass", "grass", "kavir", "kooh", "ocean", "sand", "sand"
//                , "sand", "grass", "snow", "tappe", "tappe", "tondra"};
        switch (tileType){
            case "kavir":
            case "snow":
                this.goldOutput=0;
                this.prodution=0;
                this.foodOutput=0;
                this.cost=1;
                this.cm =-33;
                break;
            case "grass":
                this.goldOutput=0;
                this.foodOutput=2;
                this.prodution=0;
                this.cost=1;
                this.cm =-33;
                break;
            case "tappe":
                this.goldOutput=0;
                this.foodOutput=0;
                this.prodution=2;
                this.cost=2;
                this.cm =+25;
                break;
            case "kooh":
            case "ocean":
                this.goldOutput=0;
                this.foodOutput=0;
                this.prodution=0;
                this.cost=100;
                this.cm =0;
                break;
            case "dasht":
                this.goldOutput=0;
                this.foodOutput=1;
                this.prodution=1;
                this.cost=1;
                this.cm =-33;
                break;
            case "tondra":
                this.goldOutput=0;
                this.foodOutput=1;
                this.prodution=0;
                this.cost=1;
                this.cm =-33;
                break;
        }
    }

    public static ArrayList<Tile> getTiles() {
        return tiles;
    }

    public static void setImprovements(Improvement improvements) {
        Tile.improvements.add(improvements);
    }

    public static ArrayList<Improvement> getImprovements() {
        return improvements;
    }

    public String getTileType() {
        return tileType;
    }

    public void setTileType(String tileType) {
        this.tileType = tileType;
    }

    public int getCost() {
        return cost;
    }

    public void increaseCost(int amount) {
        cost += amount;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Resources getResources() {
        return resources;
    }

    public void increaseGoldOutput(int amount) {
        goldOutput += amount;
    }

    public void setCoordinates(double x , double y){
        this.getPoints().addAll(x, y-90,
                x+80, y-45,
                x+80, y+45,
                x, y+90,
                x-80, y+45,
                x-80, y-45);
    }

    public void setImage(String name){
        String[] in = name.split("_");
        this.setTileType(in[0]);
        Image image = new Image(Objects.requireNonNull(getClass().getResource("/polygon/"+name+".png")).toExternalForm());
        this.setFill(new ImagePattern(image));
    }

    public static Tile getTileFromCoordinate(double x, double y) {
        int n = 0;
        GFG.Point p = new GFG.Point((int) x,(int) y);

        for (Tile tile : tiles) {
            GFG.Point polygon[] = {new GFG.Point((int) tile.getX(), (int) tile.getY() -90),
                    new GFG.Point((int) tile.getX() + 80 , (int) tile.getY() - 45),
                    new GFG.Point((int) tile.getX() + 80 , (int) tile.getY() + 45),
                    new GFG.Point((int) tile.getX(), (int) tile.getY() + 90),
                    new GFG.Point((int) tile.getX() -80, (int) tile.getY() + 45),
                    new GFG.Point((int) tile.getX() - 80, (int) tile.getY() - 45)};
            n = polygon.length;
            if(GFG.isInside(polygon, n, p))
                return tile;


        }
        return null;
    }



}
