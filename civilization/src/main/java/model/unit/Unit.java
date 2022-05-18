package model.unit;

import model.BaseCivilization;
import model.City;
import model.techs.Technology;
import model.unit.Settler;

import controller.Controller;
import controller.LoginMenuController;
import controller.unitactoins.Delete;
import model.BaseCivilization;
import model.City;
import view.View;

import java.io.File;
import java.util.ArrayList;

public class Unit {

    public static ArrayList<Unit> allUnits;
    //protected String combatType;
    public boolean sleepMode = false;
    public Settler City;
    public int target;
    public int tileId;
    public int curTileId;
    protected String name;
    protected int movement;
    protected int movementTemp;
    protected int movementPotential;
    public int combatStrength = 0;
    public int combatStrengthRanged = 0;
    protected int ranged = 1;
    public int health = 10;
    protected int productionCost = 0;
    protected boolean isMilitary = false;
    protected boolean isMoving = false;
    public boolean isAttacking = false;
    protected boolean hasTerrainCost = true;
    public int hitPoints = 10;
    protected float x, y;
    public boolean getCommand = true;


    public Unit(String name, int movement, int productionCost) {
        this.name = name;
        this.movement = movement;
        this.productionCost = productionCost;
        allUnits.add(this);
        View.getInCity().addCityPopulation(1);
    }

    public int getCombatStrength() {
        return combatStrength;
    }

    public void unitUpdate(Technology technology, City city) {
        //TODO upgrade units
        city.decreaseCityGold();
    }

