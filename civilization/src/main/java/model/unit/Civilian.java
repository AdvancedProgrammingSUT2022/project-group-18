package model.unit;
public class Civilian extends Unit {
    public Civilian(String name, int movement, int productionCost) {
        this.name = name;
        this.movement = movement;
        this.movementTemp = movement;
        this.movementPotential = movement;
        this.productionCost = productionCost;
    }
    String settler = "Settler";
    String worker = "Worker";
    private boolean x=name.equals(settler);
    private boolean y=name.equals(worker);

    public void setX(boolean x) {
        this.x = name.equals(settler);
    }

    public boolean isX() {
        return x;
    }


        if(x){
            foundCity();
                }



        if(y)
        {
            creatLand();
            repaireLand();
        }

public void foundCity(){
        if(civs.get(0).createCity(curPos)){
        currentUnit.deleteFromMapAndCiv();
        ui.resetFocusData();}
        }
    public void creatLand() {}
    public void repaireLand() {}

}