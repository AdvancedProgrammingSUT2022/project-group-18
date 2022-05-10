import enums.Regexes;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RegexesTest {
    @Test
    public void getCommandTest1() {
        assertNotNull(Regexes.getCommand("menu show-current", Regexes.SHOW_CURRENT_MENU));
    }
    @Test
    public void getCommandTest2() {
        assertNull(Regexes.getCommand("increase -turn 23", Regexes.INCREASE_TURN));
    }
}
