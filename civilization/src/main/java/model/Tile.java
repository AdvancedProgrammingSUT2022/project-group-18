package model;

import com.google.gson.annotations.SerializedName;
import javafx.scene.shape.Polygon;
import model.Resource.Resources;
import model.improvements.Improvement;
import model.unit.Unit;

import java.util.ArrayList;

public class Tile extends Polygon {
    @SerializedName("tileType")
    private String tileType;
    @SerializedName("isUnderWork")
    public boolean isUnderWork = false;
    @SerializedName("coordinate")
    private float x, y, width, height;
    @SerializedName("city")
    private City city;
    @SerializedName("units")
    private ArrayList<Unit> units;
    @SerializedName("cost")
    private int cost;
    @SerializedName("resources")
    private Resources resources = null;
    @SerializedName("goldOutput")
    public int goldOutput;
    @SerializedName("foodOutput")
    public int foodOutput;
    @SerializedName("improvments")
    private static ArrayList<Improvement> improvements = new ArrayList<>();

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

    public void incraerseCost(int amount) {
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

    public void incraerseGoldOutput(int amount) {
        goldOutput += amount;
    }
}
