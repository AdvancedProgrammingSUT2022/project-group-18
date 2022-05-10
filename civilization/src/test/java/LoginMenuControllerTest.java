import controller.LoginMenuController;
import enums.Regexes;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Objects;
import java.util.regex.Matcher;

import static org.junit.Assert.assertEquals;


public class LoginMenuControllerTest {

    @Mock
    Matcher matcher;


    @Test
    public void creatUserTest1() {
        LoginMenuController controller = new LoginMenuController();
        assertEquals(controller.creatUser(Objects.requireNonNull(Regexes.getCommand("user create -u (?<username>.*) -p (?<password>.*) -n (?<nickname>.*)", Regexes.CREAT_USER12))), "user create successfully!");
    }


}
