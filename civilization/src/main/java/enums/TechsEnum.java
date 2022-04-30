package enums;

import model.techs.Technology;

import java.util.Locale;

public enum TechsEnum {
    AGRI_CULTURE("Agriculture"),
    ANIMAL_HUSBANDRY("Animal Husbandry"),
    ARCHERY("Archery"),
    BRONZE_WORKING("Bronze Working"),
    CALENDAR("Calendar"),
    MASONRY("Masonry"),
    MINING("Mining"),
    POTTERY("Pottery"),
    THE_WEEL("The Wheel"),
    TRAPPING("Trapping"),
    WRITING("Writing"),
    CONSTRUCTION("Construction"),
    HORSEBACK_RIDING("Horseback Riding"),
    IRON_WORKING("Iron Working"),
    MATHEMATICS("Mathematics"),
    PHILOSOPHY("Philosophy"),
    CHIVALRY("Chivalry"),
    CIVIL_SERVICE("Civil Service"),
    CURRENCY("Currency"),
    ENGINEERING("Engineering"),
    MACHINERY("Machinery"),
    METAL_CASTING("Metal Casting"),
    PHYSICS("Physics"),
    STEEL("Steel"),
    THEOLOGY("Theology"),
    ACOUSTICS("Acoustics"),
    ARCHAEOLOGY("Archaeology"),
    BANKING("Banking"),
    CHEMISTRY("Chemistry"),
    ECONOMICS("Economics"),
    FERTILIZER("Fertilizer"),
    GUNPOWDER("Gunpowder"),
    METALLURGY("Metallurgy"),
    MILITARY_SCIENCE("Military Science"),
    PRINTING_PRESS("Printing Press"),
    RIFLING("Rifling"),
    SCIENTIFIC_TEHEORY("Scientific Theory"),
    BIOLOGY("Biology"),
    COMBUSTION("Combustion"),
    DYNAMITE("Dynamite"),
    ELECTRICITY("Electricity"),
    RADIO("Radio"),
    RAIL_ROAD("Railroad"),
    REPLACEABLE_PARTS("Replaceable Parts"),
    STEAM_POWER("Steam Power"),
    TELEGRAPH("Telegraph"),
    EDUCATION("Education");

    private String regex;

    TechsEnum(String regex) {
        this.regex = regex;
    }

    public String toString() {
        return this.regex;
    }

    public static boolean technologyCheck(TechsEnum name) {
        for (Technology techs : Technology.technologies) {
            if (techs.getName().equals(name.toString()))
                return true;
        }
        return false;
    }

