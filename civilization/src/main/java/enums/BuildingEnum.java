package enums;

import model.Building;

public enum BuildingEnum {
    PALACE("Palace"),
    BARRACKS("Barracks"),
    GRANARY("Granary"),
    LIBRARY("Library"),
    MONUMENT("Monument"),
    WALLS("Walls"),
    WATER_MILL("WaterMill"),
    ARMORY("Armory"),
    BURIAL_TOMB("BurialTomb"),
    CIRCUS("Circus"),
    COLOSSEUM("Colosseum"),
    COURTHOUSE("Courthouse"),
    STABLE("Stable"),
    TEMPLE("Temple"),
    CASTLE("Castle"),
    FORGE("Forge"),
    GARDEN("Garden"),
    MARKET("Market"),
    MINT("Mint"),
    MONASTERY("Monastery"),
    UNIVERSITY("University"),
    WORKSHOP("Workshop"),
    BANK("Bank"),
    MILITARY_ACADEMY("MilitaryAcademy"),
    MUSEUM("Museum"),
    OPERA_HOUSE("OperaHouse"),
    PUBLIC_SCHOOL("PublicSchool"),
    SATRAP_COURT("SatrapsCourt"),
    THEATER("Theater"),
    WINDMILL("Windmill"),
    ARSENAL("Arsenal"),
    BROADCAST_TOWER("BroadcastTower"),
    FACTORY("Factory"),
    HOSPITAL("Hospital"),
    MILITARY_BASE("MilitaryBase"),
    STOCK_EXCHANGE("StockExchange");


    private String regex;

    BuildingEnum(String regex) {
        this.regex = regex;
    }

    public String toString() {
        return this.regex;
    }


