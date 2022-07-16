package model.unit;

import model.Tile;
import model.hex;

public class Worker extends Unit {
    public Worker(String name, int movement, int productionCost) {
        super(name, movement, productionCost);

    }


    public static boolean foundRoad(int tile, hex map) {
        if ((hex.randLand[tile] != 3) && (hex.randLand[tile] != 5) && (hex.randLand[tile] != 6)) {
            //creat road
            int s = hex.randLand[2];
            //graphic
            return true;

        } else
            return false;

    }

    public static boolean foundRailway(int tileId, hex map, Tile tile) {
        if ((map.randLand[tileId] != 3) && (map.randLand[tileId] != 5) && (map.randLand[tileId] != 6)) {

            //creat railway
            //graphic
            return true;
        } else
            return false;
    }

    public static void foundFarm(int tileId, hex map, Tile tile) {
        //creat railway
        //graphic
    }


    public static void foundMine(int tileId, hex map, Tile tile) {
        //creat railway
        //graphic
    }

    public static void foundTradingPost(int tileId, hex map, Tile tile) {
        //creat railway
        //graphic
        tile.increaseGoldOutput(1);


    }

    public static void foundWoodCuting(int tileId, hex map, Tile tile) {
        //creat railway
        //graphic
    }

    public static void foundPasture(int tileId, hex map, Tile tile) {
        //creat railway
        //graphic

    }

    public static void foundCamp(int tileId, hex map, Tile tile) {
        //creat railway
        //graphic

    }

    public static void foundPlantation(int tileId, hex map, Tile tile) {
        //creat railway
        //graphic

    }

    public static void foundQuarry(int tileId, hex map, Tile tile) {
        //creat railway
        //graphic

    }

    public static void deleteJungle(int tileId, hex map, int tile) {
        if (hex.randFeature[tile] == 5) {
            hex.randFeature[tile] = 7;
        }

    }

    public static boolean deleteForest(int tileId, hex map, Tile tile) {
        if (hex.randFeature[tileId] == 4) {
            hex.randFeature[tileId] = 7;
            return true;
        } else
            return false;
    }

    public static void deleteMarsh(int tileId, hex map, Tile tile) {
        if (hex.randFeature[tileId] == 2) {
            hex.randFeature[tileId] = 7;
        }

    }

    public static boolean deleteRoad(int tileId, hex map, Tile tile) {
        if (hex.randFeature[tileId] == 6) {
            hex.randFeature[tileId] = 7;
            return true;

        } else
            return false;
    }

    public static void repair(int tileId, hex map, Tile tile) {

    }

}

