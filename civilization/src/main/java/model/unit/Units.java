package model.unit;

public class Units {
    //protected String combatType;
    protected String name;
    protected int movement;
//    protected int movementTemp;
//    protected int movementPotential;
    protected int combatStrength = 0;
    protected int combatStrengthRanged = 0;
    protected int ranged = 1;
    protected int health = 10;
    protected int productionCost=0;
    protected boolean isMilitary = false;
    protected boolean isMoving = false;
    protected boolean isAttacking = false;
    protected boolean hasTerrainCost = true;

    public enum UnitEnum {
        ARCHER,
        CHARIOTARCHER,
        SCOUT,
        SETTLER,
        SPEARMAN,
        WARRIOR,
        WORKER,
        CATAPULT,
        HORSEMAN,
        SWORDSMAN,
        CROSSBOWMAN,
        KNIGHT,
        LONGSWORDSMAN,
        PIKEMAN,
        TREBUCHET,
        CANON,
        CAVALRY,
        LANCER,
        MUSKETMAN,
        RIFLEMAN,
        ANTITANKGUN,
        ARTILLERY,
        INFANTRY,
        PANZER,
        TANK;
        public Unit get() {
            switch (this) {
                case ARCHER : if(CheckRequireds.archeryCheck())
                    return new Ranged("Archer",2,4,6,2,70,true,0);
                case CHARIOTARCHER : if(CheckRequireds.chariotArcherCheck())
                    return new Ranged("ChariotArcher",4,3,6,2,60,true,0);
                case SCOUT :
                    return new Melee("scout",2,4,25,true);
                case SETTLER :
                    return new Civilian("Settler",2,89);
                case SPEARMAN: if(CheckRequireds.spearmanCheck())
                    return new Melee("Spearman",2,7,50,true);
                case WARRIOR:
                    return new Melee("Warrior",2,6,40,true);
                case WORKER :
                    return new Civilian("Worker",2,70);
                case CATAPULT : if(CheckRequireds.catapultCheck())
                    return new Catapult();
                case HORSEMAN : if(CheckRequireds.horsemanCheck())
                    return new Horseman();
                case SWORDSMAN : if(CheckRequireds.swordsmanCheck())
                    return new Swordsman();
                case CROSSBOWMAN : if(CheckRequireds.crossbowmanCheck())
                    return new Crossbowman();
                case KNIGHT : if(CheckRequireds.knightCheck())
                    return new Knight();
                case LONGSWORDSMAN : if(CheckRequireds.longswordsmanCheck())
                    return new Longswordsman();
                case PIKEMAN : if(CheckRequireds.pikemanCheck())
                    return new Pikeman();
                case TREBUCHET : if(CheckRequireds.trebuchetCheck())
                    return new Trebuchet();
                case CANON : if(CheckRequireds.return new Canon();
                case CAVALRY :if(CheckRequireds.return new Cavalry();
                case LANCER :if(CheckRequireds.return new Lancer();
                case MUSKETMAN :if(CheckRequireds.return new Musketman();
                case RIFLEMAN : if(CheckRequireds.return new Rifleman();
                case ANTITANKGUN : if(CheckRequireds.return new AntiTankGun();
                case ARTILLERY : if(CheckRequireds.return new Artillery();
                case INFANTRY : if(CheckRequireds.return new Infantry();
                case PANZER : if(CheckRequireds.return new Panzer();
                case TANK : if(CheckRequireds.return new Tank();
                default: return new Tank();
            }
        }
    }

}
