package enums;

import model.techs.Technology;
import model.techs.TechnologyCheckRequired;

public enum TechsEnum {
    AGRI_CULTURE,
    ANIMAL_HUSBANDRY,
    ARCHERY,
    BRONZE_WORKING,
    CALENDAR,
    MASONRY,
    MINING,
    POTTERY,
    THE_WEEL,
    TRAPPING,
    WRITING,
    CONSTRUCTION,
    HORSEBACK_RIDING,
    IRON_WORKING,
    MATHEMATICS,
    PHILOSOPHY,
    CHIVALRY,
    CIVIL_SERVICE,
    CURRENCY,
    ENGINEERING,
    MACHINERY,
    METAL_CASTING,
    PHYSICS,
    STEEL,
    THEOLOGY,
    ACOUSTICS,
    ARCHAEOLOGY,
    BANKING,
    CHEMISTRY,
    ECONOMICS,
    FERTILIZER,
    GUNPOWDER,
    METALLURGY,
    MILITARY_SCIENCE,
    PRINTING_PRESS,
    RIFLING,
    SCIENTIFIC_TEHEORY,
    BIOLOGY,
    COMBUSTION,
    DYNAMITE,
    ELECTRICITY,
    RADIO,
    RAIL_ROAD,
    REPLACEABLE_PARTS,
    STEAM_POWER,
    TELEGRAPH,
    EDUCATION;

