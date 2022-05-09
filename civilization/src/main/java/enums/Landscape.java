package enums;

import model.trrain.Terrain;

public enum Landscape {

	DESERT (new Terrain(0, 0,-0.33,0, 1,true), "Desert"),
	GRASSLAND (new Terrain(2, 0, -0.33, 0,1,true), "Grassland"),
	HILLS (new Terrain(0, 2, -0.33, 0,2,true), "Hills"),
	OCEAN (new Terrain(0, 0, 0.25, 0,0,false), "Ocean"),
	PLAINS (new Terrain(1, 1, -0.33, 0,1,true),  "Plains"),
	TUNDRA (new Terrain(1, 0, -0.33, 0,1,false),  "Tundra"),
	MOUNTAIN (new Terrain(0, 0,0.25,0, 0,false), "Mountain"),
	SNOW (new Terrain(0, 0, -0.33, 0,1,true), "Snow");

	private final Terrain y;

	private final String name;
	
	Landscape(Terrain y, String name) {
		this.y = y;

		this.name = name;
	}
	
	public int getFoodYield() {
		return this.y.getFood();
	}
	public int getProductionYield() {
		return this.y.getProduction();		
	}
	public int getGoldYield() {
		return this.y.getGold();		
	}
	public String getName() {
		return this.name;
	}
}