    public String getName() {
        return name;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    public int getcombatStrengthRanged() {
        return combatStrengthRanged;
    }


    public int getHealth() {
        return health;
    }

    public boolean ableToMove() {
        return true;
    }

    public void decreaseMovement() {

    }


    public void checksSameLocstion() {

    }

    public void addToMapAndCiv() {
    }

    public void deleteFromMapAndCiv() {

    }

    public void deleteBySelling() {

    }

/*
    public Hex getPosition() {
        return curPos;
    }

    public boolean getSpawned() {
        return isSpawned;
    }
*/

    public boolean getIsMilitary() {
        return isMilitary;
    }

/*    public double getStrength() {
        return strength;
    }*/


    public double getTotalMovement() {
        return movement;
    }

    public double getMovementPotential() {
        return movementPotential;
    }

/*    public BaseCivilization getOwner() {
        return civOwner;
    }*/


    public int getProductionCost() {
        return productionCost;
    }

/*    public int getCurrentProduction() {
        return currentProduction;
    }

    public void addProductionToBuild(int productionToAdd) {
        currentProduction += productionToAdd;
    }*/

    public boolean isBeingMoved() {
        return isMoving;
    }

    public void toggleBeingMoved() {
        this.isMoving = !this.isMoving;
    }

    public void setBeingMoved(boolean moved) {
        this.isMoving = moved;
    }

    public boolean isBeingAttacked() {
        return isAttacking;
    }

    public void toggleBeingAttacked() {
        this.isMoving = !this.isMoving;
    }

    public void setBeingAttacked(boolean attack) {
        this.isMoving = attack;
    }



/*    public void setIsSpawned() {
        isSpawned = true;
    }


    public void setPosition(Hex h) {
        this.curPos = h;
    }*/

    public boolean ableToMove(double hexCost) {
        return ((movementTemp -= hexCost) >= 0D) && (movementPotential - hexCost >= 0D);
    }

    public void decreaseMovement(double hexCost) {
        this.movementPotential -= hexCost;
    }

    public void resetMovementTemp() {
        this.movementTemp = movement;
    }

    public void resetMovementPotential() {
        this.movementPotential = movement;
    }

    public void setMovementTempForMultiMove() {
        this.movementTemp =
                this.movementPotential != this.movement ? this.movementPotential : this.movement;
    }


    public void nextTurn() {
        Controller.turn++;
        resetMovementTemp();
        resetMovementPotential();
        LoginMenuController controller = new LoginMenuController();
        controller.printMap(Controller.turn);
        if (hitPoints == 0) {
            //TODO delete unit;
        }
    }

    public static void moveUnit() {
    }

    public void decreaseHealth(int amount) {
        this.hitPoints -= amount;
    }

    public int getHitPoints() {
        return hitPoints;
    }
    /* Hex toHex = hexMap.getHex(h);

            Unit cu = fromHex.getCivilianUnit();
            Unit mu = fromHex.getMilitaryUnit();

            Unit ctu = toHex.getCivilianUnit();
            Unit mtu = toHex.getMilitaryUnit();

            double pathTotal = 0.0D;
            for (PathHex ph : ui.getUnitPath()) {
                if (ph.getPassable() || ph.getCanSwitch()) {
                    pathTotal += hexMap.getHex(ph).getMovementTotal();
                }
            }


            if (cu != null && ctu == null && mu == null && mtu != null) {
                if (sameOwner(cu, mtu))
                    swapUnitOnMap(fromHex, toHex, cu, mtu, pathTotal);
            } else if (cu == null && ctu != null && mu != null && mtu == null) {
                if (sameOwner(mu, ctu))
                    swapUnitOnMap(fromHex, toHex, mu, ctu, pathTotal);
            } else if ((cu != null || mu != null) && ctu == null && mtu == null) {
                moveUnitOnMap(fromHex, toHex, cu != null ? cu : mu, pathTotal);
            }
            ui.setFocusedUnitPath(null);
        }*/


/*    private void moveUnitOnMap(Hex fromHex, Hex toHex, Unit u, double totalHexCost) {
        HexCoordinate newLocation = toHex.getPosition();
        u.decreaseMovement(totalHexCost);

        Unit tempUnit = u;
        tempUnit.setPosition(newLocation);

        fromHex.resetUnits();
        toHex.replaceUnit(u, tempUnit.getIsMilitary());


        hexMap.setHex(toHex);
        hexMap.setHex(fromHex);


        BaseCivilization c1 = civs.get(0);
        c1.replaceUnit(u, tempUnit);
        civs.set(0, c1);
    }

    private void swapUnitOnMap(Hex fromHex, Hex toHex, Unit currentFromUnit, Unit currentToUnit,
                               double totalHexCost) {
        fromHex.resetUnits();
        toHex.resetUnits();

        currentToUnit.decreaseMovement(totalHexCost);
        currentFromUnit.decreaseMovement(totalHexCost);

        Unit tempToUnit = currentToUnit;
        Unit tempFromUnit = currentFromUnit;
        HexCoordinate unitFrom = currentFromUnit.getPosition();
        HexCoordinate unitTo = currentToUnit.getPosition();

        tempToUnit.setPosition(unitFrom);
        tempFromUnit.setPosition(unitTo);

        fromHex.replaceUnit(tempToUnit, currentToUnit.getIsMilitary());
        toHex.replaceUnit(tempFromUnit, currentFromUnit.getIsMilitary());

        hexMap.setHex(toHex);
        hexMap.setHex(fromHex);


        BaseCivilization c1 = civs.get(0);
        c1.replaceUnit(currentFromUnit, tempFromUnit);
        c1.replaceUnit(currentToUnit, tempToUnit);
        civs.set(0, c1);
    }*/

/*    private boolean sameOwner(Unit fromU, Unit toU) {
        return fromU.getOwner().sameCivilization(toU.getOwner().getID());
    }*/

/*    public ArrayList<PathHex> validUnitMove(ArrayList<HexCoordinate> path) {
        ArrayList<PathHex> finalPath = new ArrayList<>();
        Hex currentHex = hexMap.getHex(ui.getFocusHex());

        boolean unitBlocking = false;
        double currentPathCost = 0D;
        for (int i = path.size(); --i >= 0;) {
            HexCoordinate h = path.get(i);
            Hex mapHex = hexMap.getHex(h);

            double hexCost = currentHex.getMovementTotal();
            boolean unitMovementRemaining = currentUnit.ableToMove(hexCost);
            boolean done = false;

            currentPathCost += hexCost;

            if (unitMovementRemaining) {
                if (!unitBlocking) {
                    for (Unit u : mapHex.getUnits()) {
                        if (u != null) {
                            boolean canSwitch = false;
                            if (u.getOwner() == currentUnit.getOwner() && u.ableToMove(currentPathCost)) {
                                canSwitch = true;
                            }
                            unitBlocking = true;
                            finalPath.add(new PathHex(h, !unitBlocking, canSwitch));
                            done = true;
                        }
                    }
                    if (!done) {
                        finalPath.add(new PathHex(h, true));
                    }
                } else {
                    finalPath.add(new PathHex(h, false));
                }
            } else {
                finalPath.add(new PathHex(h, false));
            }
        }
        currentUnit.setMovementTempForMultiMove();
        return finalPath;
    }*/

//package model.unit;
//
//import controller.CombatController;
//import controller.Controller;
//import controller.LoginMenuController;
//import controller.unitactoins.Delete;
//import enums.Message;
//import enums.UnitEnum;
//import model.BaseCivilization;
//import model.City;
//import view.View;
//
//
//public class Unit {
//
//    //protected String combatType;
//    public boolean sleepMode = false;
//    public Settler City;
//    public int target;
//    public int tileId;
//    public int curTileId;
//    protected String name;
//    protected int movement;
//    protected int movementTemp;
//    protected int movementPotential;
//    public int combatStrength = 0;
//    public int combatStrengthRanged = 0;
//    protected int ranged = 1;
//    //public int health = 10;
//    protected int productionCost = 0;
//    protected boolean isMilitary = false;
//    protected boolean isMoving = false;
//    public boolean isAttacking = false;
//    protected boolean hasTerrainCost = true;
//    public int hitPoints = 10;
//    protected float x, y;
//    public boolean getCommand = true;
//    private boolean strengths ;
//
//    public Unit(String name, int movement, int productionCost) {
//        this.name = name;
//        this.movement = movement;
//        this.productionCost = productionCost;
//        View.getInCity().addCityPopulation(1);
//    }
//
//    public static void attack(City city, Unit unit, BaseCivilization civilization) {
//        unit.isAttacking = true;
//        while (unit.hitPoints != 0 && city.hitPoints != 0) {
//            unit.hitPoints--;
//            city.hitPoints--;
//        }
//        if (unit.hitPoints == 0) civilization.deleteUnit(unit);
//        if (city.hitPoints == 0) city.destroy();
//    }
//
//    public static void farAttack(City city, Unit unit, BaseCivilization civilization) {
//        unit.hitPoints--;
//        city.hitPoints--;
//    }
//
//
//    public int getcombatStrength() {
//        return combatStrength;
//    }
//
//    public int getcombatStrengthRanged() {
//        return combatStrengthRanged;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//
//
//    public boolean ableToMove() {
//        return true;
//    }
//
//    public void decreaseMovement() {
//
//    }
//
//
//    public void moveUnit() {
//
//    }
//
//    public void checksSameLocstion() {
//
//    }
//
//    public void addToMapAndCiv() {
//    }
//
//    public void deleteFromMapAndCiv() {
//
//    }
//
//    public void deleteBySelling() {
//
//    }
//
//    public void setStrengths(boolean strengths) {
//        this.strengths = strengths;
//    }
//
//    public boolean getStrengths() {
//        return strengths;
//    }
//
//    public void increaseHitPoints(int hitPoints) {
//        this.hitPoints += hitPoints;
//    }
//
//    /*
//    public Hex getPosition() {
//        return curPos;
//    }
//
//    public boolean getSpawned() {
//        return isSpawned;
//    }
//*/
//
//    public boolean getIsMilitary() {
//        return isMilitary;
//    }
//
///*    public double getStrength() {
//        return strength;
//    }*/
//
//
//    public double getTotalMovement() {
//        return movement;
//    }
//
//    public double getMovementPotential() {
//        return movementPotential;
//    }
//
///*    public BaseCivilization getOwner() {
//        return civOwner;
//    }*/
//
//
//    public int getProductionCost() {
//        return productionCost;
//    }
//
///*    public int getCurrentProduction() {
//        return currentProduction;
//    }
//
//    public void addProductionToBuild(int productionToAdd) {
//        currentProduction += productionToAdd;
//    }*/
//
//    public boolean isBeingMoved() {
//        return isMoving;
//    }
//
//    public void toggleBeingMoved() {
//        this.isMoving = !this.isMoving;
//    }
//
//    public void setBeingMoved(boolean moved) {
//        this.isMoving = moved;
//    }
//
//    public boolean isBeingAttacked() {
//        return isAttacking;
//    }
//
//    public void toggleBeingAttacked() {
//        this.isMoving = !this.isMoving;
//    }
//
//    public void setBeingAttacked(boolean attack) {
//        this.isMoving = attack;
//    }
//
//
//
///*    public void setIsSpawned() {
//        isSpawned = true;
//    }
//
//
//    public void setPosition(Hex h) {
//        this.curPos = h;
//    }*/
//
//    public boolean ableToMove(double hexCost) {
//        return ((movementTemp -= hexCost) >= 0D) && (movementPotential - hexCost >= 0D);
//    }
//
//    public void decreaseMovement(double hexCost) {
//        this.movementPotential -= hexCost;
//    }
//
//    public void resetMovementTemp() {
//        this.movementTemp = movement;
//    }
//
//    public void resetMovementPotential() {
//        this.movementPotential = movement;
//    }
//
//    public void setMovementTempForMultiMove() {
//        this.movementTemp =
//                this.movementPotential != this.movement ? this.movementPotential : this.movement;
//    }
//
//    public int getHitPoints() {
//        return hitPoints;
//    }
//
//
//
//    public void decreaseHealth(int amount) {
//        hitPoints -= amount;
//    }
//
//    public void nextTurn() {
//        Controller.turn++;
//        resetMovementTemp();
//        resetMovementPotential();
//        LoginMenuController controller = new LoginMenuController();
//        controller.printMap(Controller.turn);
//        CombatController combatController = new CombatController();
//        combatController.safeDeleteUnits();
//    }
//
//
///*    public void moveUnit(Hex hh) {
//
//            Hex toHex = hexMap.getHex(h);
//
//            Unit cu = fromHex.getCivilianUnit();
//            Unit mu = fromHex.getMilitaryUnit();
//
//            Unit ctu = toHex.getCivilianUnit();
//            Unit mtu = toHex.getMilitaryUnit();
//
//            double pathTotal = 0.0D;
//            for (PathHex ph : ui.getUnitPath()) {
//                if (ph.getPassable() || ph.getCanSwitch()) {
//                    pathTotal += hexMap.getHex(ph).getMovementTotal();
//                }
//            }
//
//
//            if (cu != null && ctu == null && mu == null && mtu != null) {
//                if (sameOwner(cu, mtu))
//                    swapUnitOnMap(fromHex, toHex, cu, mtu, pathTotal);
//            } else if (cu == null && ctu != null && mu != null && mtu == null) {
//                if (sameOwner(mu, ctu))
//                    swapUnitOnMap(fromHex, toHex, mu, ctu, pathTotal);
//            } else if ((cu != null || mu != null) && ctu == null && mtu == null) {
//                moveUnitOnMap(fromHex, toHex, cu != null ? cu : mu, pathTotal);
//            }
//            ui.setFocusedUnitPath(null);
//        }*/
//
//
///*    private void moveUnitOnMap(Hex fromHex, Hex toHex, Unit u, double totalHexCost) {
//        HexCoordinate newLocation = toHex.getPosition();
//        u.decreaseMovement(totalHexCost);
//
//        Unit tempUnit = u;
//        tempUnit.setPosition(newLocation);
//
//        fromHex.resetUnits();
//        toHex.replaceUnit(u, tempUnit.getIsMilitary());
//
//
//        hexMap.setHex(toHex);
//        hexMap.setHex(fromHex);
//
//
//        BaseCivilization c1 = civs.get(0);
//        c1.replaceUnit(u, tempUnit);
//        civs.set(0, c1);
//    }
//
//    private void swapUnitOnMap(Hex fromHex, Hex toHex, Unit currentFromUnit, Unit currentToUnit,
//                               double totalHexCost) {
//        fromHex.resetUnits();
//        toHex.resetUnits();
//
//        currentToUnit.decreaseMovement(totalHexCost);
//        currentFromUnit.decreaseMovement(totalHexCost);
//
//        Unit tempToUnit = currentToUnit;
//        Unit tempFromUnit = currentFromUnit;
//        HexCoordinate unitFrom = currentFromUnit.getPosition();
//        HexCoordinate unitTo = currentToUnit.getPosition();
//
//        tempToUnit.setPosition(unitFrom);
//        tempFromUnit.setPosition(unitTo);
//
//        fromHex.replaceUnit(tempToUnit, currentToUnit.getIsMilitary());
//        toHex.replaceUnit(tempFromUnit, currentFromUnit.getIsMilitary());
//
//        hexMap.setHex(toHex);
//        hexMap.setHex(fromHex);
//
//
//        BaseCivilization c1 = civs.get(0);
//        c1.replaceUnit(currentFromUnit, tempFromUnit);
//        c1.replaceUnit(currentToUnit, tempToUnit);
//        civs.set(0, c1);
//    }*/
//
///*    private boolean sameOwner(Unit fromU, Unit toU) {
//        return fromU.getOwner().sameCivilization(toU.getOwner().getID());
//    }*/
//
///*    public ArrayList<PathHex> validUnitMove(ArrayList<HexCoordinate> path) {
//        ArrayList<PathHex> finalPath = new ArrayList<>();
//        Hex currentHex = hexMap.getHex(ui.getFocusHex());
//
//        boolean unitBlocking = false;
//        double currentPathCost = 0D;
//        for (int i = path.size(); --i >= 0;) {
//            HexCoordinate h = path.get(i);
//            Hex mapHex = hexMap.getHex(h);
//
//            double hexCost = currentHex.getMovementTotal();
//            boolean unitMovementRemaining = currentUnit.ableToMove(hexCost);
//            boolean done = false;
//
//            currentPathCost += hexCost;
//
//            if (unitMovementRemaining) {
//                if (!unitBlocking) {
//                    for (Unit u : mapHex.getUnits()) {
//                        if (u != null) {
//                            boolean canSwitch = false;
//                            if (u.getOwner() == currentUnit.getOwner() && u.ableToMove(currentPathCost)) {
//                                canSwitch = true;
//                            }
//                            unitBlocking = true;
//                            finalPath.add(new PathHex(h, !unitBlocking, canSwitch));
//                            done = true;
//                        }
//                    }
//                    if (!done) {
//                        finalPath.add(new PathHex(h, true));
//                    }
//                } else {
//                    finalPath.add(new PathHex(h, false));
//                }
//            } else {
//                finalPath.add(new PathHex(h, false));
//            }
//        }
//        currentUnit.setMovementTempForMultiMove();
//        return finalPath;
//    }*/
//
//>>>>>>> origin
//}
}