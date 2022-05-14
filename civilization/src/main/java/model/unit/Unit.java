package Model.unit;

import model.BaseCivilization;
import model.City;

public class Unit {

    //protected String combatType;
    public boolean sleepmood=false;
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
    protected int productionCost=0;
    protected boolean isMilitary = false;
    protected boolean isMoving = false;
    public boolean isAttacking = false;
    protected boolean hasTerrainCost = true;
<<<<<<< HEAD
    
=======
<<<<<<< HEAD
    public int hitPoints = 10;
    protected float x , y;
=======
   public boolean getCommand=true;
>>>>>>> d79b208b91c85a4a00bdf9052493a78527d11933

>>>>>>> origin

    public static void attack(City city, Unit unit, BaseCivilization civilization){
        unit.isAttacking = true;
        while (unit.hitPoints!=0&&city.hitPoints!=0){
            unit.hitPoints--;
            city.hitPoints--;
        }
        if(unit.hitPoints==0) civilization.deleteUnit(unit);
        if (city.hitPoints==0) city.destroy();
    }

<<<<<<< HEAD
    public static void farAttack(City city, Unit unit, BaseCivilization civilization){
        unit.hitPoints--;
        city.hitPoints--;
    }
/*
=======
>>>>>>> origin
    public boolean getIsMilitary() {
        return isMilitary;
    }

    public int getcombatStrength() {
        return combatStrength;
    }

    public int getcombatStrengthRanged(){
        return combatStrengthRanged;
    }

    public String getName() {
        return name;
    }


    public int getHealth() {
        return health;
    }


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

    }

    public boolean ableToMove() {
        return true;
    }

    public void decreaseMovement() {

    }

    public void resetMovementTemp() {

    }

    public void resetMovementPotential() {

    }

    public void setMovementTempForMultiMove() {

    }

    public void nextTurn() {

    }

    public void moveUnit() {

    }
    public void checksSameLocstion(){

    }
    public void addToMapAndCiv() {
    }

    public void deleteFromMapAndCiv() {

    }

    public void deleteBySelling() {

    }

    public Hex getPosition() {
        return curPos;
    }

    public boolean getSpawned() {
        return isSpawned;
    }

    public boolean getIsMilitary() {
        return isMilitary;
    }

    public double getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }


    public double getTotalMovement() {
        return movement;
    }

    public double getMovementPotential() {
        return movementPotential;
    }

    public BaseCivilization getOwner() {
        return civOwner;
    }

    public int getHealth() {
        return health;
    }


    public int getProductionCost() {
        return productionCost;
    }

    public int getCurrentProduction() {
        return currentProduction;
    }

    public void addProductionToBuild(int productionToAdd) {
        currentProduction += productionToAdd;
    }

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


        return this.actionMenu;
    }

    public void setIsSpawned() {
        isSpawned = true;
    }


    public void setPosition(Hex h) {
        this.curPos = h;
    }

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

        resetMovementTemp();
        resetMovementPotential();
    }

    public void moveUnit(Hex hh) {

            Hex toHex = hexMap.getHex(h);

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
        }
    }

    private void moveUnitOnMap(Hex fromHex, Hex toHex, Unit u, double totalHexCost) {
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
    }

    private boolean sameOwner(Unit fromU, Unit toU) {
        return fromU.getOwner().sameCivilization(toU.getOwner().getID());
    }

    public List<PathHex> validUnitMove(List<HexCoordinate> path) {
        List<PathHex> finalPath = new ArrayList<>();
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
    }





}
