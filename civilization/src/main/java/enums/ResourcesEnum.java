package enums;

import model.Resource.Resources;
import model.hex;
import model.improvements.Improvement;
import model.Tile;

// inke can be found on ye jaye khas bashan hanuz anjam nashode
public enum ResourcesEnum {
    BANANA("Banana"),
    DEER("Deer"),
    CATTLE("Deer"),
    SHEEP("Sheep"),
    WHEAT("Wheat"),
    COAL("Coal"),
    HORSES("Horses"),
    IRON("Iron"),
    COTTON("Cotton"),
    DYES("Dyes"),
    FURS("Furs"),
    GEMS("Gems"),
    GOLD("Gold"),
    INCENSE("Incense"),
    IVORY("Ivory"),
    MARBLE("Marble"),
    SILK("Silk"),
    SILVER("Silver"),
    SUGAR("Sugar");


    private String regex;

    ResourcesEnum(String regex) {
        this.regex = regex;
    }

    public static boolean checkImprovementExists(ImprovementsEnum improvement) {
        for (Improvement improvements : Tile.getImprovements()) {
            if (improvements.getName().equals(improvement.toString()))
                return true;
        }
        return false;
    }


    public String toString() {
        return this.regex;
    }

    public static Resources getResources(ResourcesEnum resource) {
        switch (resource) {
            case BANANA:
                if (checkImprovementExists(ImprovementsEnum.PLANTATION) &&
                        hex.getFeature() == 5)
                    return new Resources("Banana", 1, 0, 0, "farest", "farming", "BonusResources", "");
            case CATTLE:
                if (checkImprovementExists(ImprovementsEnum.PASTURE) &&
                        hex.getRandLand() == 1)
                    return new Resources("Cattle", 1, 0, 0, "Grassland", "Pasture", "BonusResources", "");
            case DEER:
                if (checkImprovementExists(ImprovementsEnum.CAMP) &&
                        (hex.getFeature() == 4 || hex.getRandLand() == 6 || hex.getRandLand() == 2))
                    return new Resources("Deer", 1, 0, 0, "Farest, Tundra,Hill", "camp", "BonusResources", "");
            case SHEEP:
                if (checkImprovementExists(ImprovementsEnum.PASTURE) &&
                        (hex.getRandLand() == 1 || hex.getRandLand() == 6 || hex.getRandLand() == 2))
                    return new Resources("Sheep", 2, 0, 0, "Flat, meadow, desert, hill", "Pasture", "BonusResources", "");
            case WHEAT:
                if (checkImprovementExists(ImprovementsEnum.FARM) &&
                        (hex.getFeature() == 0 || hex.getRandLand() == 4))
                    return new Resources("Wheat", 1, 0, 0, "Flat, Plain", "Farm", "BonusResources", "");
            case COAL:
                if (checkImprovementExists(ImprovementsEnum.MINE) &&
                        (hex.getRandLand() == 1 || hex.getRandLand() == 4 || hex.getRandLand() == 2))
                    return new Resources("Coal", 0, 1, 0, "Flat,  hills, meadows", "mine", "StrategicResources", "Technology needed to be revealed: Scientific theory");
            case HORSES:
                if (checkImprovementExists(ImprovementsEnum.PASTURE) &&
                        (hex.getRandLand() == 1 || hex.getRandLand() == 4 || hex.getRandLand() == 6))
                    return new Resources("Horses", 0, 1, 0, "Tundra, Flat, meadows", "Pasture", "StrategicResources", "Technology needed to be revealed: animalHusbandry");
            case IRON:
                if (checkImprovementExists(ImprovementsEnum.MINE) &&
                        (hex.getRandLand() == 1 || hex.getRandLand() == 4 ||
                                hex.getRandLand() == 0 || hex.getRandLand() == 6 ||
                                hex.getRandLand() == 5 || hex.getRandLand() == 2))
                    return new Resources("Iron", 0, 1, 0, "Tundra, flat, desert, hill, meadow, snow", "mine", "StrategicResources", "Technology needed to be revealed: ironWorking");
            case COTTON:
                if (checkImprovementExists(ImprovementsEnum.PLANTATION) &&
                        (hex.getRandLand() == 1 || hex.getRandLand() == 4 || hex.getRandLand() == 0))
                    return new Resources("Cotton", 0, 0, 2, "Flat, desert, meadow", "Farming", "LuxuryResources", "");
            case DYES:
                if (checkImprovementExists(ImprovementsEnum.PLANTATION) &&
                        (hex.getFeature() == 5 || hex.getFeature() == 4))
                    return new Resources("Dyes", 0, 0, 2, "Dense forest, forest", "farming", "LuxuryResources", "");
            case FURS:
                if (checkImprovementExists(ImprovementsEnum.CAMP) &&
                        (hex.getFeature() == 4 || hex.getRandLand() == 6))
                    return new Resources("Furs", 0, 0, 2, "Forest, tundra", "camp", "LuxuryResources", "");
            case GEMS:
                if (checkImprovementExists(ImprovementsEnum.MINE) &&
                        (hex.getFeature() == 5 || hex.getRandLand() == 1 ||
                                hex.getRandLand() == 4 || hex.getRandLand() == 0 ||
                                hex.getRandLand() == 6 || hex.getRandLand() == 2))
                    return new Resources("Gems", 0, 0, 3, "Dense forests, tundra, flat, deserts, meadows, hills", "mine", "LuxuryResources", "");
            case GOLD:
                if (checkImprovementExists(ImprovementsEnum.MINE) &&
                        (hex.getRandLand() == 1 || hex.getRandLand() == 4 ||
                                hex.getRandLand() == 0 || hex.getRandLand() == 2))
                    return new Resources("Gold", 0, 0, 2, "Flat,  desert, meadow, hill", "mine", "LuxuryResources", "");
            case INCENSE:
                if (checkImprovementExists(ImprovementsEnum.PLANTATION) &&
                        (hex.getRandLand() == 0 || hex.getRandLand() == 4))
                    return new Resources("Incense", 0, 0, 2, "Flat, desert", "farming", "LuxuryResources", "");
            case IVORY:
                if (checkImprovementExists(ImprovementsEnum.CAMP) &&
                        hex.getRandLand() == 4)
                    return new Resources("Ivory", 0, 0, 2, "Flat", "camp", "LuxuryResources", "");
            case MARBLE:
                if (checkImprovementExists(ImprovementsEnum.QUARRY) &&
                        (hex.getRandLand() == 1 || hex.getRandLand() == 4 ||
                                hex.getRandLand() == 0 || hex.getRandLand() == 6 ||
                                hex.getRandLand() == 2))
                    return new Resources("Marble", 0, 0, 2, "Tundra, flat, desert, meadow, hill", "Stone mine", "LuxuryResources", "");
            case SILK:
                if (checkImprovementExists(ImprovementsEnum.PLANTATION) &&
                        hex.getFeature() == 4)
                    return new Resources("Silk", 0, 0, 2, "farest", "farming", "LuxuryResources", "");
            case SILVER:
                if (checkImprovementExists(ImprovementsEnum.MINE) &&
                        (hex.getRandLand() == 6 || hex.getRandLand() == 0 || hex.getRandLand() == 2))
                    return new Resources("Silver", 0, 0, 2, "Tundra, desert, hill", "mine", "LuxuryResources", "");
            case SUGAR:
                if (checkImprovementExists(ImprovementsEnum.PLANTATION) &&
                        (hex.getFeature() == 0 || hex.getFeature() == 2))
                    return new Resources("Sugar", 0, 0, 2, "Plain, swamp", "farming", "LuxuryResources", "");
        }
        return null;
    }
}
