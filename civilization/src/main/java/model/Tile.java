package model;

import model.City;
import model.unit.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;


public class Tile {
	private String tileType;
	public boolean isUnderWork = false;
	private float x, y, width, height;
	private City city;
	private ArrayList<Unit> units;
	private int cost;
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
}//TODO Tile