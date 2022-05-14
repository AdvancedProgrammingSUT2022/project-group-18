package controller;

import enums.Message;
import enums.UnitEnum;
import model.BaseCivilization;
import model.City;
import model.Tile;
<<<<<<< HEAD
import view.View;

import java.util.regex.Matcher;
=======
import model.unit.Unit;
>>>>>>> d79b208b91c85a4a00bdf9052493a78527d11933


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