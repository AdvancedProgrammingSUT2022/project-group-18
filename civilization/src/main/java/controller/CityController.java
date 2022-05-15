package controller;

import enums.Message;
import enums.UnitEnum;
import model.BaseCivilization;

import view.View;

import java.util.regex.Matcher;


public class CityController extends Controller{

    public void backToMainMap(){}
    public void changeConstruction(Matcher matcher){
        String unitName = matcher.group("unitName");
        int size = View.getInCity().getUnits().size();
        View.getInCity().removeUnit(size - 1);
        UnitEnum.getUnits(UnitEnum.findUnitEnumByName(unitName));
    }
    public void makeUnits(Matcher matcher){
        String unitName = matcher.group("unitName");
        UnitEnum.getUnits(UnitEnum.findUnitEnumByName(unitName));
        BaseCivilization.notifications.add(Message.MAKE_UNIT.toString());
    }
    public void makeBuildings(){
        //TODO get building's name and build it
        //city.setBuilding;
    }



}