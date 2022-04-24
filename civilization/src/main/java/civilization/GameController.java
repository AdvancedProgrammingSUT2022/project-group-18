package civilization;

import enums.UnitEnum;
import model.unit.*;

public class GameController extends Controller{

    public static Unit get(UnitEnum regex) {
        switch (regex) {
            case ARCHER:
                if (CheckRequireds.archeryCheck())
                    return new Ranged("Archer", 2, 4, 6, 2, 70, true, false);
            case CHARIOTARCHER:
                if (CheckRequireds.chariotArcherCheck())
                    return new Ranged("ChariotArcher", 4, 3, 6, 2, 60, true, false);
            case SCOUT:
                return new Melee("Scout", 2, 4, 25, true);
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
                    return new Ranged("Catapult", 2, 4, 14, 2, 100, true, false);
            case HORSEMAN:
                if (CheckRequireds.horsemanCheck())
                    return new Ranged("Horseman", 4, 12, 0, 0, 80, true, false); ////i dont know
            case SWORDSMAN:
                if (CheckRequireds.swordsmanCheck())
                    return new Melee("Swordsman", 2, 11, 80, true);
            case CROSSBOWMAN:
                if (CheckRequireds.crossbowmanCheck())
                    return new Ranged("Crossbowman", 2, 6, 12, 2, 120, true, false);
            case KNIGHT:
                if (CheckRequireds.knightCheck())
                    return new Ranged("Knight", 3, 18, 0, 0, 150, true, false);
            case LONGSWORDSMAN:
                if (CheckRequireds.longswordsmanCheck())
                    return new Melee("Longswordsman", 3, 18, 150, true);
            case PIKEMAN:
                if (CheckRequireds.pikemanCheck())
                    return new Melee("Pikeman", 2, 10, 100, true);
            case TREBUCHET:
                if (CheckRequireds.trebuchetCheck())
                    return new Ranged("Trebuchet", 2, 6, 20, 2, 170, true, false);
            case CANON:
                if (CheckRequireds.canonCheck())
                    return new Ranged("Canon", 2, 10, 26, 2, 250, true, false);
            case CAVALRY:
                if (CheckRequireds.cavalryCheck())
                    return new Ranged("Cavalry", 3, 25, 0, 0, 260, true, false);
            case LANCER:
                if (CheckRequireds.lancerCheck())
                    return new Ranged("Lancer", 4, 22, 0, 0, 220, true, false);
            case MUSKETMAN:
                if (CheckRequireds.musketmanCheck())
                    return new Ranged("Musketman", 2, 16, 0, 0, 120, true, false);
            case RIFLEMAN:
                if (CheckRequireds.riflemanCheck())
                    return new Ranged("Rifleman", 2, 25, 0, 0, 200, true, false);
            case ANTITANKGUN:
                if (CheckRequireds.antiTankGunCheck())
                    return new Ranged("Anti-Tank Gun", 2, 32, 0, 0, 300, true, false);
            case ARTILLERY:
                if (CheckRequireds.artilleryCheck())
                    return new Ranged("Artillery", 2, 16, 32, 3, 420, true, false);
            case INFANTRY:
                if (CheckRequireds.infantryCheck())
                    return new Ranged("Infantry", 2, 36, 0, 0, 300, true, false);
            case PANZER:
                if (CheckRequireds.panzerCheck())
                    return new Ranged("Panzer", 5, 60, 0, 0, 450, true, false);
            case TANK:
                if (CheckRequireds.tankCheck())
                    return new Ranged("Tank", 4, 50, 0, 0, 450, true, false);
            default:
                return new Ranged("Tank", 4, 50, 0, 0, 450, true, false);
        }
    }
}
