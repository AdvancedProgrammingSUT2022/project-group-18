package enums;

import model.Resource.Resources;
import model.unit.*;
import view.View;

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
    ANTITANKGUN("AntiTankGun"),
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

    public static UnitEnum findUnitEnumByName(String unitName) {
        for (UnitEnum unitEnum : UnitEnum.values()) {
            if (unitName.equals(unitEnum.toString()))
                return unitEnum;
        }
        return null;
    }

    private static boolean checkResourceExist(ResourcesEnum resourcesEnum) {
        for (Resources resources : View.getInCity().getResources()) {
            if (resources.getName().toLowerCase(Locale.ROOT).equals(resourcesEnum.toString()))
                return true;
        }
        return false;
    }

    public static Unit getUnits(UnitEnum regex) {

        if (regex.equals(UnitEnum.ARCHER)) {
            if (TechsEnum.technologyCheck(TechsEnum.ARCHERY))
                return new Ranged("Archer", 2, 4, 6, 2, 70, true, false);

        }
        if (regex.equals(UnitEnum.CHARIOTARCHER)) {
            if (checkResourceExist(ResourcesEnum.HORSES) &&
                    TechsEnum.technologyCheck(TechsEnum.THE_WEEL))
                return new Ranged("ChariotArcher", 4, 3, 6, 2, 60, true, false);

        }

        if (regex.equals(UnitEnum.SCOUT)) {
            return new Melee("Scout", 2, 4, 25, true);
        }
        if (regex.equals(UnitEnum.SETTLER)) {
            return new Settler("Settler", 2, 89);
        }
        if (regex.equals(UnitEnum.SPEARMAN)) {
            if (TechsEnum.technologyCheck(TechsEnum.BRONZE_WORKING))
                return new Melee("Spearman", 2, 7, 50, true);
        }

        if (regex.equals(UnitEnum.WARRIOR)) {
            return new Melee("Warrior", 2, 6, 40, true);
        }
        if (regex.equals(UnitEnum.WORKER)) {
            return new Worker("Worker", 2, 70);
        }
        if (regex.equals(UnitEnum.CATAPULT)) {
            if (checkResourceExist(ResourcesEnum.IRON) &&
                    TechsEnum.technologyCheck(TechsEnum.MATHEMATICS))
                return new Ranged("Catapult", 2, 4, 14, 2, 100, true, false);
        }
        if (regex.equals(UnitEnum.HORSEMAN)) {
            if (checkResourceExist(ResourcesEnum.HORSES) &&
                    TechsEnum.technologyCheck(TechsEnum.HORSEBACK_RIDING))
                return new Melee("Horseman", 4, 12, 80, true);
        }
        if (regex.equals(UnitEnum.SWORDSMAN)) {
            if (checkResourceExist(ResourcesEnum.IRON) &&
                    TechsEnum.technologyCheck(TechsEnum.IRON_WORKING))
                return new Melee("Swordsman", 2, 11, 80, true);
        }
        if (regex.equals(UnitEnum.CROSSBOWMAN)) {
            if (TechsEnum.technologyCheck(TechsEnum.MACHINERY))
                return new Ranged("Crossbowman", 2, 6, 12, 2, 120, true, false);
        }
        if (regex.equals(UnitEnum.KNIGHT)) {
            if (checkResourceExist(ResourcesEnum.HORSES) &&
                    TechsEnum.technologyCheck(TechsEnum.CHIVALRY))
                return new Melee("Knight", 3, 18, 150, true);
        }
        if (regex.equals(UnitEnum.LONGSWORDSMAN)) {
            if (checkResourceExist(ResourcesEnum.IRON) &&
                    TechsEnum.technologyCheck(TechsEnum.STEEL))
                return new Melee("Longswordsman", 3, 18, 150, true);
        }
        if (regex.equals(UnitEnum.PIKEMAN)) {
            if (TechsEnum.technologyCheck(TechsEnum.CIVIL_SERVICE))
                return new Melee("Pikeman", 2, 10, 100, true);
        }
        if (regex.equals(UnitEnum.TREBUCHET)) {
            if (checkResourceExist(ResourcesEnum.IRON) &&
                    TechsEnum.technologyCheck(TechsEnum.PHYSICS))
                return new Ranged("Trebuchet", 2, 6, 20, 2, 170, true, false);
        }
        if (regex.equals(UnitEnum.CANON)) {
            if (TechsEnum.technologyCheck(TechsEnum.CHEMISTRY))
                return new Ranged("Canon", 2, 10, 26, 2, 250, true, false);
        }
        if (regex.equals(UnitEnum.CAVALRY)) {
            if (checkResourceExist(ResourcesEnum.HORSES) &&
                    TechsEnum.technologyCheck(TechsEnum.MILITARY_SCIENCE))
                return new Melee("Cavalry", 3, 25, 260, true);
        }
        if (regex.equals(UnitEnum.LANCER)) {
            if (checkResourceExist(ResourcesEnum.HORSES) &&
                    TechsEnum.technologyCheck(TechsEnum.METALLURGY))
                return new Melee("Lancer", 4, 22, 220, true);
        }
        if (regex.equals(UnitEnum.MUSKETMAN)) {
            if (TechsEnum.technologyCheck(TechsEnum.GUNPOWDER))
                return new Melee("Musketman", 2, 16, 120, true);
        }
        if (regex.equals(UnitEnum.RIFLEMAN)) {
            if (TechsEnum.technologyCheck(TechsEnum.RIFLING))
                return new Melee("Rifleman", 2, 25, 200, true);
        }
        if (regex.equals(UnitEnum.ANTITANKGUN)) {
            if (TechsEnum.technologyCheck(TechsEnum.REPLACEABLE_PARTS))
                return new Melee("AntiTankGun", 2, 32, 300, true);
        }
        if (regex.equals(UnitEnum.ARTILLERY)) {
            if (TechsEnum.technologyCheck(TechsEnum.DYNAMITE))
                return new Ranged("Artillery", 2, 16, 32, 3, 420, true, false);
        }

        if (regex.equals(UnitEnum.INFANTRY)) {
            if (TechsEnum.technologyCheck(TechsEnum.REPLACEABLE_PARTS))
                return new Melee("Infantry", 2, 36, 300, true);
        }
        if (regex.equals(UnitEnum.PANZER)) {
            if (TechsEnum.technologyCheck(TechsEnum.COMBUSTION))
                return new Melee("Panzer", 5, 60, 450, true);
        }
        if (regex.equals(UnitEnum.TANK)) {
            if (TechsEnum.technologyCheck(TechsEnum.COMBUSTION))
                return new Melee("Tank", 4, 50, 450, true);
        }


        return null;
    }
}