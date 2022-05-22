package model;

import model.Resource.Resources;
import model.improvements.Improvement;
import model.unit.Unit;

import java.util.ArrayList;


public class Tile {
	private String tileType;
	public boolean isUnderWork = false;
	private float x, y, width, height;
	private City city;
	private ArrayList<Unit> units;
	private int cost;
	private Resources resources = null;
	public int goldOutput;
	public int foodOutput;
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
	public void incraerseCost(int amount){
		cost+=amount;
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

	public void setResources(Resources resources){this.resources = resources;}
	public Resources getResources(){return resources;}

	public void incraerseGoldOutput(int amount) {
		goldOutput+=amount;
	}
}
