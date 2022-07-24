package client.view;

import client.model.City;
import client.model.Tile;
import client.model.unit.Worker;

import java.util.ArrayList;

public class CityView {
    public Worker showUnemployed(City city){
        ArrayList<Worker> unemployeds = city.getUnemployedCitizen();
        System.out.println(unemployeds);
        //TODO get citizen number by click & enter here
        Worker citizen = unemployeds.get(2);//fix it
        return citizen;
    }
    public static void show(City city){
        System.out.println(city.getCityFood()+
                city.getCityProduction()+
                city.getCityGold()+
                city.getCityBeakers());
//TODO + show the num of turns that cost to increase boundry & population
    }
    public void showCostOfTile(Tile tile){
        System.out.println(tile.getCost());
    }
    public void showBuildingDetails(){}
    public void showProductionMenu(){
        //System.out.println(Item + neededTurns);
        //TODO complete after completing buildings
    }
    public void purchaceMenu(){
        //System.out.println(Items);
        //TODO complete after completing buildings
    }
    public void buildMenu(){
        //TODO complete after completing buildings
    }
    public int afterWinInCombat(){
        System.out.println("enter 1 to destroy city");
        System.out.println("enter 2 to appendix city");
        System.out.println("enter 3 to puupet city");
        return Integer.parseInt(View.getInput());
    }


}
