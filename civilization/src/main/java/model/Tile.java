package model;

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
}//TODO Tile
