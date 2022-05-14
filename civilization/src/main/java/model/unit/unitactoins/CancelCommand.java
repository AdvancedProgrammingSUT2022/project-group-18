package Model.unit.unitactoins;
import Model.unit.Melee;
import Model.unit.Ranged;
import Model.unit.Settler;
import Model.unit.Worker;

public class CancelCommand extends AbstarctActoin {
    String nameOfCommand;

    public CancelCommand(Ranged unit, String nameOfCommand) {
        super(unit);
        this.nameOfCommand = nameOfCommand;
    }

    public CancelCommand(Melee unit, String nameOfCommand) {
        super(unit);
        this.nameOfCommand = nameOfCommand;
    }

    public CancelCommand(Worker unit, String nameOfCommand) {
        super(unit);
        this.nameOfCommand = nameOfCommand;
    }

    public CancelCommand(Settler unit, String nameOfCommand) {
        super(unit);
        this.nameOfCommand = nameOfCommand;
    }

    public void cancelCommand() {
        if (nameOfCommand.equals("HealthSupport")) {
            unit.health--;
        }
        if (nameOfCommand.equals("RangedAttack")) {
            unit.target = Integer.parseInt(null);
        }
        if (nameOfCommand.equals("ReadyForRangedAttack")) {
            unit.target = Integer.parseInt(null);
        }
        if (nameOfCommand.equals("ReadyMood")) {
            unit.getCommand = false;
        }
        if (nameOfCommand.equals("Settle")) {
            unit.combatStrength -= 2;
        }
        if (nameOfCommand.equals("Sleep")) {
            unit.getCommand = true;
        }
        if (nameOfCommand.equals("Support")) {
            unit.getCommand = true;
            unit.combatStrength--;
        }
        if (nameOfCommand.equals("WakeUp")) {
            unit.getCommand = false;
        }


    }
}
