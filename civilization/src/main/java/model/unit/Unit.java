package model.unit;

public class Unit {

    //protected String combatType;
    protected String name;
    protected int movement;
    //    protected int movementTemp;
//    protected int movementPotential;
    protected int combatStrength = 0;
    protected int combatStrengthRanged = 0;
    protected int ranged = 1;
    protected int health = 10;
    protected int productionCost=0;
    protected boolean isMilitary = false;
    protected boolean isMoving = false;
    protected boolean isAttacking = false;
    protected boolean hasTerrainCost = true;



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


}
