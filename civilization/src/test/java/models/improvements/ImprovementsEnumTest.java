package models.improvements;

import enums.ImprovementsEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImprovementsEnumTest {

    @Test
    public void getImprovementsTest1() {
        assertEquals(ImprovementsEnum.getImprovements(ImprovementsEnum.MINE), null);
    }
/*    @Test
    public void getImprovementsTest2() {
        Improvement improvement = new Improvement("Mine",0, 1, 0);
        when(TechsEnum.technologyCheck(TechsEnum.MINING)).thenReturn(true);
        assertEquals(ImprovementsEnum.getImprovements(ImprovementsEnum.MINE), improvement);
    }*/
}
