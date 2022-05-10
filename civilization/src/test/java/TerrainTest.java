import model.trrain.Terrain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TerrainTest {

    Terrain terrain = new Terrain(12, 23, 45, 33, 90, true);
    @Test
    public void getFoodTest () {
        assertEquals(terrain.getFood(), 12);
    }
    @Test
    public void getProductionTest() {
        assertEquals(terrain.getProduction(), 23);
    }

    @Test
    public void getCombatModifiers() {
        assertEquals(terrain.getCombatModifiers(), 45, 0.00);
    }

    @Test
    public void getGoldTest() {
        assertEquals(terrain.getGold(), 33);
    }

    @Test
    public void getMovementCostTest() {
        assertEquals(terrain.getMovementCost(), 90);
    }
}
