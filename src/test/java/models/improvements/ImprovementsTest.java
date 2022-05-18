package models.improvements;

import model.improvements.Improvement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImprovementsTest {
    Improvement improvement = new Improvement("fatemeh", 34, 23, 2);

    @Test
    public void getName() {
        assertEquals(improvement.getName(), "fatemeh");
    }

    @Test
    public void getFoodTest() {
        assertEquals(improvement.getFood(), 34);
    }

    @Test
    public void getProductionTest() {
        assertEquals(improvement.getProduction(), 23);
    }

    @Test
    public void getGoldTest() {
        assertEquals(improvement.getGold(), 2);
    }
}
