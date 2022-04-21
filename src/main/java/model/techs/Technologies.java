package model.techs;

public class Technologies {

    public Technology agriculture = new Technology("Agriculture", 20, "None", "Pottery, Animal Husbandry, Archery, Mining", "farm");
    public Technology animalHusbandry = new Technology("Animal Husbandry", 35, "Agriculture", "Trapping, The Wheel", "horse, Pasture");
    public Technology archery = new Technology("Archery", 35, "Agriculture", "Mathematics", "Archer");
    public Technology bronzeWorking = new Technology("Bronze Working", 55, "Mining", "Iron Working", "Spearman, Barracks, Remove massive forests");
    public Technology calendar = new Technology("Calendar", 70, "Pottery", "Theology", "Cultivation");
    public Technology masonry = new Technology("Masonry", 55, "Mining", "Construction", "Walls, Stone mine, Remove the swamp");
    public Technology mining = new Technology("Mining", 35, "Agriculture", "Masonry, Bronze Working", "Mines, Remove forests");
    public Technology pottery = new Technology("Pottery", 35, "Agriculture", "Calendar, Writing", "Granary");
    public Technology theWeel = new Technology("The Wheel", 55, "Animal Husbandry", "Horseback Riding, Mathematics", "Chariot Archer, Water Mill, build a Road");
    public Technology trapping = new Technology("Trapping", 55, "Animal Husbandry", "Civil Service", "Trading Post, Camp");
    public Technology writing = new Technology("Writing", 55, "Pottery", "Philosophy", "Library");


    public Technology construction = new Technology("Construction", 100, "Masonry", "Engineering", "Colosseum, bridges over rivers");
    public Technology horsebackRiding = new Technology("Horseback Riding", 100, "The Wheel", "Chivalry", "Horseman, Stable, Circus");
    public Technology ironWorking = new Technology("Iron Working", 150, "Bronze Working", "Metal Casting", "Swordsman, Legion, Armory, Iron");
    public Technology mathematics = new Technology("Mathematics", 100, "The Wheel, Archery", "Currency, Engineering", "Catapult, Courthouse");
    public Technology philosophy = new Technology("Philosophy", 100, "Writing", "Theology, Civil Service", "Burial Tomb, Temple");


    public Technology chivalry = new Technology("Chivalry", 440, "Civil Service, Horseback Riding, Currency", "Banking", "Knight, Camel Archer, Castle");
    public Technology civilService = new Technology("Civil Service", 400, "Philosophy, Trapping", "Chivalry", "Pikeman");
    public Technology currency = new Technology("Currency", 250, "Mathematics", "Chivalry", "Market");
    public Technology engineering = new Technology("Engineering", 250, "Mathematics, Construction", "Machinery, Physics", "");
    public Technology machinery = new Technology("Machinery", 440, "Engineering", "Printing Press", "Crossbowman, 1.2 faster road movement");
    public Technology metalCasting = new Technology("Metal Casting", 240, "Iron Working", "Physics, Steel", "Forge, Workshop");
    public Technology physics = new Technology("Physics", 440, "Engineering, Metal Casting", "Printing Press, Gunpowder", "Trebuchet");
    public Technology steel = new Technology("Steel", 440, "Metal Casting", "Gunpowder", "Longswordsman");
    public Technology theology = new Technology("Theology", 250, "Calendar, Philosophy", "Education", "Monastery, Garden");


    public Technology acoustics = new Technology("Acoustics", 650, "Education", "Scientific Theory", "");
    public Technology archaeology = new Technology("Archaeology", 1300, "Acoustics", "Biology", "Museum");
    public Technology banking = new Technology("Banking", 650, " Education, Chivalry", "Economics", "Satrap’s Court, Bank");
    public Technology chemistry = new Technology("Chemistry", 900, "Gunpowder", "Military Science, Fertilize", "Ironworks");
    public Technology economics = new Technology("Economics", 900, "Banking, Printing Press", "Military Science", "Windmill");
    public Technology fertilizer = new Technology("Fertilizer", 1300, "Chemistry", "Dynamite", "Farms without Fresh Water yield increased by 1");
    public Technology gunpowder = new Technology("Gunpowder", 680, "Physics, Steel", "Chemistry, Metallurgy", "Musketman");
    public Technology metallurgy =new Technology("Metallurgy", 900, "Gunpowder", "Rifling", "Lancer");
    public Technology militaryScience =new Technology("Military Science", 1300, "Economics, Chemistry", "Steam Power ", "Cavalry, Military Academy");
    public Technology printingPress =new Technology("Printing Press", 650, "Machinery, Physics", "Economics", "Theater");
    public Technology rifling =new Technology("Rifling", 1425, "Metallurgy", "Dynamite", "Rifleman");
    public Technology scientificTheory =new Technology("Scientific Theory", 1300, "Acoustics", "Biology, Steam Power", "Public School, Coal");


    public Technology biology =new Technology("Biology", 1680, "Archaeology, Scientific Theory", "Electricity", "");
    public Technology combustion =new Technology("Combustion", 2200, "Replaceable Parts, Railroad, Dynamite", "", "Tank, Panzer");
    public Technology dynamite =new Technology("Dynamite", 1900, "Fertilizer, Rifling", "Combustion", "Artillery");
    public Technology electricity =new Technology("Electricity", 1900, "Biology, Steam Power", "Telegraph, Radio", "Stock Exchange");
    public Technology radio =new Technology("Radio", 2200, "Electricity", "", "Broadcast Tower");
    public Technology railroad =new Technology("Railroad", 1900, "Steam Power", "Combustion", "Arsenal, Railroad ");
    public Technology replaceableParts  =new Technology("Replaceable Parts", 1900, "Steam Power", "Combustion", "Anti-Tank Gun, Infantry");
    public Technology steamPower =new Technology("Steam Power", 1680, "Scientific Theory, Military Science", "Electricity, Replaceable Parts, Railroad", "Factory");
    public Technology telegraph =new Technology("Telegraph", 2200, "Electricity", "", "Military Base");

    public Technology education = new Technology("Education", 440, "Theology", "Acoustics, Banking", "University");


}