    public static Building makeBuilding(BuildingEnum building) {
        switch (building) {
            case BARRACKS:
                if (TechsEnum.technologyCheck(TechsEnum.BRONZE_WORKING))
                    return new Building(BARRACKS.toString(), 80, 1);
            case GRANARY:
                if (TechsEnum.technologyCheck(TechsEnum.POTTERY))
                    return new Building(GRANARY.toString(), 100, 1);
            case LIBRARY:
                if (TechsEnum.technologyCheck(TechsEnum.WRITING))
                    return new Building(LIBRARY.toString(), 80, 1);
            case MONUMENT:
                return new Building(MONUMENT.toString(), 60, 1);
            case WALLS:
                if (TechsEnum.technologyCheck(TechsEnum.MASONRY))
                    return new Building(WALLS.toString(), 100, 1);
            case WATER_MILL:
                if (TechsEnum.technologyCheck(TechsEnum.THE_WEEL))
                    return new Building(WATER_MILL.toString(), 120, 2);
            case ARMORY:
                if (TechsEnum.technologyCheck(TechsEnum.IRON_WORKING))
                    return new Building(ARMORY.toString(), 130, 3);
            case BURIAL_TOMB:
                if (TechsEnum.technologyCheck(TechsEnum.PHILOSOPHY))
                    return new Building(BURIAL_TOMB.toString(), 120, 0);
            case CIRCUS:
                if (TechsEnum.technologyCheck(TechsEnum.HORSEBACK_RIDING))
                    return new Building(CIRCUS.toString(), 150, 3);
            case COLOSSEUM:
                if (TechsEnum.technologyCheck(TechsEnum.CONSTRUCTION))
                    return new Building(COLOSSEUM.toString(), 150, 3);
            case COURTHOUSE:
                if (TechsEnum.technologyCheck(TechsEnum.MATHEMATICS))
                    return new Building(COURTHOUSE.toString(), 200, 5);
            case STABLE:
                if (TechsEnum.technologyCheck(TechsEnum.HORSEBACK_RIDING))
                    return new Building(STABLE.toString(), 100, 1);
            case TEMPLE:
                if (TechsEnum.technologyCheck(TechsEnum.PHILOSOPHY))
                    return new Building(TEMPLE.toString(), 120, 2);
            case CASTLE:
                if (TechsEnum.technologyCheck(TechsEnum.CHIVALRY))
                    return new Building(CASTLE.toString(), 200, 3);
            case FORGE:
                if (TechsEnum.technologyCheck(TechsEnum.METAL_CASTING))
                    return new Building(FORGE.toString(), 150, 2);
            case GARDEN:
                if (TechsEnum.technologyCheck(TechsEnum.THEOLOGY))
                    return new Building(GARDEN.toString(), 120, 2);
            case MARKET:
                if (TechsEnum.technologyCheck(TechsEnum.CURRENCY))
                    return new Building(MARKET.toString(), 120, 0);
            case MINT:
                if (TechsEnum.technologyCheck(TechsEnum.CURRENCY))
                    return new Building(MINT.toString(), 120, 0);
            case MONASTERY:
                if (TechsEnum.technologyCheck(TechsEnum.THEOLOGY))
                    return new Building(MONASTERY.toString(), 120, 2);
            case UNIVERSITY:
                if (TechsEnum.technologyCheck(TechsEnum.EDUCATION))
                    return new Building(UNIVERSITY.toString(), 200, 3);
            case WORKSHOP:
                if (TechsEnum.technologyCheck(TechsEnum.METAL_CASTING))
                    return new Building(WORKSHOP.toString(), 100, 2);
            case BANK:
                if (TechsEnum.technologyCheck(TechsEnum.BANKING))
                    return new Building(BANK.toString(), 220, 0);
            case MILITARY_ACADEMY:
                if (TechsEnum.technologyCheck(TechsEnum.MILITARY_SCIENCE))
                    return new Building(MILITARY_ACADEMY.toString(), 350, 3);
            case MUSEUM:
                if (TechsEnum.technologyCheck(TechsEnum.ARCHAEOLOGY))
                    return new Building(MUSEUM.toString(), 350, 3);
            case OPERA_HOUSE:
                if (TechsEnum.technologyCheck(TechsEnum.ACOUSTICS))
                    return new Building(OPERA_HOUSE.toString(), 220, 3);
            case PUBLIC_SCHOOL:
                if (TechsEnum.technologyCheck(TechsEnum.SCIENTIFIC_TEHEORY))
                    return new Building(PUBLIC_SCHOOL.toString(), 350, 3);
            case SATRAP_COURT:
                if (TechsEnum.technologyCheck(TechsEnum.BANKING))
                    return new Building(SATRAP_COURT.toString(), 220, 0);
            case THEATER:
                if (TechsEnum.technologyCheck(TechsEnum.PRINTING_PRESS))
                    return new Building(THEATER.toString(), 300, 5);
            case WINDMILL:
                if (TechsEnum.technologyCheck(TechsEnum.ECONOMICS))
                    return new Building(WINDMILL.toString(), 180, 2);
            case ARSENAL:
                if (TechsEnum.technologyCheck(TechsEnum.RAIL_ROAD))
                    return new Building(ARSENAL.toString(), 350, 3);
            case BROADCAST_TOWER:
                if (TechsEnum.technologyCheck(TechsEnum.RADIO))
                    return new Building(BROADCAST_TOWER.toString(), 600, 3);
            case FACTORY:
                if (TechsEnum.technologyCheck(TechsEnum.STEAM_POWER))
                    return new Building(FACTORY.toString(), 300, 3);
            case HOSPITAL:
                if (TechsEnum.technologyCheck(TechsEnum.BIOLOGY))
                    return new Building(HOSPITAL.toString(), 400, 2);
            case MILITARY_BASE:
                if (TechsEnum.technologyCheck(TechsEnum.TELEGRAPH))
                    return new Building(MILITARY_BASE.toString(), 450, 4);
            case STOCK_EXCHANGE:
                if (TechsEnum.technologyCheck(TechsEnum.ELECTRICITY))
                    return new Building(STOCK_EXCHANGE.toString(), 650, 0);
            case PALACE:
                return new Building(PALACE.toString(), 0, 0);
        }
        return null;
    }
}
