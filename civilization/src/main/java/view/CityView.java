package view;

import model.City;
import model.Tile;
import model.unit.Civilian;

import java.util.ArrayList;

public class CityView {
    public Civilian showUnemployed(City city){
        ArrayList<Civilian> unemployeds = city.getUnemployedCitizen();
        System.out.println(unemployeds);
        //TODO get citizen number by click & enter here
        Civilian citizen = unemployeds.get(2);//fix it
        return citizen;
    }
    public void show(City city){
        System.out.println(city.getCityFood()+
                city.getCityProduction()+
                city.getCityGold()+
                city.getCityScience());
//TODO + show the num of turns that cost to increase boundry & population
    }
    public void showCostOfTile(Tile tile){
        System.out.println(tile.getCost());
    }
    public void showBuldingDetails(){}
    public void showProductionMenu(){
        //System.out.println(Item + neededTurns);
        //TODO complete after completing buldings
    }
    public void purchaceMenu(){
        //System.out.println(Items);
        //TODO complete after completing buldings
    }
    public void buildMenu(){
        //TODO complete after completing buldings
    }

}
