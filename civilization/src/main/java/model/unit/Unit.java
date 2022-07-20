package model.unit;

import controller.GameController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.City;

import model.Tile;
import model.techs.Technology;
import view.LoginMenuController;
import view.View;

import java.util.ArrayList;

public class Unit extends ImageView {

    public static ArrayList<Unit> allUnits = new ArrayList<>();
    public boolean sleepMode = false;
    public Settler City;
    public int target;
    public int tileId;
    public int curTileId;
    protected String name;
    protected int movement;
    protected int movementTemp;
    protected int movementPotential;
    public int combatStrength = 2;
    public int combatStrengthRanged = 0;
    protected int ranged = 1;
    public int health = 10;
    protected int productionCost = 0;
    protected boolean isMilitary = false;
    protected boolean isMoving = false;
    public boolean isAttacking = false;
    protected boolean hasTerrainCost = true;
    public int hitPoints = 10;
    protected double x, y;
    public boolean getCommand = true;
    private Tile unitTile;


    public Unit(String name, int movement, int productionCost, City city) {
        this.name = name;
        this.movement = movement;
        this.productionCost = productionCost;
        allUnits.add(this);
        View.getInCity().addCityPopulation(1);
        View.getInCity().addUnit(this);
        this.setImage(new Image(Unit.class.getResource("/assest/Units/" + name + ".png").toExternalForm()));

        this.setFitHeight(100);
        this.setFitWidth(100);
        this.setX(View.getInCity().getX() - 50);
        this.setY(View.getInCity().getY() - 50);
        unitTile = Tile.getTileFromCoordinate(this.getX(), this.getY());
        System.out.println(unitTile.getX());

    }

    public int distance(double x, double y) {
        double one = (Math.sqrt(Math.pow((this.getUnitTile().getX() - x), 2) + Math.pow((this.getUnitTile().getY() - y), 2)));
        return (int) ((one / 160) + 0.5);
    }

    public void setUnitTile(Tile unitTile) {
        this.unitTile = unitTile;
    }

    public Tile getUnitTile() {
        return unitTile;
    }

    public void move(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public void minesMovement(int move) {
        this.movement -= move;
    }

    public int getProductionCost() {
        return productionCost;
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


    public int getMovement() {
        return movement;
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
        GameController.turn++;
        resetMovementTemp();
        resetMovementPotential();
        LoginMenuController controller = new LoginMenuController();
        //controller.printMap(Controller.turn);
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


}