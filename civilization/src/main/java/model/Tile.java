package model;

import com.google.gson.annotations.SerializedName;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import model.Resource.Resources;
import model.improvements.Improvement;
import model.unit.Unit;

import java.util.ArrayList;
import java.util.Objects;

public class Tile extends Polygon {

    private String tileType;
    public boolean isUnderWork = false;
    private float x, y, width, height;
    private City city;
    private ArrayList<Unit> units;
    private int cost;
    private Resources resources = null;
    public int goldOutput;
    public int foodOutput;
    private static ArrayList<Tile> tiles = new ArrayList<>();
    private static ArrayList<Improvement> improvements = new ArrayList<>();

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.tiles.add(this);
    }

    public ArrayList<Tile> getTiles() {
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

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
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
