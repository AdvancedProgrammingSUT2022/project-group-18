package civilization;

import enums.Message;
import model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registermenu extends Controller{
    private static Registermenu instance = null;

    public static void setInstance(Registermenu instance) {
        Registermenu.instance = instance;
    }

    public static Registermenu getInstance() {
        if (Registermenu.instance == null) {
            Registermenu.setInstance(new Registermenu());
        }

        return Registermenu.instance;
    }

    public void run() {
        String choice = this.getInput();
        if (choice.equals("Exit")) {
            this.Exit();
        }
        if (choice.startsWith("register")) {
            if (choice.contains("admin")) {
                String regex = "^register\\s+as\\s+admin\\s+(?<username>\\S*)\\s+(?<password>\\S*)$";
                this.adminRegister(getCommandMatcher(choice, regex));
            } else {
                String regex = "^register\\s+(?<username>\\S*)\\s+(?<password>\\S*)$";
                this.register(getCommandMatcher(choice, regex));
            }
        } else if (choice.startsWith("login")) {
            String regex = "^login\\s+(?<username>\\S*)\\s+(?<password>\\S*)$";
            this.login(choice, regex);
        } else if (choice.startsWith("change")) {
            String regex = "^change\\s+password\\s+(?<username>\\S*)\\s+(?<oldpassword>\\S*)\\s+(?<newpassword>\\S*)$";
            this.passchange(getCommandMatcher(choice, regex));
        } else if (choice.startsWith("remove")) {
            String regex = "^remove\\s+account\\s+(?<username>\\S*)\\s+(?<password>\\S*)$";
            this.deletaccount(choice, regex);
        } else {
            System.out.println(Message.INVALID);
            this.run();
        }
    }


    private void Exit() {
        System.exit(0);
    }

    private static Matcher getCommandMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            return matcher;
        }
        return null;
    }

    public void adminRegister(Matcher matcher) {
        if (matcher == null) System.out.println(Message.INVALID);
        else {
            if (admin != null) System.out.println("admin user already created");
            else {
                String username = matcher.group("username");
                String password = matcher.group("password");
                Message message = controller.adminGetRegisted(username, password);
                if (message == Message.adminRegisterSuccessfully)
                    admin = new Admin(username, password);
                System.out.println(message);
            }
        }
        this.run();
    }

    public void register(Matcher matcher) {
        if (matcher == null) System.out.println(Message.Invalid);
        else {
            String username = matcher.group("username");
            String password = matcher.group("password");
            System.out.println(controller.getrigsted(username, password));
        }
        this.run();
    }

    public void login(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String username = new String();
        String password = new String();
        boolean isValid = false;
        while (matcher.find()) {
            isValid = true;
            username = matcher.group("username");
            password = matcher.group("password");
        }
        if (!isValid) System.out.println(Message.Invalid);
        else {
            Message message = this.controller.loginHandel(username, password);
            System.out.println(message);
            if (message == Message.successefullyLogin) {
                User user = User.getUserByUsername(username);
                Menu.setLoggedInUser(user);
                mainMenu.getInstance().run();
            } else this.run();
        }
    }

    public void passchange(Matcher matcher) {
        boolean isValid = false;
        if (matcher == null) System.out.println(Message.Invalid);
        else {
            String username = matcher.group("username");
            String oldPass = matcher.group("oldpassword");
            String newPass = matcher.group("newpassword");
            System.out.println(controller.passChange(username, oldPass, newPass));
        }

        this.run();
    }

    public void deletaccount(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String username = new String();
        String password = new String();
        boolean isValid = false;
        while (matcher.find()) {
            isValid = true;
            username = matcher.group("username");
            password = matcher.group("password");
        }
        if (!isValid) System.out.println(Message.Invalid);
        else {
            Message message = this.controller.deletAccount(username, password);
            if (message == Message.removeSuccessefully) {
                if (admin != null && admin.getUsername().equals(username) && admin.getPassword().equals(password))
                    admin = null;
            }
            System.out.println(message);
        }
        this.run();
    }

    public static Admin getAdmin() {
        return admin;
    }
}