    public static Technology getTechnologies(TechsEnum tech) {
        switch (tech) {
            case AGRI_CULTURE:
                if (TechnologyCheckRequired.potteryCheck() &&
                        TechnologyCheckRequired.animalHusbandryCheck() &&
                        TechnologyCheckRequired.archeryCheck() &&
                        TechnologyCheckRequired.miningCheck() &&
                        !TechnologyCheckRequired.agricultureCheck())
                    return new Technology("Agriculture", 20, "None", "Pottery, Animal Husbandry, Archery, Mining", "farm");
            case ANIMAL_HUSBANDRY:
                if (TechnologyCheckRequired.trappingCheck() &&
                        TechnologyCheckRequired.theWeelCheck() &&
                        !TechnologyCheckRequired.animalHusbandryCheck())
                    return new Technology("Animal Husbandry", 35, "Agriculture", "Trapping, The Wheel", "horse, Pasture");
            case ARCHERY:
                if (TechnologyCheckRequired.mathematicsCheck() &&
                        !TechnologyCheckRequired.archeryCheck())
                    return new Technology("Archery", 35, "Agriculture", "Mathematics", "Archer");
            case BRONZE_WORKING:
                if (TechnologyCheckRequired.ironWorkingCheck() &&
                        !TechnologyCheckRequired.bronzeWorkingCheck())
                    return new Technology("Bronze Working", 55, "Mining", "Iron Working", "Spearman, Barracks, Remove massive forests");
            case CALENDAR:
                if (TechnologyCheckRequired.theologyCheck() &&
                        !TechnologyCheckRequired.calendarCheck())
                    return new Technology("Calendar", 70, "Pottery", "Theology", "Cultivation");
            case MASONRY:
                if (TechnologyCheckRequired.constructionCheck() &&
                        !TechnologyCheckRequired.masonryCheck())
                    return new Technology("Masonry", 55, "Mining", "Construction", "Walls, Stone mine, Remove the swamp");
            case MINING:
                if (TechnologyCheckRequired.masonryCheck() &&
                        TechnologyCheckRequired.bronzeWorkingCheck() &&
                        !TechnologyCheckRequired.miningCheck())
                    return new Technology("Mining", 35, "Agriculture", "Masonry, Bronze Working", "Mines, Remove forests");
            case POTTERY:
                if (TechnologyCheckRequired.calendarCheck() &&
                        TechnologyCheckRequired.writingCheck() &&
                        !TechnologyCheckRequired.potteryCheck())
                    return new Technology("Pottery", 35, "Agriculture", "Calendar, Writing", "Granary");
            case THE_WEEL:
                if (TechnologyCheckRequired.horsebackRidingCheck() &&
                        TechnologyCheckRequired.mathematicsCheck() &&
                        !TechnologyCheckRequired.theWeelCheck())
                    return new Technology("The Wheel", 55, "Animal Husbandry", "Horseback Riding, Mathematics", "Chariot Archer, Water Mill, build a Road");
            case TRAPPING:
                if (TechnologyCheckRequired.civilServiceCheck() &&
                        !TechnologyCheckRequired.trappingCheck())
                    return new Technology("Trapping", 55, "Animal Husbandry", "Civil Service", "Trading Post, Camp");
            case WRITING:
                if (TechnologyCheckRequired.philosophyCheck() &&
                        !TechnologyCheckRequired.writingCheck())
                    return new Technology("Writing", 55, "Pottery", "Philosophy", "Library");
            case CONSTRUCTION:
                if (TechnologyCheckRequired.engineeringCheck() &&
                        !TechnologyCheckRequired.constructionCheck())
                    return new Technology("Construction", 100, "Masonry", "Engineering", "Colosseum, bridges over rivers");
            case HORSEBACK_RIDING:
                if (TechnologyCheckRequired.chivalryCheck() &&
                        !TechnologyCheckRequired.horsebackRidingCheck())
                    return new Technology("Horseback Riding", 100, "The Wheel", "Chivalry", "Horseman, Stable, Circus");
            case IRON_WORKING:
                if (TechnologyCheckRequired.metalCastingCheck() &&
                        !TechnologyCheckRequired.ironWorkingCheck())
                    return new Technology("Iron Working", 150, "Bronze Working", "Metal Casting", "Swordsman, Legion, Armory, Iron");
            case MATHEMATICS:
                if (TechnologyCheckRequired.currencyCheck() &&
                        TechnologyCheckRequired.engineeringCheck() &&
                        !TechnologyCheckRequired.mathematicsCheck())
                    return new Technology("Mathematics", 100, "The Wheel, Archery", "Currency, Engineering", "Catapult, Courthouse");
            case PHILOSOPHY:
                if (TechnologyCheckRequired.theologyCheck() &&
                        TechnologyCheckRequired.civilServiceCheck() &&
                        !TechnologyCheckRequired.philosophyCheck())
                    return new Technology("Philosophy", 100, "Writing", "Theology, Civil Service", "Burial Tomb, Temple");
            case CHIVALRY:
                if (TechnologyCheckRequired.bankingCheck() &&
                        !TechnologyCheckRequired.chivalryCheck())
                    return new Technology("Chivalry", 440, "Civil Service, Horseback Riding, Currency", "Banking", "Knight, Camel Archer, Castle");
            case CIVIL_SERVICE:
                if (TechnologyCheckRequired.chivalryCheck() &&
                        !TechnologyCheckRequired.civilServiceCheck())
                    return new Technology("Civil Service", 400, "Philosophy, Trapping", "Chivalry", "Pikeman");
            case CURRENCY:
                if (TechnologyCheckRequired.chivalryCheck() &&
                        !TechnologyCheckRequired.currencyCheck())
                    return new Technology("Currency", 250, "Mathematics", "Chivalry", "Market");
            case ENGINEERING:
                if (TechnologyCheckRequired.machineryCheck() &&
                        TechnologyCheckRequired.physicsCheck() &&
                        !TechnologyCheckRequired.engineeringCheck())
                    return new Technology("Engineering", 250, "Mathematics, Construction", "Machinery, Physics", "");
            case MACHINERY:
                if (TechnologyCheckRequired.printingPressCheck() &&
                        !TechnologyCheckRequired.machineryCheck())
                    return new Technology("Machinery", 440, "Engineering", "Printing Press", "Crossbowman, 1.2 faster road movement");
            case METAL_CASTING:
                if (TechnologyCheckRequired.physicsCheck() &&
                        TechnologyCheckRequired.steelCheck() &&
                        !TechnologyCheckRequired.metalCastingCheck())
                    return new Technology("Metal Casting", 240, "Iron Working", "Physics, Steel", "Forge, Workshop");
            case PHYSICS:
                if (TechnologyCheckRequired.printingPressCheck() &&
                        TechnologyCheckRequired.gunpowderCheck() &&
                        !TechnologyCheckRequired.physicsCheck())
                    return new Technology("Physics", 440, "Engineering, Metal Casting", "Printing Press, Gunpowder", "Trebuchet");
            case STEEL:
                if (TechnologyCheckRequired.gunpowderCheck() &&
                        !TechnologyCheckRequired.steelCheck())
                    return new Technology("Steel", 440, "Metal Casting", "Gunpowder", "Longswordsman");
            case THEOLOGY:
                if (TechnologyCheckRequired.educationCheck() &&
                        !TechnologyCheckRequired.theologyCheck())
                    return new Technology("Theology", 250, "Calendar, Philosophy", "Education", "Monastery, Garden");
            case ACOUSTICS:
                if (TechnologyCheckRequired.scientificTheoryCheck() &&
                        !TechnologyCheckRequired.acousticsCheck())
                    return new Technology("Acoustics", 650, "Education", "Scientific Theory", "");
            case ARCHAEOLOGY:
                if (TechnologyCheckRequired.biologyCheck() &&
                        !TechnologyCheckRequired.archaeologyCheck())
                    return new Technology("Archaeology", 1300, "Acoustics", "Biology", "Museum");
            case BANKING:
                if (TechnologyCheckRequired.economicsCheck() &&
                        !TechnologyCheckRequired.bankingCheck())
                    return new Technology("Banking", 650, " Education, Chivalry", "Economics", "Satrap’s Court, Bank");
            case CHEMISTRY:
                if (TechnologyCheckRequired.militaryScienceCheck() &&
                        TechnologyCheckRequired.fertilizerCheck() &&
                        !TechnologyCheckRequired.chemistryCheck())
                    return new Technology("Chemistry", 900, "Gunpowder", "Military Science, Fertilize", "Ironworks");
            case ECONOMICS:
                if (TechnologyCheckRequired.militaryScienceCheck() &&
                        !TechnologyCheckRequired.economicsCheck())
                    return new Technology("Economics", 900, "Banking, Printing Press", "Military Science", "Windmill");
            case FERTILIZER:
                if (TechnologyCheckRequired.dynamiteCheck() &&
                        !TechnologyCheckRequired.fertilizerCheck())
                    return new Technology("Fertilizer", 1300, "Chemistry", "Dynamite", "Farms without Fresh Water yield increased by 1");
            case GUNPOWDER:
                if (TechnologyCheckRequired.chemistryCheck() &&
                        TechnologyCheckRequired.metallurgyCheck() &&
                        !TechnologyCheckRequired.gunpowderCheck())
                    return new Technology("Gunpowder", 680, "Physics, Steel", "Chemistry, Metallurgy", "Musketman");
            case METALLURGY:
                if (TechnologyCheckRequired.riflingCheck() &&
                        !TechnologyCheckRequired.metallurgyCheck())
                    return new Technology("Metallurgy", 900, "Gunpowder", "Rifling", "Lancer");
            case MILITARY_SCIENCE:
                if (TechnologyCheckRequired.steamPowerCheck() &&
                        !TechnologyCheckRequired.militaryScienceCheck())
                    return new Technology("Military Science", 1300, "Economics, Chemistry", "Steam Power ", "Cavalry, Military Academy");
            case PRINTING_PRESS:
                if (TechnologyCheckRequired.economicsCheck() &&
                        !TechnologyCheckRequired.printingPressCheck())
                    return new Technology("Printing Press", 650, "Machinery, Physics", "Economics", "Theater");
            case RIFLING:
                if (TechnologyCheckRequired.dynamiteCheck() &&
                        !TechnologyCheckRequired.riflingCheck())
                    return new Technology("Rifling", 1425, "Metallurgy", "Dynamite", "Rifleman");
            case SCIENTIFIC_TEHEORY:
                if (TechnologyCheckRequired.biologyCheck() &&
                        TechnologyCheckRequired.steamPowerCheck() &&
                        !TechnologyCheckRequired.scientificTheoryCheck())
                    return new Technology("Scientific Theory", 1300, "Acoustics", "Biology, Steam Power", "Public School, Coal");
            case BIOLOGY:
                if (TechnologyCheckRequired.electricityCheck() &&
                        !TechnologyCheckRequired.biologyCheck())
                    return new Technology("Biology", 1680, "Archaeology, Scientific Theory", "Electricity", "");
            case COMBUSTION:
                if (!TechnologyCheckRequired.combustionCheck())
                    return new Technology("Combustion", 2200, "Replaceable Parts, Railroad, Dynamite", "", "Tank, Panzer");
            case DYNAMITE:
                if (TechnologyCheckRequired.combustionCheck() &&
                        !TechnologyCheckRequired.dynamiteCheck())
                    return new Technology("Dynamite", 1900, "Fertilizer, Rifling", "Combustion", "Artillery");
            case ELECTRICITY:
                if (TechnologyCheckRequired.telegraphCheck() &&
                        TechnologyCheckRequired.radioCheck() &&
                        !TechnologyCheckRequired.electricityCheck())
                    return new Technology("Electricity", 1900, "Biology, Steam Power", "Telegraph, Radio", "Stock Exchange");
            case RADIO:
                if (!TechnologyCheckRequired.radioCheck())
                    return new Technology("Radio", 2200, "Electricity", "", "Broadcast Tower");
            case RAIL_ROAD:
                if (TechnologyCheckRequired.combustionCheck() &&
                        !TechnologyCheckRequired.railroadCheck())
                    return new Technology("Railroad", 1900, "Steam Power", "Combustion", "Arsenal, Railroad ");
            case REPLACEABLE_PARTS:
                if (TechnologyCheckRequired.combustionCheck() &&
                        !TechnologyCheckRequired.replaceablePartsCheck())
                    return new Technology("Replaceable Parts", 1900, "Steam Power", "Combustion", "Anti-Tank Gun, Infantry");
            case STEAM_POWER:
                if (TechnologyCheckRequired.electricityCheck() &&
                        TechnologyCheckRequired.replaceablePartsCheck() &&
                        TechnologyCheckRequired.railroadCheck() &&
                        !TechnologyCheckRequired.steamPowerCheck())
                    return new Technology("Steam Power", 1680, "Scientific Theory, Military Science", "Electricity, Replaceable Parts, Railroad", "Factory");
            case TELEGRAPH:
                if (!TechnologyCheckRequired.telegraphCheck())
                    return new Technology("Telegraph", 2200, "Electricity", "", "Military Base");
            case EDUCATION:
                if (TechnologyCheckRequired.acousticsCheck() &&
                        TechnologyCheckRequired.bankingCheck() &&
                        !TechnologyCheckRequired.educationCheck())
                    return new Technology("Education", 440, "Theology", "Acoustics, Banking", "University");
        }
        return null;
    }
}
