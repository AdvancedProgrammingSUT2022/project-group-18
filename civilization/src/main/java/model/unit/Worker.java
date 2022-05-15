package model.unit;
import model.Tile;
import model.hex;
public class Worker extends  Unit{
    public Worker(String name, int movement, int productionCost) {
        this.name = name;
        this.movement = movement;
        this.movementTemp = movement;
        this.movementPotential = movement;
        this.productionCost = productionCost;
    }


    public static void foundRoad(int tile,hex map) {
        if((hex.randLand[tile]!=3 )&&(hex.randLand[tile]!= 5 ) &&(hex.randLand[tile]!=6)){
            //creat road
            //graphic

        }


    }
    public void foundRailway(int tileId,hex map,Tile tile) {
        if ((map.randLand[tileId] != 3) && (map.randLand[tileId] != 5) && (map.randLand[tileId] != 6)) {
            //creat railway
            //graphic
        }
    }
        public void foundFarm(int tileId,hex map,Tile tile){
            //creat railway
            //graphic
        }


    public void foundMine(int tileId,hex map,Tile tile) {
      //creat railway
        //graphic
    }
    public void foundTradingPost(int tileId,hex map,Tile tile) {
        //creat railway
        //graphic
        tile.incraerseGold(1);

    }
    public void foundWoodCuting(int tileId,hex map,Tile tile) {
        //creat railway
        //graphic
    }
    public void foundPasture(int tileId,hex map,Tile tile) {
        //creat railway
        //graphic

    }
    public void foundCamp(int tileId,hex map,Tile tile) {
        //creat railway
        //graphic

    }
    public void foundPlantation(int tileId,hex map,Tile tile) {
        //creat railway
        //graphic

    }
    public void foundQuarry(int tileId,hex map,Tile tile) {
        //creat railway
        //graphic

    }
    public void deleteJungle(int tileId,hex map,Tile tile) {
        if(map.randFeature[tile]==5){
            map.randFeature[tile]=7;
        }

    }
    public void deleteForest(int tileId,hex map,Tile tile) {
        if (map.randFeature[tileId] == 4) {
            map.randFeature[tileId] = 7;

        }
    }
    public void deleteMarsh(int tileId,hex map,Tile tile) {
            if(map.randFeature[tileId]==2){
                map.randFeature[tileId]=7;
        }

    }
    public void deleteRoad(int tileId,hex map,Tile tile) {
        if (map.randFeature[tileId] == 6) {
            map.randFeature[tileId] = 7;

        }
    }
    public void repair(int tileId,hex map,Tile tile) {

        }

    }
}
