package enums;

import model.improvements.Improvement;

public enum ImprovementsEnum {
    CAMP("Camp"),
    FARM("Farm"),
    LUMBER_MILL("LumberMill"),
    MINE("Mine"),
    PASTURE("Pasture"),
    PLANTATION("Plantation"),//kesht va kar
    QUARRY("Quarry"),//madan sang
    TRADING_POST("TradingPost"),
    FACTORY("Factory");
    private String regex;
    public String toString() {
        return this.regex;
    }

    ImprovementsEnum(String regex) {
        this.regex = regex;
    }

    public static Improvement getImprovements(ImprovementsEnum improvement) {
        switch (improvement) {
            case CAMP:
                if (TechsEnum.technologyCheck(TechsEnum.TRAPPING))
                    return new Improvement("Camp",0, 0, 0);
            case FARM:
                if (TechsEnum.technologyCheck(TechsEnum.AGRI_CULTURE))
                    return new Improvement("Farm",1, 0, 0);
            case LUMBER_MILL:
                if (TechsEnum.technologyCheck(TechsEnum.CONSTRUCTION))
                    return new Improvement("LumberMill",0, 1, 0);
            case MINE:
                if (TechsEnum.technologyCheck(TechsEnum.MINING))
                    new Improvement("Mine",0, 1, 0);
            case PASTURE:
                if (TechsEnum.technologyCheck(TechsEnum.ANIMAL_HUSBANDRY))
                    new Improvement("Pasture",0, 0, 0);
            case PLANTATION:
                if (TechsEnum.technologyCheck(TechsEnum.CALENDAR))
                    new Improvement("Plantation",0, 0, 0);
            case QUARRY:
                if (TechsEnum.technologyCheck(TechsEnum.MASONRY))
                    new Improvement("Quarry",0, 0, 0);
            case TRADING_POST:
                if (TechsEnum.technologyCheck(TechsEnum.TRAPPING))
                    new Improvement("TradingPost",0, 0, 1);
            case FACTORY:
                if (TechsEnum.technologyCheck(TechsEnum.ENGINEERING))
                    new Improvement("Factory",0, 2, 0);
        }
        return null;
    }
}
