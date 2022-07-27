package client.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class LoginDialog {
    public TextField nicknameField;
    public Label errorLabel;
    private Callback onFinish;

    public LoginDialog(Callback onFinish) {
        this.onFinish = onFinish;
    }


    public void confirmClicked() {
        String nickname = nicknameField.getText();
        if (nickname.length() < 3) {
            errorLabel.setText("Nickname should be at least 3 characters");
        }
        Database.getInstance().setNickname(nickname);
        onFinish.call(null);
    }
}

