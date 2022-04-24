package enums;

public enum UnitEnum {
    ARCHER("Archer"),
    CHARIOTARCHER("ChariotArcher"),
    SCOUT("Scout"),
    SETTLER("Settler"),
    SPEARMAN("Spearman"),
    WARRIOR("Warrior"),
    WORKER("Worker"),
    CATAPULT("Catapult"),
    HORSEMAN("Horseman"),
    SWORDSMAN("Swordsman"),
    CROSSBOWMAN("Crossbowman"),
    KNIGHT("Knight"),
    LONGSWORDSMAN("Longswordsman"),
    PIKEMAN("Pikeman"),
    TREBUCHET("Trebuchet"),
    CANON("Canon"),
    CAVALRY("Cavalry"),
    LANCER("Lancer"),
    MUSKETMAN("Musketman"),
    RIFLEMAN("Rifleman"),
    ANTITANKGUN("Anti-Tank Gun"),
    ARTILLERY("Artillery"),
    INFANTRY("Infantry"),
    PANZER("Panzer"),
    TANK("Tank");

    private String regex;
    UnitEnum(String regex) {
        this.regex = regex;
    }

    public String toString(){
        return this.regex;
    }


}