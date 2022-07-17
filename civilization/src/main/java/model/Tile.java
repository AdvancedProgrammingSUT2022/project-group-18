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

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Resources getResources() {
        return resources;
    }

    public void incraerseGoldOutput(int amount) {
        goldOutput += amount;
    }

    public void setCoordinates(double x , double y){
        this.getPoints().addAll(new Double[]{
                x, y-90,
                x+80, y-45,
                x+80, y+45,
                x, y+90,
                x-80, y+45,
                x-80, y-45,
        });
    }

    public void setImage(String name){
        String[] in = name.split("_");
        this.setTileType(in[0]);
        Image image = new Image(Objects.requireNonNull(getClass().getResource("/polygon/"+name+".png")).toExternalForm());
        this.setFill(new ImagePattern(image));
    }
}
