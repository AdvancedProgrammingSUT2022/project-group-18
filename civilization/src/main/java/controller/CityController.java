package controller;

import enums.UnitEnum;
import model.City;
import model.Tile;

public class CityController extends Controller{

    public void backToMainMap(){}
    public void changeMaking(){

    }
    public void makeUnits(UnitEnum unit){
        UnitEnum.getUnits(unit);
    }
    public void makeBuildings(){
        //TODO get building's name and build it
        //city.setBuilding;
    }
    public void citizenToDo(City city, Tile tile, String choice){
        if( tile.getX() <= city.getOriginTile().getX() + 2)
            city.unemployedMenu(choice);//90% it is not true
    }
    public void ImprovementPlace(){}
    public void AppointSpecialists (City city) {
       // city.unlockCitizen();

    }
    public void effectsOfAppointSpecialists() {}
    public void attackingCity() {}
    public void attackingWithMelee() {}
    public void DestroyCity() {}
    public void appendixCity() {}
    public void dependingCity() {}

}