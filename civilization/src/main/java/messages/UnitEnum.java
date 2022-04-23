package messages;

import model.unit.*;

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
            case ARCHER:
                if (CheckRequireds.archeryCheck())
                    return new Ranged("Archer", 2, 4, 6, 2, 70, true, 0);
            case CHARIOTARCHER:
                if (CheckRequireds.chariotArcherCheck())
                    return new Ranged("ChariotArcher", 4, 3, 6, 2, 60, true, 0);
            case SCOUT:
                return new Melee("scout", 2, 4, 25, true);
            case SETTLER:
                return new Civilian("Settler", 2, 89);
            case SPEARMAN:
                if (CheckRequireds.spearmanCheck())
                    return new Melee("Spearman", 2, 7, 50, true);
            case WARRIOR:
                return new Melee("Warrior", 2, 6, 40, true);
            case WORKER:
                return new Civilian("Worker", 2, 70);
            case CATAPULT:
                if (CheckRequireds.catapultCheck())
                    return new Catapult();
            case HORSEMAN:
                if (CheckRequireds.horsemanCheck())
                    return new Horseman();
            case SWORDSMAN:
                if (CheckRequireds.swordsmanCheck())
                    return new Swordsman();
            case CROSSBOWMAN:
                if (CheckRequireds.crossbowmanCheck())
                    return new Crossbowman();
            case KNIGHT:
                if (CheckRequireds.knightCheck())
                    return new Knight();
            case LONGSWORDSMAN:
                if (CheckRequireds.longswordsmanCheck())
                    return new Longswordsman();
            case PIKEMAN:
                if (CheckRequireds.pikemanCheck())
                    return new Pikeman();
            case TREBUCHET:
                if (CheckRequireds.trebuchetCheck())
                    return new Trebuchet();
            case CANON:
                if (CheckRequireds.canonCheck()) return new Canon();
            case CAVALRY:
                if (CheckRequireds.cavalryCheck()) return new Cavalry();
            case LANCER:
                if (CheckRequireds.lancerCheck()) return new Lancer();
            case MUSKETMAN:
                if (CheckRequireds.musketmanCheck()) return new Musketman();
            case RIFLEMAN:
                if (CheckRequireds.riflemanCheck()) return new Rifleman();
            case ANTITANKGUN:
                if (CheckRequireds.antiTankGunCheck()) return new AntiTankGun();
            case ARTILLERY:
                if (CheckRequireds.artilleryCheck()) return new Artillery();
            case INFANTRY:
                if (CheckRequireds.infantryCheck()) return new Infantry();
            case PANZER:
                if (CheckRequireds.panzerCheck()) return new Panzer();
            case TANK:
                if (CheckRequireds.tankCheck()) return new Tank();
            default:
                return new Tank();
        }
    }
}