    public static Technology getTechnologies(TechsEnum tech) {
        switch (tech) {
            case AGRI_CULTURE:
                if (technologyCheck(POTTERY) &&
                        technologyCheck(ANIMAL_HUSBANDRY) &&
                        technologyCheck(ARCHERY) &&
                        technologyCheck(MINING) &&
                        !technologyCheck(AGRI_CULTURE))
                    return new Technology("Agriculture", 20, "None", "Pottery, Animal Husbandry, Archery, Mining", "farm");
            case ANIMAL_HUSBANDRY:
                if (technologyCheck(TRAPPING) &&
                        technologyCheck(THE_WEEL) &&
                        !technologyCheck(ANIMAL_HUSBANDRY))
                    return new Technology("Animal Husbandry", 35, "Agriculture", "Trapping, The Wheel", "horse, Pasture");
            case ARCHERY:
                if (technologyCheck(MATHEMATICS) &&
                        !technologyCheck(ARCHERY))
                    return new Technology("Archery", 35, "Agriculture", "Mathematics", "Archer");
            case BRONZE_WORKING:
                if (technologyCheck(IRON_WORKING) &&
                        !technologyCheck(BRONZE_WORKING))
                    return new Technology("Bronze Working", 55, "Mining", "Iron Working", "Spearman, Barracks, Remove massive forests");
            case CALENDAR:
                if (technologyCheck(THEOLOGY) &&
                        !technologyCheck(CALENDAR))
                    return new Technology("Calendar", 70, "Pottery", "Theology", "Cultivation");
            case MASONRY:
                if (technologyCheck(CONSTRUCTION) &&
                        !technologyCheck(MASONRY))
                    return new Technology("Masonry", 55, "Mining", "Construction", "Walls, Stone mine, Remove the swamp");
            case MINING:
                if (technologyCheck(MASONRY) &&
                        technologyCheck(BRONZE_WORKING) &&
                        !technologyCheck(MINING))
                    return new Technology("Mining", 35, "Agriculture", "Masonry, Bronze Working", "Mines, Remove forests");
            case POTTERY:
                if (technologyCheck(CALENDAR) &&
                        technologyCheck(WRITING) &&
                        !technologyCheck(POTTERY))
                    return new Technology("Pottery", 35, "Agriculture", "Calendar, Writing", "Granary");
            case THE_WEEL:
                if (technologyCheck(HORSEBACK_RIDING) &&
                        technologyCheck(MATHEMATICS) &&
                    !technologyCheck(THE_WEEL))
                return new Technology("The Wheel", 55, "Animal Husbandry", "Horseback Riding, Mathematics", "Chariot Archer, Water Mill, build a Road");
            case TRAPPING:
                if (technologyCheck(CIVIL_SERVICE) &&
                        !technologyCheck(TRAPPING))
                    return new Technology("Trapping", 55, "Animal Husbandry", "Civil Service", "Trading Post, Camp");
            case WRITING:
                if (technologyCheck(PHILOSOPHY) &&
                        !technologyCheck(WRITING))
                    return new Technology("Writing", 55, "Pottery", "Philosophy", "Library");
            case CONSTRUCTION:
                if (technologyCheck(ENGINEERING) &&
                        !technologyCheck(CONSTRUCTION))
                    return new Technology("Construction", 100, "Masonry", "Engineering", "Colosseum, bridges over rivers");
            case HORSEBACK_RIDING:
                if (technologyCheck(CHIVALRY) &&
                        !technologyCheck(HORSEBACK_RIDING))
                    return new Technology("Horseback Riding", 100, "The Wheel", "Chivalry", "Horseman, Stable, Circus");
            case IRON_WORKING:
                if (technologyCheck(METAL_CASTING) &&
                        !technologyCheck(IRON_WORKING))
                    return new Technology("Iron Working", 150, "Bronze Working", "Metal Casting", "Swordsman, Legion, Armory, Iron");
            case MATHEMATICS:
                if (technologyCheck(CURRENCY) &&
                        technologyCheck(ENGINEERING) &&
                        !technologyCheck(MATHEMATICS))
                return new Technology("Mathematics", 100, "The Wheel, Archery", "Currency, Engineering", "Catapult, Courthouse");
            case PHILOSOPHY:
                if (technologyCheck(THEOLOGY) &&
                        technologyCheck(CIVIL_SERVICE) &&
                        !technologyCheck(PHILOSOPHY))
                    return new Technology("Philosophy", 100, "Writing", "Theology, Civil Service", "Burial Tomb, Temple");
            case CHIVALRY:
                if (technologyCheck(BANKING) &&
                        !technologyCheck(CHIVALRY))
                    return new Technology("Chivalry", 440, "Civil Service, Horseback Riding, Currency", "Banking", "Knight, Camel Archer, Castle");
            case CIVIL_SERVICE:
                if (technologyCheck(CHIVALRY) &&
                        !technologyCheck(CIVIL_SERVICE))
                    return new Technology("Civil Service", 400, "Philosophy, Trapping", "Chivalry", "Pikeman");
            case CURRENCY:
                if (technologyCheck(CHIVALRY) &&
                        !technologyCheck(CURRENCY))
                    return new Technology("Currency", 250, "Mathematics", "Chivalry", "Market");
            case ENGINEERING:
                if (technologyCheck(MACHINERY) &&
                        technologyCheck(PHYSICS) &&
                        !technologyCheck(ENGINEERING))
                    return new Technology("Engineering", 250, "Mathematics, Construction", "Machinery, Physics", "");
            case MACHINERY:
                if (technologyCheck(PRINTING_PRESS) &&
                        !technologyCheck(MACHINERY))
                    return new Technology("Machinery", 440, "Engineering", "Printing Press", "Crossbowman, 1.2 faster road movement");
            case METAL_CASTING:
                if (technologyCheck(PHYSICS) &&
                        technologyCheck(STEEL) &&
                        !technologyCheck(METAL_CASTING))
                    return new Technology("Metal Casting", 240, "Iron Working", "Physics, Steel", "Forge, Workshop");
            case PHYSICS:
                if (technologyCheck(PRINTING_PRESS) &&
                        technologyCheck(GUNPOWDER) &&
                        !technologyCheck(PHYSICS))
                    return new Technology("Physics", 440, "Engineering, Metal Casting", "Printing Press, Gunpowder", "Trebuchet");
            case STEEL:
                if (technologyCheck(GUNPOWDER) &&
                        !technologyCheck(STEEL))
                    return new Technology("Steel", 440, "Metal Casting", "Gunpowder", "Longswordsman");
            case THEOLOGY:
                if (technologyCheck(EDUCATION) &&
                        !technologyCheck(THEOLOGY))
                    return new Technology("Theology", 250, "Calendar, Philosophy", "Education", "Monastery, Garden");
            case ACOUSTICS:
                if (technologyCheck(SCIENTIFIC_TEHEORY) &&
                        !technologyCheck(ACOUSTICS))
                    return new Technology("Acoustics", 650, "Education", "Scientific Theory", "");
            case ARCHAEOLOGY:
                if (technologyCheck(BIOLOGY)  &&
                        !technologyCheck(ARCHAEOLOGY) )
                    return new Technology("Archaeology", 1300, "Acoustics", "Biology", "Museum");
            case BANKING:
                if (technologyCheck(ECONOMICS) &&
                        !technologyCheck(BANKING) )
                    return new Technology("Banking", 650, " Education, Chivalry", "Economics", "Satrap’s Court, Bank");
            case CHEMISTRY:
                if (technologyCheck(MILITARY_SCIENCE) &&
                        technologyCheck(FERTILIZER) &&
                        !technologyCheck(CHEMISTRY))
                    return new Technology("Chemistry", 900, "Gunpowder", "Military Science, Fertilize", "Ironworks");
            case ECONOMICS:
                if (technologyCheck(MILITARY_SCIENCE) &&
                        !technologyCheck(ECONOMICS))
                    return new Technology("Economics", 900, "Banking, Printing Press", "Military Science", "Windmill");
            case FERTILIZER:
                if (technologyCheck(DYNAMITE) &&
                        !technologyCheck(FERTILIZER))
                    return new Technology("Fertilizer", 1300, "Chemistry", "Dynamite", "Farms without Fresh Water yield increased by 1");
            case GUNPOWDER:
                if (technologyCheck(CHEMISTRY) &&
                        technologyCheck(METALLURGY) &&
                        !technologyCheck(GUNPOWDER))
                    return new Technology("Gunpowder", 680, "Physics, Steel", "Chemistry, Metallurgy", "Musketman");
            case METALLURGY:
                if (technologyCheck(RIFLING) &&
                        !technologyCheck(METALLURGY))
                    return new Technology("Metallurgy", 900, "Gunpowder", "Rifling", "Lancer");
            case MILITARY_SCIENCE:
                if (technologyCheck(STEAM_POWER) &&
                        !technologyCheck(MILITARY_SCIENCE))
                    return new Technology("Military Science", 1300, "Economics, Chemistry", "Steam Power ", "Cavalry, Military Academy");
            case PRINTING_PRESS:
                if (technologyCheck(ECONOMICS) &&
                        !technologyCheck(PRINTING_PRESS))
                    return new Technology("Printing Press", 650, "Machinery, Physics", "Economics", "Theater");
            case RIFLING:
                if (technologyCheck(DYNAMITE) &&
                        !technologyCheck(RIFLING))
                    return new Technology("Rifling", 1425, "Metallurgy", "Dynamite", "Rifleman");
            case SCIENTIFIC_TEHEORY:
                if (technologyCheck(BIOLOGY) &&
                        technologyCheck(STEAM_POWER) &&
                        !technologyCheck(SCIENTIFIC_TEHEORY))
                    return new Technology("Scientific Theory", 1300, "Acoustics", "Biology, Steam Power", "Public School, Coal");
            case BIOLOGY:
                if (technologyCheck(ELECTRICITY) &&
                        !technologyCheck(BIOLOGY))
                    return new Technology("Biology", 1680, "Archaeology, Scientific Theory", "Electricity", "");
            case COMBUSTION:
                if (!technologyCheck(COMBUSTION))
                    return new Technology("Combustion", 2200, "Replaceable Parts, Railroad, Dynamite", "", "Tank, Panzer");
            case DYNAMITE:
                if (technologyCheck(COMBUSTION) &&
                        !technologyCheck(DYNAMITE))
                    return new Technology("Dynamite", 1900, "Fertilizer, Rifling", "Combustion", "Artillery");
            case ELECTRICITY:
                if (technologyCheck(TELEGRAPH) &&
                        technologyCheck(RADIO) &&
                        !technologyCheck(ELECTRICITY))
                    return new Technology("Electricity", 1900, "Biology, Steam Power", "Telegraph, Radio", "Stock Exchange");
            case RADIO:
                if (!technologyCheck(RADIO))
                    return new Technology("Radio", 2200, "Electricity", "", "Broadcast Tower");
            case RAIL_ROAD:
                if (technologyCheck(COMBUSTION) &&
                        !technologyCheck(RAIL_ROAD))
                    return new Technology("Railroad", 1900, "Steam Power", "Combustion", "Arsenal, Railroad ");
            case REPLACEABLE_PARTS:
                if (technologyCheck(COMBUSTION) &&
                        !technologyCheck(REPLACEABLE_PARTS))
                    return new Technology("Replaceable Parts", 1900, "Steam Power", "Combustion", "Anti-Tank Gun, Infantry");
            case STEAM_POWER:
                if (technologyCheck(ELECTRICITY) &&
                        technologyCheck(REPLACEABLE_PARTS) &&
                        technologyCheck(RAIL_ROAD) &&
                        !technologyCheck(STEAM_POWER))
                    return new Technology("Steam Power", 1680, "Scientific Theory, Military Science", "Electricity, Replaceable Parts, Railroad", "Factory");
            case TELEGRAPH:
                if (!technologyCheck(TELEGRAPH))
                    return new Technology("Telegraph", 2200, "Electricity", "", "Military Base");
            case EDUCATION:
                if (technologyCheck(ACOUSTICS) &&
                        technologyCheck(BANKING) &&
                        !technologyCheck(EDUCATION))
                    return new Technology("Education", 440, "Theology", "Acoustics, Banking", "University");
        }
        return null;
    }
}
