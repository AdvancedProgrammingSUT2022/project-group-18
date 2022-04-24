package controller;

import controller.Controller;
import enums.UnitEnum;
import model.unit.*;

public class GameController extends Controller {

    public static Unit get(UnitEnum regex) {
        switch (regex) {
            case ARCHER:
                if (UnitsCheckRequireds.archeryCheck())
                    return new Ranged("Archer", 2, 4, 6, 2, 70, true, false);
            case CHARIOTARCHER:
                if (UnitsCheckRequireds.chariotArcherCheck())
                    return new Ranged("ChariotArcher", 4, 3, 6, 2, 60, true, false);
            case SCOUT:
                return new Melee("Scout", 2, 4, 25, true);
            case SETTLER:
                return new Civilian("Settler", 2, 89);
            case SPEARMAN:
                if (UnitsCheckRequireds.spearmanCheck())
                    return new Melee("Spearman", 2, 7, 50, true);
            case WARRIOR:
                return new Melee("Warrior", 2, 6, 40, true);
            case WORKER:
                return new Civilian("Worker", 2, 70);
            case CATAPULT:
                if (UnitsCheckRequireds.catapultCheck())
                    return new Ranged("Catapult", 2, 4, 14, 2, 100, true, false);
            case HORSEMAN:
                if (UnitsCheckRequireds.horsemanCheck())
                    return new Melee("Horseman", 4, 12, 80, true);
            case SWORDSMAN:
                if (UnitsCheckRequireds.swordsmanCheck())
                    return new Melee("Swordsman", 2, 11, 80, true);
            case CROSSBOWMAN:
                if (UnitsCheckRequireds.crossbowmanCheck())
                    return new Ranged("Crossbowman", 2, 6, 12, 2, 120, true, false);
            case KNIGHT:
                if (UnitsCheckRequireds.knightCheck())
                    return new Melee("Knight", 3, 18, 150, true);
            case LONGSWORDSMAN:
                if (UnitsCheckRequireds.longswordsmanCheck())
                    return new Melee("Longswordsman", 3, 18, 150, true);
            case PIKEMAN:
                if (UnitsCheckRequireds.pikemanCheck())
                    return new Melee("Pikeman", 2, 10, 100, true);
            case TREBUCHET:
                if (UnitsCheckRequireds.trebuchetCheck())
                    return new Ranged("Trebuchet", 2, 6, 20, 2, 170, true, false);
            case CANON:
                if (UnitsCheckRequireds.canonCheck())
                    return new Ranged("Canon", 2, 10, 26, 2, 250, true, false);
            case CAVALRY:
                if (UnitsCheckRequireds.cavalryCheck())
                    return new Melee("Cavalry", 3, 25,  260, true);
            case LANCER:
                if (UnitsCheckRequireds.lancerCheck())
                    return new Melee("Lancer", 4, 22, 220, true);
            case MUSKETMAN:
                if (UnitsCheckRequireds.musketmanCheck())
                    return new Melee("Musketman", 2, 16,  120, true);
            case RIFLEMAN:
                if (UnitsCheckRequireds.riflemanCheck())
                    return new Melee("Rifleman", 2, 25,  200, true);
            case ANTITANKGUN:
                if (UnitsCheckRequireds.antiTankGunCheck())
                    return new Melee("Anti-Tank Gun", 2, 32,  300, true);
            case ARTILLERY:
                if (UnitsCheckRequireds.artilleryCheck())
                    return new Ranged("Artillery", 2, 16, 32, 3, 420, true, false);
            case INFANTRY:
                if (UnitsCheckRequireds.infantryCheck())
                    return new Melee("Infantry", 2, 36, 300, true);
            case PANZER:
                if (UnitsCheckRequireds.panzerCheck())
                    return new Melee("Panzer", 5, 60,  450, true);
            case TANK:
                if (UnitsCheckRequireds.tankCheck())
                    return new Melee("Tank", 4, 50,  450, true);
            default:
                return new Melee("Tank", 4, 50, 450, true);
        }
    }
}
