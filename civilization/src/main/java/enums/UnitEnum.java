package enums;

import model.City;
import model.Resource.Resources;
import model.unit.*;

import java.util.Locale;

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
    LONGSWORDSMAN("Longwordsman"),
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

    public String toString() {
        return this.regex;
    }

    public static UnitEnum findUnitEnumByName (String unitName) {
        for (UnitEnum unitEnum : UnitEnum.values()) {
            if(unitName.equals(unitEnum.toString()))
                return unitEnum;
        }
        return null;
    }

    private static boolean checkResourceExist(ResourcesEnum resourcesEnum) {
        for (Resources resources : City.getResources()) {
            if (resources.getName().toLowerCase(Locale.ROOT).equals(resourcesEnum.toString()))
                return true;
        }
        return false;
    }


    public static Unit getUnits(UnitEnum regex) {
        switch (regex) {
            case ARCHER:
                if (TechsEnum.technologyCheck(TechsEnum.ARCHERY))
                    return new Ranged("Archer", 2, 4, 6, 2, 70, true, false);
            case CHARIOTARCHER:
                if (checkResourceExist(ResourcesEnum.HORSES) &&
                        TechsEnum.technologyCheck(TechsEnum.THE_WEEL))
                    return new Ranged("ChariotArcher", 4, 3, 6, 2, 60, true, false);
            case SCOUT:
                return new Melee("Scout", 2, 4, 25, true);
            case SETTLER:
                return new Civilian("Settler", 2, 89);
            case SPEARMAN:
                if (TechsEnum.technologyCheck(TechsEnum.BRONZE_WORKING))
                    return new Melee("Spearman", 2, 7, 50, true);
            case WARRIOR:
                return new Melee("Warrior", 2, 6, 40, true);
            case WORKER:
                return new Civilian("Worker", 2, 70);
            case CATAPULT:
                if (checkResourceExist(ResourcesEnum.IRON) &&
                        TechsEnum.technologyCheck(TechsEnum.MATHEMATICS))
                    return new Ranged("Catapult", 2, 4, 14, 2, 100, true, false);
            case HORSEMAN:
                if (checkResourceExist(ResourcesEnum.HORSES) &&
                        TechsEnum.technologyCheck(TechsEnum.HORSEBACK_RIDING))
                    return new Melee("Horseman", 4, 12, 80, true);
            case SWORDSMAN:
                if (checkResourceExist(ResourcesEnum.IRON) &&
                        TechsEnum.technologyCheck(TechsEnum.IRON_WORKING))
                    return new Melee("Swordsman", 2, 11, 80, true);
            case CROSSBOWMAN:
                if (TechsEnum.technologyCheck(TechsEnum.MACHINERY))
                    return new Ranged("Crossbowman", 2, 6, 12, 2, 120, true, false);
            case KNIGHT:
                if (checkResourceExist(ResourcesEnum.HORSES) &&
                        TechsEnum.technologyCheck(TechsEnum.CHIVALRY))
                    return new Melee("Knight", 3, 18, 150, true);
            case LONGSWORDSMAN:
                if (checkResourceExist(ResourcesEnum.IRON) &&
                        TechsEnum.technologyCheck(TechsEnum.STEEL))
                    return new Melee("Longswordsman", 3, 18, 150, true);
            case PIKEMAN:
                if (TechsEnum.technologyCheck(TechsEnum.CIVIL_SERVICE))
                    return new Melee("Pikeman", 2, 10, 100, true);
            case TREBUCHET:
                if (checkResourceExist(ResourcesEnum.IRON) &&
                        TechsEnum.technologyCheck(TechsEnum.PHYSICS))
                    return new Ranged("Trebuchet", 2, 6, 20, 2, 170, true, false);
            case CANON:
                if (TechsEnum.technologyCheck(TechsEnum.CHEMISTRY))
                    return new Ranged("Canon", 2, 10, 26, 2, 250, true, false);
            case CAVALRY:
                if (checkResourceExist(ResourcesEnum.HORSES) &&
                        TechsEnum.technologyCheck(TechsEnum.MILITARY_SCIENCE))
                    return new Melee("Cavalry", 3, 25, 260, true);
            case LANCER:
                if (checkResourceExist(ResourcesEnum.HORSES) &&
                        TechsEnum.technologyCheck(TechsEnum.METALLURGY))
                    return new Melee("Lancer", 4, 22, 220, true);
            case MUSKETMAN:
                if (TechsEnum.technologyCheck(TechsEnum.GUNPOWDER))
                    return new Melee("Musketman", 2, 16, 120, true);
            case RIFLEMAN:
                if (TechsEnum.technologyCheck(TechsEnum.RIFLING))
                    return new Melee("Rifleman", 2, 25, 200, true);
            case ANTITANKGUN:
                if (TechsEnum.technologyCheck(TechsEnum.REPLACEABLE_PARTS))
                    return new Melee("Anti-Tank Gun", 2, 32, 300, true);
            case ARTILLERY:
                if (TechsEnum.technologyCheck(TechsEnum.DYNAMITE))
                    return new Ranged("Artillery", 2, 16, 32, 3, 420, true, false);
            case INFANTRY:
                if (TechsEnum.technologyCheck(TechsEnum.REPLACEABLE_PARTS))
                    return new Melee("Infantry", 2, 36, 300, true);
            case PANZER:
                if (TechsEnum.technologyCheck(TechsEnum.COMBUSTION))
                    return new Melee("Panzer", 5, 60, 450, true);
            case TANK:
                if (TechsEnum.technologyCheck(TechsEnum.COMBUSTION))
                    return new Melee("Tank", 4, 50, 450, true);
            default:
                if (TechsEnum.technologyCheck(TechsEnum.COMBUSTION))
                    return new Melee("Tank", 4, 50, 450, true);
        }
        return null;
    }
}