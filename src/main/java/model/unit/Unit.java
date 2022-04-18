package model.unit;

public class Unit extends Units{


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





//    public boolean isSettler() {
//        return this instanceof Settler;
//    }

//    public boolean isWarrior() {
//        return this instanceof Warrior;
//    }


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
